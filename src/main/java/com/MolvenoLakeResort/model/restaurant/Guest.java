package com.MolvenoLakeResort.model.restaurant;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Guest extends User {


    private String phoneNumber;

    public Guest() {
    }

    public Guest(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}

