package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.Ingredient;
import com.MolvenoLakeResort.model.restaurant.Table;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class IngredientRepository {

    private Map<Long, Ingredient> ingredients = new HashMap<>();
    private static long lastId = 0;

    @PostConstruct
    public void preFillRecords() {

        this.add(new Ingredient("Sugar", 1, 1.0));
        this.add(new Ingredient("Cheese", 2, 2.0));
        this.add(new Ingredient("Salt",3,0.5));
    }

    public void add(Ingredient newIngredient) {
        newIngredient.setId(++lastId);
        this.ingredients.put(newIngredient.getId(), newIngredient);
    }

    public void removeById(long id) {
        this.ingredients.remove(id);
    }

    public Ingredient findById(long id) {
        return this.ingredients.get(id);
    }

    public Collection<Ingredient> findAll() {
        return this.ingredients.values();
    }

    public Map<Long, Ingredient> getIngredients() {
        return this.ingredients;
    }

    public Ingredient update(long id, Ingredient updated){
        Ingredient target = this.findById(id);
        target.setName(updated.getName());
        target.setPrice(updated.getPrice());
        return target;
    }
}
