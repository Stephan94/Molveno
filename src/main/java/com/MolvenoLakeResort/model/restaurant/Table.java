package com.MolvenoLakeResort.model.restaurant;

import java.util.Objects;

public class Table {

    //properties
    private int tableID;
    private int capacity;

    //constructor
    public Table(int tableID, int capacity){
        this.tableID = tableID;
        this.capacity = capacity;
    }

    // getter TableID
    public int getTableID() {
        return this.tableID;
    }

    // setter TableID
    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    // getter Capacity
    public int getCapacity() {
        return this.capacity;
    }

    //setter Capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return tableID == table.tableID;
    }

    @Override
    public int hashCode() {

        return Objects.hash(tableID);
    }
}
