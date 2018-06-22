package com.MolvenoLakeResort.model.restaurant;

import java.time.LocalDate;

public class Guest extends User {


    private LocalDate dateOfBirth;
    // private String firstName;
    // private String lastName;
    private String thelephoneNumber;

    public Guest(String firstName, String lastName, String telephoneNumber) {
        super(firstName, lastName);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getThelephoneNumber() {
        return thelephoneNumber;
    }

    public void setThelephoneNumber(String thelephoneNumber) {
        this.thelephoneNumber = thelephoneNumber;
    }

}

