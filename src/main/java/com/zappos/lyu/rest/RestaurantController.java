package com.zappos.lyu.rest;

import com.zappos.lyu.domain.Menu;
import com.zappos.lyu.domain.MenuRepository;
import com.zappos.lyu.domain.Restaurant;
import com.zappos.lyu.domain.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository cr;

    @Autowired
    private MenuRepository mr;

    @RequestMapping("/")
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = cr.findAll();
        log.info("Fetch all: " + restaurants);
        return restaurants;
    }

    @RequestMapping("/{id}")
    public Restaurant findRestaurantById(@PathVariable("id") Long id) {
        return cr.findOne(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Restaurant> restaurants) {
        log.info("save restaurants: " + restaurants);
        cr.save(restaurants);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        cr.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        cr.delete(id);
    }

    @RequestMapping("/{id}/menus/")
    public List<Menu> getMenus(@PathVariable("id") Long id) {
        Restaurant rest = cr.findOne(id);
        if (rest != null)
            return mr.findByRestaurant_Id(id);
        return new LinkedList<Menu>();
    }

    @PostMapping("/{id}/menus/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenus(@PathVariable("id") Long id, @RequestBody List<Menu> menus) {
        Restaurant rest = cr.findOne(id);
        if (rest == null)
            return ;

        for(Menu m : menus)
            m.setRestaurant(rest);
        mr.save(menus);
    }

    @DeleteMapping("/{id}/menus/")
    public void deleteMenus(@PathVariable("id") Long id) {
        Restaurant rest = cr.findOne(id);
        if (rest == null)
            return ;
        mr.deleteByRestaurant_Id(rest.getId());
    }

}
