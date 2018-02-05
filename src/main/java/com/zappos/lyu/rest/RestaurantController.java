package com.zappos.lyu.rest;

import com.zappos.lyu.domain.Restaurant;
import com.zappos.lyu.domain.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository cr;

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
}
