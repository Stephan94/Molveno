package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.Booking;
import com.MolvenoLakeResort.model.restaurant.Guest;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookingRepository { //fill repo in sonstructor or controller?

    private Map<Long, Booking> bookings = new HashMap<>();
    private static long lastId = 0;

    private GuestRepository guests = new GuestRepository();
    private TableRepository tables = new TableRepository();


    //  TODO add autowired Table repo and guest repo
    @PostConstruct
    public void preFillRecords(){
        for (int i = 0; i < 4; i++){
            this.add(new Booking(guests.findById(i), tables.findById(i) ) );
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
}