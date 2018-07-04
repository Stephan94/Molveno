package com.MolvenoLakeResort.model.restaurant;

import java.util.Objects;

public class Ingredient {

    private String name;
    private long id;
    private double price;

    public Ingredient(String name, long id, double price) {
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

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}