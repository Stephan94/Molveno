package com.MolvenoLakeResort.model.restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Restaurant{

    // Fields
    private List<Booking> bookingsList = new LinkedList<>();
    private List<Table> tables = new ArrayList<>();
    private List<Guest> guests = new LinkedList<>();


    // Constructor
    public Restaurant() {
        this.setUp();
    }

    private void setUp() {
//        this.tables.add(new Table(1, 2));
//        this.tables.add(new Table(2, 4));
//        this.tables.add(new Table(3, 6));
//        this.tables.add(new Table(4, 8));
//        this.tables.add(new Table(5, 2));
//        this.tables.add(new Table(6, 4));
//        this.tables.add(new Table(7, 6));
//        this.tables.add(new Table(8, 8));
//        this.tables.add(new Table(9, 2));
//        this.tables.add(new Table(10, 2));
//        this.tables.add(new Table(11, 4));

        this.guests.add(new Guest("Raymond", "Loman", "067794345"));
        this.guests.add(new Guest("Arjan", "Tammer", "061234567" ));
        this.guests.add(new Guest("Mo", "Salem", "069876543"));

//        this.bookingsList.add(new Booking(new Guest("Arjan","Tammer", "061234567"),new Table(1,2), new Date(2018,6,21)));
//        this.bookingsList.add(new Booking(new Guest("Mo","Salem", "069876543"),new Table(7,2), new Date(2018,6,21)));
    }

    public void showAllAvailableTables() {

        List<Table> availableTables = new ArrayList<>();

        for (Table table : this.getTables()) {

            Booking bookingToSearchFor = new Booking(null, null,null);

            if (bookingsList.contains(bookingToSearchFor)){

                System.out.println("Table " + table.getId() + " is already booked");
            } else {
                availableTables.add(table);
                System.out.println("Table " + table.getId() + " is available");
            }
        }
    }

    public List<Table> getAllAvailableTables() {

        List<Table> availableTables = new ArrayList<>();

        for (Table table : this.getTables()) {

            Booking bookingToSearchFor = new Booking(null, null, null);

            if (!bookingsList.contains(bookingToSearchFor)){
                availableTables.add(table);
            }
        }
        return availableTables;
    }

    public List<Table> SearchTableByTimeAndCapacity(int capacity, List<Table> availableTables){

        //A getAllBookings to store the results of search
        List<Table> availableTablesBySearch = new ArrayList<>();

        //Search only goes on when hasFoundResult = false;
        boolean hasFoundResult = false;

        for (Table table: availableTables){

            if(table.getCapacity() == capacity){

                availableTablesBySearch.add(table);

                hasFoundResult = true;
            }

        }

        //If no table fits the capacity, then it looks for a table with bigger sizes
        if (!hasFoundResult) {

            int capacityForBiggerTable = capacity + 1;

            do {

                capacityForBiggerTable = capacityForBiggerTable+1;

                for (Table table : availableTables) {

                    if (table.getCapacity() == capacityForBiggerTable) {

                        availableTablesBySearch.add(table);

                    }
                }

                //Once it finds all the table sizes that match capacityForBiggerTable, then it stops searching
                if (availableTablesBySearch.size() != 0){
                    hasFoundResult = true;
                }

            } while (!hasFoundResult && capacityForBiggerTable <= 9);

        }

        if (availableTablesBySearch.size() == 0) {
            System.out.println("There's no table for " + capacity + " guests or more available.");
        }
        return availableTablesBySearch;
    }

    public Table getTableById(int id, List<Table> tables) {
        for (Table table : tables) {
            if (table.getId() == id) {
                return table;
            }
        }
        return null;
    }

    public List<Table> getTables() {
        return this.tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public void bookTable(Table table, Guest guest){
        if (!getAllAvailableTables().contains(table)){
            System.out.println("This table is already booked");
        }
        else{
            Booking bookingToAdd = new Booking(null,null,null);
            this.bookingsList.add(bookingToAdd);
            System.out.println("Booking confirmed for "+guest.getLastName()+", "+guest.getFirstName());
        }
    }


    // Let the user create a guest and add it immediately to the guestList


    public void createGuest() {

        Scanner input = new Scanner(System.in);

        // Get the guestList
        List<Guest> guests = new ArrayList<>();

        // Ask for the first name
        System.out.println("Please enter the first name of the guest: ");
        String firstName = input.next();

        // Ask for the last name
        System.out.print("Please enter the last name of the guest : \n");
        String lastName = input.next();

        // Ask for the telephone number
        System.out.print("Please enter the telephone number of the guest: \n");
        String telephoneNumber = input.next();

        // Print an overview of the details for confirmation
        System.out.println("The contact details of the guest are: \n");
        System.out.println("First name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Telephone: " + telephoneNumber);

        Guest g = new Guest(firstName, lastName, telephoneNumber);

        if (guests.contains(g)) {
            System.out.println("This guest is already in the system");
        } else {
            Guest guestToAdd = new Guest(firstName, lastName, telephoneNumber);
            this.guests.add(guestToAdd);
        }
    }

    public void showAllGuests() {

        for (Guest guest : guests) {
            System.out.println("Guest " + guest.getFirstName() + " " + guest.getLastName() + " is on this guest getAllBookings");
        }
    }

    // Setters and setter
    public List<Guest> getGuests() {
        return this.guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}



