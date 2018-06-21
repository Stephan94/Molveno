package com.MolvenoLakeResort.model.restaurant;

import java.time.LocalDate;

public class Guest extends User {


    private LocalDate dateOfBirth;

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}

