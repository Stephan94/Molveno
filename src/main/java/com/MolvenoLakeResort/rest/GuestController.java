package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Guest;
import com.MolvenoLakeResort.model.restaurant.persistence.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @PostMapping
    public ResponseEntity<Guest> create(@RequestBody Guest newGuest) {
        Optional<Guest> possibleGuest = Optional.ofNullable(this.guestRepository.findByFirstName(newGuest.getFirstName()));

        if (possibleGuest.isPresent()) {
            Guest existingGuest = possibleGuest.get();

            if (existingGuest.getFirstName().equals(newGuest.getFirstName()) && existingGuest.getLastName().equals(newGuest.getLastName())) {
                return new ResponseEntity<Guest>(HttpStatus.CONFLICT);
            } else {

                return new ResponseEntity<Guest>(this.guestRepository.save(newGuest), HttpStatus.CREATED);

            }

        } else {

            return new ResponseEntity<Guest>(this.guestRepository.save(newGuest), HttpStatus.CREATED);
        }

    }

    @GetMapping
    public ResponseEntity<Iterable<Guest>> list() {
        return new ResponseEntity<Iterable<Guest>>(this.guestRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Guest> findById(@PathVariable long id) {
        Optional<Guest> possibleGuest = this.guestRepository.findById(id);

        if (possibleGuest.isPresent()) {
            return new ResponseEntity<Guest>(possibleGuest.get(), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PutMapping("{id}")
    public ResponseEntity<Guest> updateById(@PathVariable long id, @RequestBody Guest update) {
        Optional<Guest> possibleGuest = this.guestRepository.findById(id);

        if (possibleGuest.isPresent()) {
            Guest guest = possibleGuest.get();
            guest.setFirstName(update.getFirstName());
            guest.setLastName(update.getLastName());
            guest.setPhoneNumber(update.getPhoneNumber());

            return new ResponseEntity<Guest>(this.guestRepository.save(guest), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Guest> deleteById(@PathVariable long id) {
        Optional<Guest> possibleGuest = this.guestRepository.findById(id);

        if (possibleGuest.isPresent()) {
            this.guestRepository.deleteById(id);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }

}

