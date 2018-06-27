package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
    @RequestMapping("Bookings")
    public class BookingController {

    private List<Booking> bookings = new LinkedList<>();

    @GetMapping
    public List<Booking> list(){
        return bookings;
    }

    @PostMapping
    public Booking create(@RequestBody Booking newBooking){
        this.bookings.add(newBooking);
        return newBooking;
    }
}