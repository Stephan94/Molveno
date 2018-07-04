package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Guest;

import com.MolvenoLakeResort.model.restaurant.persistence.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @PostMapping
    public Guest create(@RequestBody Guest newGuest){
        this.guestRepository.add(newGuest);
        return newGuest;
    }

    @GetMapping
    public Collection<Guest> list(){
        return this.guestRepository.findAll();
    }

    @GetMapping("{id}")
    public Guest findById(@PathVariable long id){
        return this.guestRepository.findById(id);
    }

    @PutMapping("{id}")
    public Guest updateById(@PathVariable long id, @RequestBody Guest update){
        return this.guestRepository.update(id, update);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        this.guestRepository.removeById(id);
    }
}