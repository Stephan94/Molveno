package com.MolvenoLakeResort.model.restaurant;

public class Item {
    //fields

    private double price;
    private String name;
    private String category;
    private String size;

    //constructors
    public Item(String name, String category, String size, double price){
        this.price = price;
        this.category = category;
        this.name = name;
        this.size = size;
    }

}
