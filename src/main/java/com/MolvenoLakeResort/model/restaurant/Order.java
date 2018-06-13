package com.MolvenoLakeResort.model.restaurant;

import java.util.*;

public class Order {

    private int ID;

    private Date date;

    private boolean isPaid;

    private double totalOrderCost;

    //for unit testing
    public void setTotalOrderCost (double totalOrderCost){
        this.totalOrderCost = totalOrderCost;
    }

    public double setTotalOrderCost (){
        return this.totalOrderCost;
    }

}
