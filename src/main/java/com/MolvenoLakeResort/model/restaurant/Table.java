package com.MolvenoLakeResort.model.restaurant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Table implements Serializable, Comparable<Table> {

    public Table(){
    }

    @Id
    @GeneratedValue
    private long id;
    private int capacity;

    public Table(long ID, int capacity){
        this.id = ID;
        this.capacity = capacity;
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
