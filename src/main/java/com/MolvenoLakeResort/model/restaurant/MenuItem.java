package com.MolvenoLakeResort.model.restaurant;

public class MenuItem {

    private long id;
    private double actualPrice;
    private double suggestedPrice;


// add constructor

    public MenuItem(long id, double actualPrice, double suggestedPrice) {
        this.id = id;
        this.actualPrice = actualPrice;
        this.suggestedPrice = suggestedPrice;
    }

// Dit is een test!!!!

    // add getter and setter


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getActualPrice() {
        return this.actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getSuggestedPrice() {
        return this.suggestedPrice;
    }

    public void setSuggestedPrice(double suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }
}



