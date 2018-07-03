package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.MenuItem;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MenuItemRepository {

    private Map<Long, MenuItem> menuItems = new HashMap<>();
    private static long lastId = 0;

    @PostConstruct
    public void preFillRecords(){

        this.add(new MenuItem(1, 30, 24));
        this.add(new MenuItem(2, 25, 20));
        this.add(new MenuItem(3, 35, 29));
        this.add(new MenuItem(4, 40, 34));
        this.add(new MenuItem(5, 32, 28));

    }

    public void add(MenuItem newMenuItem) {
        newMenuItem.setId(++lastId);
        this.menuItems.put(newMenuItem.getId(), newMenuItem);
    }

    public void removeById(long id) {
        this.menuItems.remove(id);
    }

    public MenuItem findById(long id) {
        return this.menuItems.get(id);
    }

    public Collection<MenuItem> findAll() {
        return this.menuItems.values();
    }

    public Map<Long, MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public MenuItem update(long id, MenuItem updated){

        MenuItem target = this.findById(id);

        target.setActualPrice(updated.getActualPrice());
        target.setSuggestedPrice(updated.getSuggestedPrice());

        return target;
    }
}
