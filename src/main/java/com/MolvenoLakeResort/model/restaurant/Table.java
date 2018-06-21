package com.MolvenoLakeResort.model.restaurant;

import java.util.Objects;

public class Table {

    //properties
    private int ID;
    private int capacity;

    //constructor
    public Table(int ID, int capacity){
        this.ID = ID;
        this.capacity = capacity;
    }

    // getter TableID
    public int getID() {
        return this.ID;
    }

    // setter TableID
    public void setID(int ID) {
        this.ID = ID;
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
        return ID == table.ID;
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID);
    }
}
