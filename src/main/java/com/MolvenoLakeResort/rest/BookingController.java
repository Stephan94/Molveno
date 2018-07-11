package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Booking;
import com.MolvenoLakeResort.model.restaurant.Guest;
import com.MolvenoLakeResort.model.restaurant.Table;
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

        Optional<Guest> possibleGuest = guestRepository.findByFirstNameAndLastName(newBooking.getGuest().getFirstName(), newBooking.getGuest().getLastName());

        if (possibleGuest.isPresent()) { //if guest already exists
            newBooking.setGuest(possibleGuest.get()); //match to new booking
        } else {
            //create new guest account if not found
            Guest newGuest = new Guest();
            newGuest.setFirstName(newBooking.getGuest().getFirstName());
            newGuest.setLastName(newBooking.getGuest().getLastName());
            newGuest.setPhoneNumber(newBooking.getGuest().getPhoneNumber());
            newBooking.setGuest(newGuest);
            this.guestRepository.save(newGuest);
        }

        Collection<Booking> bookingsByDateAndTime = this.bookingsRepository.findByDateAndTimeSlot(newBooking.getDate(), newBooking.getTimeSlot());

        List<Table> bookedTables = new ArrayList<>();
        for(Booking booking : bookingsByDateAndTime){
            bookedTables.add(booking.getTable());
        }

        List<Table> fittingTables = this.tableRepository.findAllByCapacityGreaterThanEqualOrderByCapacityAsc(newBooking.getTable().getCapacity());

        fittingTables.removeAll(bookedTables);

        if(fittingTables.size() > 0){
            newBooking.setTable(fittingTables.get(0));
            this.bookingsRepository.save(newBooking);
            return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
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
            directObject.setTimeSlot(update.getTimeSlot());

            directObject = this.bookingsRepository.save(directObject);


            //TODO : check: are we not doing double work here?
            //twice this.bookingsRepository.save()
            return new ResponseEntity<Booking>(this.bookingsRepository.save(directObject),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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