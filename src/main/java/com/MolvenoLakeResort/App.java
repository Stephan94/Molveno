package com.MolvenoLakeResort;

import com.MolvenoLakeResort.model.restaurant.Restaurant;
import com.MolvenoLakeResort.model.restaurant.Table;
import com.MolvenoLakeResort.controller.AppController;


public class App {
    public static void main(String[] args) {

        Restaurant molveno = new Restaurant();
        Restaurant restaurant = new Restaurant();
//        System.out.println("By search");
//        System.out.println(restaurant.SearchTableByTimeAndCapacity(3, restaurant.getAllAvailableTables()));

        AppController app = new AppController();
        app.run();
    }
}
