package com.zappos.lyu.rest;

import com.zappos.lyu.domain.Restaurant;
import com.zappos.lyu.domain.RestaurantRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnlineFoodOrderingRestController {

    @GetMapping("/")
    public String test() {
        return "Hello World!";
    }

}
