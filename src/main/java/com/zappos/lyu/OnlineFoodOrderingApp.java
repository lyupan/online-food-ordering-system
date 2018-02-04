package com.zappos.lyu;

import com.zappos.lyu.domain.Restaurant;
import com.zappos.lyu.domain.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineFoodOrderingApp {

    public static void main(String[] args) {
        SpringApplication.run(OnlineFoodOrderingApp.class, args);
    }

    @Bean
    public ApplicationRunner demo(RestaurantRepository cr) {
        return args -> {
            cr.save(new Restaurant(null,"Restaurant1", "Location1"));
            cr.save(new Restaurant(null, "Restauant2", "Location2"));
        };
    }
}
