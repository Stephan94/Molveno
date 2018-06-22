package com.MolvenoLakeResort.model.restaurant;

import java.time.LocalDate;
import java.util.Objects;


public class Booking {

    private Guest guest;
    private Table table;
    private LocalDate date;

    public Table getTable() {
        return table;
    }

    public Booking(Guest guest, Table table) {
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
}
