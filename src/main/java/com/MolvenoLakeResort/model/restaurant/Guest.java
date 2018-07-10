package com.MolvenoLakeResort.model.restaurant;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Guest extends User implements Serializable{

    private String phoneNumber;

    @OneToMany(mappedBy = "guest")
    private Set<Booking> bookings = new HashSet<>();

    public Guest() {
    }

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Guest(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}

