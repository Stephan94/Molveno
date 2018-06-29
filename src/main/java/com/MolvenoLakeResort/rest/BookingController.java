package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
    @RequestMapping("Bookings")
    public class BookingController {

    private List<Booking> bookings = new LinkedList<>();
    private List<Booking> searchResultByCapcityAndTime;

    @GetMapping
    public List<Booking> list(){
        return bookings;
    }

    @GetMapping("{capacity}/{date}") //date input : "2010-06-25T14:25"
    public List<Booking> searchResultByCapcityAndTime(){
        return searchResultByCapcityAndTime;
    }

    @PostMapping
    public Booking create(@RequestBody Booking newBooking){
        this.bookings.add(newBooking);
        return newBooking;
    }
}