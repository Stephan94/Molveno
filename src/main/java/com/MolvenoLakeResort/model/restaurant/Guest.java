package com.MolvenoLakeResort.model.restaurant;

import java.time.LocalDate;

public class Guest extends User {

    private String phoneNumber;

    public Guest(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }


}

