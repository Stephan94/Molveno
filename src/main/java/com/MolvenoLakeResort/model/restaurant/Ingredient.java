package com.MolvenoLakeResort.model.restaurant;

public class Ingredient {


    private String name;
    private int id;
    private double price;

    // add constructor


    public Ingredient(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public Ingredient() {

    }


    // add getter and setter

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}