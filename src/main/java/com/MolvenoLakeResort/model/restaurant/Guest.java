package com.MolvenoLakeResort.model.restaurant;

import java.util.Date;

public class Guest extends User{

    private Date dateOfBirth;

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
