package com.MolvenoLakeResort.model.restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {

    private List<Booking> bookingsList = new LinkedList<>();
    private List<Table> tables = new ArrayList<>();
    private List<Guest> guestList = new LinkedList<>();

    public Restaurant() {
        this.setUp();
    }

    private void setUp() {
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

        this.guestList.add(new Guest("Raymond", "Loman", "0618589443"));

        this.bookingsList.add(new Booking(new Guest("Arjan", "Tammer", "0618689885"), new Table(1, 2), LocalDate.of(2018, 6, 21)));
        this.bookingsList.add(new Booking(new Guest("Mo", "Salem", "0689457232"), new Table(7, 2), LocalDate.of(2018, 6, 21)));
    }

    // Shows all available tables that are not on the bookingList

    public void showAllAvailableTables() {

        List<Table> availableTables = new ArrayList<>();

        for (Table table : this.getTables()) {

            Booking bookingToSearchFor = new Booking(null, table, null);

            if (bookingsList.contains(bookingToSearchFor)) {

                System.out.println("Table " + table.getID() + " is already booked");
            } else {
                availableTables.add(table);
                System.out.println("Table " + table.getID() + " is available");
            }
        }
    }

    public List<Table> getAllAvailableTables() {

        List<Table> availableTables = new ArrayList<>();

        for (Table table : this.getTables()) {

            Booking bookingToSearchFor = new Booking(null, table, null);

            if (!bookingsList.contains(bookingToSearchFor)) {
                availableTables.add(table);
            }
        }
        return availableTables;
    }

    public void bookTable(Table table, Guest guest) {
        if (getAllAvailableTables().contains(table)) {
            System.out.println("This table is already booked");
        } else {
            Booking bookingToAdd = new Booking(guest, table);
            this.bookingsList.add(bookingToAdd);

        }
    }

    public void createGuest(){

        Scanner input = new Scanner(System.in);

        List<Guest> guestList = new ArrayList<>();

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
        System.out.println("First name: " + firstName + "\n" + "Last name: " + lastName + "\n"+ "Telephone: " + telephoneNumber);

        Guest g = new Guest(firstName, lastName,telephoneNumber);

         if (guestList.contains(g)) {
             System.out.println("This guest is already in the system");
         }else {
             Guest guestToAdd = new Guest(firstName, lastName,telephoneNumber );
             this.guestList.add(guestToAdd);
    }
    }

        // Setters and getters

    public List<Table> getTables() {
        return this.tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Guest> getGuests() {
        return this.guestList;
    }

    public void setGuests(List<Guest> guests) {
        this.guestList = guests;
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


