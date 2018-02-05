package com.zappos.lyu.rest;

import com.zappos.lyu.domain.Menu;
import com.zappos.lyu.domain.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuRepository mr;

    @GetMapping("/")
    public List<Menu> getMenus() {
        return mr.findAll();
    }

    @GetMapping("/{id}")
    public Menu findMenuById(@PathVariable("id") Long id) {
        return mr.findOne(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Menu> menuList) {
        mr.save(menuList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        mr.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        mr.delete(id);
    }
}
