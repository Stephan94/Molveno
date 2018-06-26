package com.MolvenoLakeResort;

import com.MolvenoLakeResort.model.restaurant.Restaurant;
import com.MolvenoLakeResort.model.restaurant.Table;
import com.MolvenoLakeResort.controller.AppController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {

        /*
        AppController app = new AppController();
        app.run();
        */

        SpringApplication.run(App.class, args);
    }
}
