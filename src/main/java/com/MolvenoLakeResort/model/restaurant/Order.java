package com.MolvenoLakeResort.model.restaurant;

import java.util.Date;

public class Order {

    private int ID;

    private Date date;

    private boolean isPaid;

    private double totalOrderCost;

    //for unit testing
    public void setTotalOrderCost (double totalOrderCost){

        this.totalOrderCost = totalOrderCost;
    }

    public double getTotalOrderCost (){

        return this.totalOrderCost;
    }

}
