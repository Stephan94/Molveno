package com.MolvenoLakeResort.controller;

import com.MolvenoLakeResort.model.restaurant.Restaurant;

import java.util.Scanner;

public class AppController {

    private Restaurant restaurant = new Restaurant();
    private boolean state = true;


    public void run() {
        while (state) {
            this.interpreter(this.showMainMenu());
        }
    }


    private int showMainMenu() {
        System.out.println("option 1");
        System.out.println("9: Exit");

        int choice = this.takeInput();

        return choice;
    }

    private void interpreter(int choice) {
        if (choice == 1 ){
            System.out.println("You chose 1");
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
