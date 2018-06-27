package com.MolvenoLakeResort.model.restaurant.repository;

import com.MolvenoLakeResort.model.restaurant.Table;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TableRepository {

    private Map<Long, Table> tables = new HashMap<>();
    private static long lastId = 0;

    @PostConstruct
    public void preFillRecords(){
        for (int i = 0; i < 10; i++){

            this.add(new Table(1, 2));
            this.add(new Table(2, 2));
            this.add(new Table(3, 2));
            this.add(new Table(4, 4));
            this.add(new Table(5, 4));
            this.add(new Table(6, 4));
            this.add(new Table(7, 6));
            this.add(new Table(8, 6));
            this.add(new Table(9, 6));
            this.add(new Table(10, 8));
            this.add(new Table(11, 8));
            this.add(new Table(12, 8));
        }
    }



    public void add(Table newTable) {
        newTable.setId(++lastId);
        this.tables.put(newTable.getId(), newTable);
    }

    public void removeById(long id) {
        this.tables.remove(id);
    }

    public Table findById(long id) {
        return this.tables.get(id);
    }

    public Collection<Table> findAll(long id) {
        return this.tables.values();
    }

    public Map<Long, Table> getTables() {
        return this.tables;
    }

    public Table update(long id, Table updated){

        Table target = this.findById(id);

        target.setCapacity(updated.getCapacity());

        return target;
    }
}
