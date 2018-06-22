package com.MolvenoLakeResort.model.restaurant;

import java.util.Objects;

public class Table implements Comparable<Table> {

    //properties
    private int id;
    private int capacity;

    //constructor
    public Table(int ID, int capacity){
        this.id = ID;
        this.capacity = capacity;
    }

    // getter TableID
    public int getId() {
        return this.id;
    }

    // setter TableID
    public void setId(int id) {
        this.id = id;
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
        return id == table.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public int compareTo(Table o){
        return this.getCapacity() - o.getCapacity();
    }

    @Override
    public String toString() {
        return "Table number " + id +
                " for " + capacity + " guests is available. \n";
    }
}
