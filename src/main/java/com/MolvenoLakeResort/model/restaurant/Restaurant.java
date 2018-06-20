package com.MolvenoLakeResort.model.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private List<Table> tables = new ArrayList<>();

    public Restaurant() {
        this.setUp();
    }

    private void setUp() {
        this.tables.add(new Table(1, 2));
        this.tables.add(new Table(2, 4));
        this.tables.add(new Table(3, 6));
        this.tables.add(new Table(4, 8));
        this.tables.add(new Table(5, 2));
        this.tables.add(new Table(6, 4));
        this.tables.add(new Table(7, 6));
        this.tables.add(new Table(8, 8));
        this.tables.add(new Table(9, 2));
        this.tables.add(new Table(10, 2));
        this.tables.add(new Table(11, 4));
    }


}




