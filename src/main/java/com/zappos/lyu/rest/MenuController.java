package com.zappos.lyu.rest;

import com.zappos.lyu.domain.Menu;
import com.zappos.lyu.domain.MenuItem;
import com.zappos.lyu.domain.MenuItemRepository;
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

    @Autowired
    private MenuItemRepository mir;

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
        log.info("Delete all menus: ");
        mr.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.info("Delte menu by id :" + id);
        mr.delete(id);
    }

    @RequestMapping("/{id}/items/")
    public List<MenuItem> getItems(@PathVariable("id") Long id) {
        Menu menu = mr.findOne(id);
        if (menu == null)
            return null;
        return mir.findByMenu_Id(id);
    }

    @PostMapping("/{id}/items/")
    public void addItems(@PathVariable("id") Long id,@RequestBody List<MenuItem> items) {
        Menu menu = mr.findOne(id);
        if (menu == null)
            return ;

        for (MenuItem item : items)
            item.setMenu(menu);

        mir.save(items);
    }
}
