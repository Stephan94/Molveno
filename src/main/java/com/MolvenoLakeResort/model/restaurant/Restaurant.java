package com.MolvenoLakeResort.model.restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Restaurant {

    // Fields
    private List<Booking> bookingsList = new LinkedList<>();
    private List<Table> tables = new ArrayList<>();


    // Constructor
    public Restaurant() {
        this.tables.add(new Table(1, 2));
        this.tables.add(new Table(2, 4));
        this.tables.add(new Table(3, 6));
        this.tables.add(new Table(4, 8));
        this.tables.add(new Table(5, 2));
        this.tables.add(new Table(6, 4));
        this.tables.add(new Table(7, 6));
        this.tables.add(new Table(8, 8));
        this.tables.add(new Table(9, 2));
        this.tables.add(new Table(10, 2));
        this.tables.add(new Table(11, 4));

        this.bookingsList.add(new Booking(new Guest("Arjan","Tammer"),new Table(1,2), LocalDate.of(2018,6,21)));
        this.bookingsList.add(new Booking(new Guest("Mo","Salem"),new Table(7,2), LocalDate.of(2018,6,21)));

    }

    public List<Table> showAllAvailableTables() {

        boolean available;

        List<Table> availableTables = new ArrayList<>();

        for (Table table : this.getTables()) {

            Booking searchFor = new Booking(null, table, null);

            if (bookingsList.contains(searchFor)){

                    System.out.println("Table " + table.getID() + " is already booked");
                } else {
                    availableTables.add(table);
            }
        }

        return availableTables;

    }


    public List<Table> getTables() {
        return this.tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}


/**
 * Give boolean to available
 * Check if boolean is false/true
 * then add false to a new list
 * <p>
 * if not booked then
 * <p>
 * List<Table> availableTables = Restaurant.tables();
 */


