package com.MolvenoLakeResort.model.hotel;

import java.time.LocalDateTime;

public class Booking {

    private int ID;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private double totalBookingCost;

    private boolean isPaid;

    private int numberOfGuests;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalBookingCost() {
        return totalBookingCost;
    }

    public void setTotalBookingCost(double totalBookingCost) {
        this.totalBookingCost = totalBookingCost;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Booking(LocalDateTime checkInDate, LocalDateTime checkOutDate, int numberOfGuests){
        this.setCheckInDate(checkInDate);
        this.setCheckOutDate(checkOutDate);
        this.setNumberOfGuests(numberOfGuests);
    }


    public void setId(long l) {
    }
}
