package com.MolvenoLakeResort.model.restaurant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private Order order;

    @Before
    public void setUP() {
        this.order = new Order();
    }

    @Test
    public void testSetAndGetForTotalOrderCost(){

        this.order = new Order();

        this.order.setTotalOrderCost(3.25);

        Assert.assertEquals(3.25, order.getTotalOrderCost(), 0);

    }

}
