package com.MolvenoLakeResort.controller;

import com.MolvenoLakeResort.model.restaurant.Restaurant;
import com.MolvenoLakeResort.model.restaurant.Table;

import java.util.Scanner;

public class AppController {

    private Restaurant molveno = new Restaurant();
    private boolean state = true;


    public void run() {
        while (state) {
            this.interpreter(this.showMainMenu());
        }
    }


    private int showMainMenu() {
        System.out.println("1: show all available tables");
        System.out.println("9: Exit");

        int choice = this.takeInput();

        return choice;
    }



    private void interpreter(int choice) {
        if (choice == 1 ){
            for (Table table : molveno.showAllAvailableTables()) {
                System.out.println("Table " + table.getID() + " is available");
            }
        } else if (choice == 9 ) {
            this.quit();
        }
    }

    private int takeInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        return choice;
    }


    private void quit() {
        this.state = false;
    }
}
