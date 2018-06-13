package com.MolvenoLakeResort.model.restaurant;

import java.util.Date;

public class Guest extends User{

    private Date dateOfBirth;

    public Guest(String name) {
        super(name);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
