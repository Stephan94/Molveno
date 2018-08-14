package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.Ingredient;
import com.MolvenoLakeResort.model.restaurant.MenuItem;
import com.MolvenoLakeResort.model.restaurant.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Optional <Ingredient> findByName(String name);



}
//REPO OLD STYLE:

//@Repository
//public class IngredientRepository {
//
//    private Map<Long, Ingredient> ingredients = new HashMap<>();
//    private static long lastId = 0;
//
//    @PostConstruct
//    public void preFillRecords() {
//
//        this.add(new Ingredient("pasta", 1, 2.00));
//        this.add(new Ingredient("ricotta", 2, 2.50));
//        this.add(new Ingredient("garlic",3,0.70));
//        this.add(new Ingredient("vinegar",4,0.50));
//        this.add(new Ingredient("tomato",5,0.90));
//        this.add(new Ingredient("parmesan",6,2.50));
//        this.add(new Ingredient("mushrooms",7,1.00));
//        this.add(new Ingredient("rice",8,1.00));
//        this.add(new Ingredient("chicken",9,3.00));
//        this.add(new Ingredient("pork",10,4.00));
//        this.add(new Ingredient("beef",11,6.00));
//    }
//
//    /*
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<MenuItem> menuItemList = new ArrayList<>();
//    */
//
//    public void add(Ingredient newIngredient) {
//        newIngredient.setId(++lastId);
//        this.ingredients.put(newIngredient.getId(), newIngredient);
//    }
//
//    public void removeById(long id) {
//        this.ingredients.remove(id);
//    }
//
//    public Ingredient findById(long id) {
//        return this.ingredients.get(id);
//    }
//
//    public Collection<Ingredient> findAll() {
//        return this.ingredients.values();
//    }
//
//    public Map<Long, Ingredient> getIngredients() {
//        return this.ingredients;
//    }
//
//    public Ingredient update(long id, Ingredient updated){
//        Ingredient target = this.findById(id);
//        target.setName(updated.getName());
//        target.setPrice(updated.getPrice());
//        return target;
//    }
//}
