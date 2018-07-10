package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Booking;
import com.MolvenoLakeResort.model.restaurant.Guest;
import com.MolvenoLakeResort.model.restaurant.persistence.BookingRepository;
import com.MolvenoLakeResort.model.restaurant.persistence.GuestRepository;
import com.MolvenoLakeResort.model.restaurant.persistence.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingsRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private TableRepository tableRepository;

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody Booking newBooking) {

        // compare input firstname and lastname to guestrepo

       // this.guestRepository.findByFirstNameAndLAstName();

        newBooking.getGuest().getFirstName();
        newBooking.getGuest().getLastName();



        //go through the bookingsRepository and check whether there is already
        //a Booking with these details
        Optional<Booking> target = bookingsRepository.findByTable(newBooking.getTable());

        if (target.isPresent()) {
            Booking actualTarget = target.get();

            /*
            unclear code from the internet:
            target.filter(Booking.class::isInstance);
            target.map(Booking.class::cast);
             */

            if (actualTarget.getDate().equals(newBooking.getDate()) &&
                    actualTarget.getTime().equals(newBooking.getTime())) {

                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            else {
                this.bookingsRepository.save(newBooking);
                return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
            }
        }
        else {
            this.bookingsRepository.save(newBooking);
            return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
        }
    }


    @GetMapping
    public ResponseEntity<Iterable<Booking>> list() {
        return new ResponseEntity<Iterable<Booking>>(this.bookingsRepository.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Booking> findById(@PathVariable long id) {

        Optional<Booking> result = this.bookingsRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<Booking>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Booking> updateById(@PathVariable long id, @RequestBody Booking update) {

        Optional<Booking> possibleDirectObject = this.bookingsRepository.findById(id);

        if (possibleDirectObject.isPresent()) {
            Booking directObject = possibleDirectObject.get();

            directObject.setGuest(update.getGuest());
            directObject.setTable(update.getTable());
            directObject.setDate(update.getDate());
            directObject.setTime(update.getTime());

            directObject = this.bookingsRepository.save(directObject);


            //TODO : check: are we not doing double work here?
            //twice this.bookingsRepository.save()
            return new ResponseEntity<Booking>(this.bookingsRepository.save(directObject),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        this.bookingsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
// @GetMapping("{capacity}/{date}") //date input : "2010-06-25T14:25"
//public List<Booking> searchResultByCapcityAndTime(){
//   return searchResultByCapcityAndTime;
//}

// @GetMapping
//    public Collection<Booking> getAllBookings(){
//        return this.bookingsRepository.findAll();