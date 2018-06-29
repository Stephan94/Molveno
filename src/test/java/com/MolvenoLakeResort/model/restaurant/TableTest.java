package com.MolvenoLakeResort.model.restaurant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TableTest {
    private Table table;

    @Before
    public void setUp() {
        this.table = new Table(0, 3);
    }

    @Test
    public void testSetAndGetForTableID() {

        this.table.setId(5);

        long actual = this.table.getId();
        Assert.assertEquals(5, actual);
    }

    @Test
    public void testSetAndGetForCapacity(){

        this.table.setCapacity(6);

        int actual = this.table.getCapacity();
        Assert.assertEquals(6, actual);

    }
}