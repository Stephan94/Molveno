package com.MolvenoLakeResort.model.restaurant;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;


public class Booking {

    private long id;
    private Guest guest;
    private Table table;

    private Date date;
    private Time time;
    private GregorianCalendar date;

    public Table getTable() {
        return this.table;
    }

    public Booking(){
    }

    public Booking(Table table, Guest guest) {
        this.guest = guest;
        this.table = table;
    }
  
    public Booking(Guest guest, Table table, Date date) {
        this.guest = guest;
        this.table = table;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return this.table.equals(booking.table);
    }

    @Override
    public int hashCode() {

        return Objects.hash(table);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return this.guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
