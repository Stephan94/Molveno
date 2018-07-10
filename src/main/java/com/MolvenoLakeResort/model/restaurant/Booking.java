package com.MolvenoLakeResort.model.restaurant;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Table table;


    private LocalDate date;


    private Time time;

    public Table getTable() {
        return this.table;
    }

    public Booking(){
    }

    public Booking(Table table, Guest guest) {
        this.guest = guest;
        this.table = table;
    }

    public Booking(Guest guest, Table table, LocalDate date) {
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

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", guest=" + guest +
                ", table=" + table +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
