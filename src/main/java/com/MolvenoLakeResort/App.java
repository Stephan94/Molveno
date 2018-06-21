package com.MolvenoLakeResort;

import com.MolvenoLakeResort.model.restaurant.Restaurant;
import com.MolvenoLakeResort.model.restaurant.Table;
import com.MolvenoLakeResort.controller.AppController;


public class App {
    public static void main(String[] args) {

        Restaurant molveno = new Restaurant();

        for (Table table : molveno.showAllAvailableTables()) {
            System.out.println("Table " + table.getID() + " is available");
        }

        AppController app = new AppController();
        app.run();
    }
}
