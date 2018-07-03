package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.MenuItem;
import com.MolvenoLakeResort.model.restaurant.persistence.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/menuItems")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @PostMapping
    public MenuItem create(@RequestBody MenuItem newMenuItem){
        this.menuItemRepository.add(newMenuItem);
        return newMenuItem;
    }

    @GetMapping
    public Collection<MenuItem> list(){
        return this.menuItemRepository.findAll();
    }

    @GetMapping("{id}")
    public MenuItem findById(@PathVariable long id){
        return  this.menuItemRepository.findById(id);
    }

    @PutMapping("{id}")
    public MenuItem updateById(@PathVariable long id, @RequestBody MenuItem update){
        return this.menuItemRepository.update(id, update);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        this.menuItemRepository.removeById(id);
    }

}