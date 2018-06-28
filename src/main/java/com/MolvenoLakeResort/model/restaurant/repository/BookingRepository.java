package com.MolvenoLakeResort.model.restaurant.repository;

import com.MolvenoLakeResort.model.restaurant.Booking;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookingRepository { //fill repo in sonstructor or controller?

    private Map<Long, Booking> bookings = new HashMap<>();
    private static long lastId = 0;

    //  TODO add autowired Table repo and guest repo
    @PostConstruct
    public void preFillRecords(){
        for (int i = 0; i < 10; i++){
            Booking booking = new Booking(); //TODO insert valid bookings (probably fix table and guest repos first)
        }
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

    public Collection<Booking> findAll(long id) {
        return this.bookings.values();
    }

    public Booking update(long id, Booking updated){

        Booking target = this.findById(id);

        target.setDate(updated.getDate());
        target.setGuest(updated.getGuest());
        target.setTable(updated.getTable());

        return target;
    }
}