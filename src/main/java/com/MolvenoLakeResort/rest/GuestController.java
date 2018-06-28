package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Guest;
import com.MolvenoLakeResort.model.restaurant.persistence.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("Guests")
public class GuestController {



    @Autowired
    private GuestRepository guests;

    @GetMapping
    public Collection<Guest> list(){
        return guests.findAll();
    }

    @PostMapping
    public Guest create(@RequestBody Guest newGuest) {

        // check of al bestaat

        this.guests.add(newGuest);
        return newGuest;
    }
}