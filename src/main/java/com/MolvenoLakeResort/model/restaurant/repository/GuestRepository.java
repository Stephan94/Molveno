package com.MolvenoLakeResort.model.restaurant.repository;

import com.MolvenoLakeResort.model.restaurant.Booking;
import com.MolvenoLakeResort.model.restaurant.Guest;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GuestRepository {

    private Map<Long, Guest> guests = new HashMap<>();
    private static long lastId = 0;

    @PostConstruct
    public void preFillRecords(){

        //TODO insert valid bookings (probably fix table and guest repos first)

        this.add(new Guest("Kim", "Bergschen", "063339976"));
        this.add(new Guest("Leila", "Bashir", "062466982"));
        this.add(new Guest("Jan", "Maas", "067773346"));
        this.add(new Guest("Tomoko", "Tanaka", "068559454"));

    }

    public void add(Guest newGuest){
        newGuest.setId(++lastId);
        this.guests.put(newGuest.getId(), newGuest);
    }

    public Guest findById(long id) {
        return this.guests.get(id);
    }

    public void removeById(long id) {
        this.guests.remove(id);
    }

    public Collection<Guest> findAll() {
        return this.guests.values();
    }

    public Guest update(long id, Guest update){

        Guest directObject = this.findById(id);     // directObject = lijdend voorwerp

        directObject.setFirstName(update.getFirstName());
        directObject.setLastName(update.getLastName());
        directObject.setPhoneNumber(update.getPhoneNumber());

        return directObject;
    }



}
