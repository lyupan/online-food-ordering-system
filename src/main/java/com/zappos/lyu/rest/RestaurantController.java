package com.zappos.lyu.rest;

import com.zappos.lyu.domain.Restaurant;
import com.zappos.lyu.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository cr;

    @RequestMapping("/")
    public List<Restaurant> getRestaurants() {
        return cr.findAll();
    }

    @RequestMapping("/{id}")
    public Restaurant findRestaurantById(@PathVariable("id") Long id) {
        return cr.findOne(id);
    }

}
