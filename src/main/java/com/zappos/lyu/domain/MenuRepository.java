package com.zappos.lyu.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByRestaurant_Id(Long id);

    void deleteByRestaurant_Id(Long id);
}
