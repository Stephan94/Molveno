package com.MolvenoLakeResort;

import com.MolvenoLakeResort.model.restaurant.Booking;
import com.MolvenoLakeResort.model.restaurant.Restaurant;
import com.MolvenoLakeResort.model.restaurant.Table;

public class App {
    public static void main(String[] args) {

        Restaurant molveno = new Restaurant();

        for (Table table : molveno.showAllAvailableTables()) {
            System.out.println("Table " + table.getTableID() + " is available");
        }
    }
}
