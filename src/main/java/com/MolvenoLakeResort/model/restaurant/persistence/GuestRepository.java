package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {



    Guest findByFirstName(String firstName);
    Optional<Guest> findByLastName(String lastName);
    Optional<Guest> findByFirstNameAndLastName(String firstName, String lastName);

    /*private Map<Long, Guest> guests = new HashMap<>();
    private static long lastId = 0;

    @PostConstruct
    public void preFillRecords(){

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
*/


}
