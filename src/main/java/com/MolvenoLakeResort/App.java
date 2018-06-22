package com.MolvenoLakeResort;

import com.MolvenoLakeResort.model.restaurant.Restaurant;
import com.MolvenoLakeResort.model.restaurant.Table;
import com.MolvenoLakeResort.controller.AppController;


public class App {
    public static void main(String[] args) {

        Restaurant molveno = new Restaurant();

        molveno.createGuest();

        AppController app = new AppController();
        app.run();
    }
}
