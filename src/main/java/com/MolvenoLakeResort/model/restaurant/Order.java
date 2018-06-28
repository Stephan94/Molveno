package com.MolvenoLakeResort.model.restaurant;

import java.util.Date;

public class Order {

    private int ID;
    private Date date;
    private double totalOrderCost;
    private PaymentStatus statusOfPayment;
    private boolean isPaid;


    //for unit testing
    public void setTotalOrderCost (double totalOrderCost){

        this.totalOrderCost = totalOrderCost;
    }

    public double getTotalOrderCost (){

        return this.totalOrderCost;
    }

    // use Enum PaymentStatus
    public PaymentStatus getStatusOfPayment() {
        return this.statusOfPayment;
    }

    public void setStatusOfPayment(PaymentStatus statusOfPayment) {
        this.statusOfPayment = statusOfPayment;
    }
}
