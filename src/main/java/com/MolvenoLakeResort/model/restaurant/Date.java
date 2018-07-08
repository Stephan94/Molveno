package com.MolvenoLakeResort.model.restaurant;

import java.time.LocalDate;

public class Date {

    private LocalDate date;

    //constructor
    public Date(LocalDate date){
        this.date = date;
    }

    public Date() {
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
