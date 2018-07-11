package com.MolvenoLakeResort.model.restaurant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Tables")
public class Table implements Serializable, Comparable<Table> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int capacity;

    @OneToMany(mappedBy="table")
    Set<Booking> bookings = new HashSet <>();

    public Table(long id, int capacity){
        this.id = id;

        this.capacity = capacity;
    }

    public Table() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return this.capacity;
    }

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
