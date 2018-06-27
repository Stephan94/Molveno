package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Guest;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("Guests")
public class GuestController {


    private List<Guest> guests = new LinkedList<>();

    @GetMapping
    public List<Guest> list(){
        return guests;
    }

    @PostMapping
    public Guest create(@RequestBody Guest newGuest) {
        this.guests.add(newGuest);
        return newGuest;

    }
}