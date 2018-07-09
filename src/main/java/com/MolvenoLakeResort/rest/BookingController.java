package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Booking;
import com.MolvenoLakeResort.model.restaurant.Guest;
import com.MolvenoLakeResort.model.restaurant.persistence.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
    @RequestMapping("api/bookings")

    public class BookingController {

    @Autowired
    private BookingRepository bookingsRepository;

    @PostMapping
    public Booking create(@RequestBody Booking newBooking){
        this.bookingsRepository.add(newBooking);
        return newBooking;
    }

    @GetMapping
    public Collection<Booking> list(){
        return this.bookingsRepository.findAll();
    }

    @GetMapping("{id}")
    public Booking findById(@PathVariable long id){
        return this.bookingsRepository.findById(id);
    }

    @PutMapping("{id}")
    public Booking updateById(@PathVariable long id, @RequestBody Booking update){
        System.out.println(update);
        return this.bookingsRepository.update(id, update);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id){
        this.bookingsRepository.removeById(id);
    }
}
// @GetMapping("{capacity}/{date}") //date input : "2010-06-25T14:25"
//public List<Booking> searchResultByCapcityAndTime(){
//   return searchResultByCapcityAndTime;
//}

// @GetMapping
//    public Collection<Booking> getAllBookings(){
//        return this.bookingsRepository.findAll();