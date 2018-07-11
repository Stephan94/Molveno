package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.*;
import com.MolvenoLakeResort.model.restaurant.Date;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> { //fill repo in constructor or controller?


    Optional<Booking> findByTable(Table table);
    Collection<Booking> findByDateAndTimeSlot(LocalDate date, TimeSlot timeSlot);

//    private Map<Long, Booking> bookings = new HashMap<>();
//    private static long lastId = 0;
//
//    private GuestRepository guests = new GuestRepository();
//    private TableRepository tables = new TableRepository();
//
//    //  TODO add autowired Table repo and guest repo
//    @PostConstruct
//    public void preFillRecords(){
////        for (int i = 0; i < 4; i++){
////            this.add(new Booking(guests.findById(i), tables.findById(i) ) );
////        }
//
//        this.add(new Booking((new Table(2,2)),new Guest("Test","Test","06186793884")));
//        this.add(new Booking((new Table(9,4)),new Guest("Test2","Test2","06186793885")));
//        this.add(new Booking((new Table(7,6)),new Guest("Test3","Test3","06186793881")));
//
////        this.add(new Booking((new Table(3,6)),new Guest("Test3","Test3","06186793881"),new GregorianCalendar(2018 + 1900,10,10)));
////        this.add(new Booking((new Table(4,2)),new Guest("Kim","Bergschen","063339976")));
////        this.add(new Booking((new Table(7,4)),new Guest("Leila","Bashir","062466982")));
////        this.add(new Booking((new Table(3,6)),new Guest("Jan","Maas","068559454")));
//
////        this.add(new Booking(new Guest("Kim","Bergschen", "061234567"),new Table(2,2), new Date(LocalDate.of(2018,7,6))));
////        this.add(new Booking(new Guest("Leila","Bashir", "062185743"),new Table(9,2), new Date(LocalDate.of(2018,7,6))));
////        this.add(new Booking(new Guest("Jan","Maas", "064723842"),new Table(7,2),  new Date(LocalDate.of(2018,7,6))));
//    }
//
//    public void add(Booking newBooking) {
//        newBooking.setId(++lastId);
//        this.bookings.put(newBooking.getId(), newBooking);
//    }
//
//
//    public void removeById(long id) {
//        this.bookings.remove(id);
//    }
//
//    public Collection<Booking> findAll() {
//        return this.bookings.values();
//    }
//
//    public Booking update(long id, Booking updated){
//
//        Booking target = this.findById(id);
//
//        target.setDate(updated.getDate());
//        target.setGuest(updated.getGuest());
//        target.setTable(updated.getTable());
//
//        return target;
//    }
//
//    public void searchByCapacityAndTime(){
//        findAll();
//    }
}