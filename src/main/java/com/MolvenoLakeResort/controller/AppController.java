package com.MolvenoLakeResort.controller;

import com.MolvenoLakeResort.model.restaurant.Guest;
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

        System.out.println("");
        System.out.println("1: show all available tables");
        System.out.println("2: Create new guest");
        System.out.println("3: Book a table");
        System.out.println("9: Exit");

        int choice = this.takeInput();

        return choice;
    }



    private void interpreter(int choice) {
        switch (choice) {
            case 1:
                molveno.showAllAvailableTables();
                break;
            case 2:
                // insert create guest method
                break;
            case 3:
                showBookingMenu();
                break;
            case 9:
                this.quit();
        }

    }



    private int takeInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        return choice;
    }

    private void showBookingMenu() {
        System.out.println("Insert First Name");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();

        System.out.println("Insert Last Name");
        scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        askTableNumber(firstName, lastName);
    }

    private void quit() {
        this.state = false;
    }

    private void askTableNumber(String firstName, String lastName){
        System.out.println("Which table number would you like to book? (PLease consult the list of available tables first)");
        Scanner scanner = new Scanner(System.in);
        int tableId = scanner.nextInt();

        if (molveno.getTableById(tableId , molveno.getAllAvailableTables()) != null){

            molveno.bookTable(molveno.getTableById(tableId ,molveno.getAllAvailableTables()), new Guest(firstName , lastName));

        } else {
            System.out.println("Table already booked. Please pick a different table");
            askTableNumber(firstName, lastName);
        }
    }

}
