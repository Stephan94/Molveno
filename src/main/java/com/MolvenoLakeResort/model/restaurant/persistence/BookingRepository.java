package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.Booking;
import com.MolvenoLakeResort.model.restaurant.Guest;
import com.MolvenoLakeResort.model.restaurant.Table;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class BookingRepository { //fill repo in constructor or controller?

    private Map<Long, Booking> bookings = new HashMap<>();
    private static long lastId = 0;

    private GuestRepository guests = new GuestRepository();


    //  TODO add autowired Table repo and guest repo
    @PostConstruct
    public void preFillRecords(){
//        for (int i = 0; i < 4; i++){
//            this.add(new Booking(guests.findById(i), tables.findById(i) ) );
//        }

//        this.add(new Booking((new Table(2,2)),new Guest("Test","Test","06186793884")));
//        this.add(new Booking((new Table(9,4)),new Guest("Test2","Test2","06186793885")));
//        this.add(new Booking((new Table(7,6)),new Guest("Test3","Test3","06186793881")));

//        this.add(new Booking((new Table(3,6)),new Guest("Test3","Test3","06186793881"),new GregorianCalendar(2018 + 1900,10,10)));

    }



    public void add(Booking newBooking) {
        newBooking.setId(++lastId);
        this.bookings.put(newBooking.getId(), newBooking);
    }

    public Booking findById(long id) {
        return this.bookings.get(id);
}

    public void removeById(long id) {
        this.bookings.remove(id);
    }

    public Collection<Booking> findAll() {
        return this.bookings.values();
    }

    public Booking update(long id, Booking updated){

        Booking target = this.findById(id);

        target.setDate(updated.getDate());
        target.setGuest(updated.getGuest());
        target.setTable(updated.getTable());

        return target;
    }

    public void searchByCapacityAndTime(){
        findAll();
    }
}