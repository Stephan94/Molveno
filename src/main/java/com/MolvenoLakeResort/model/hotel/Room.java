package com.MolvenoLakeResort.model.hotel;

public class Room {


    private int ID;

    private int capacity;

    private double price;

    private String type;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Room(int capacity, double price, String type) {

        this.capacity = capacity;
        this.price = price;
        this.type = type;
    }
}
