package com.MolvenoLakeResort.model.restaurant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubDish implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;


    @ManyToMany
    @JoinTable(name = "subDish_ingredient",
            joinColumns = @JoinColumn(name = "subDish_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private List<Ingredient> ingredientListForSubDish = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredientListForSubDish() {
        return ingredientListForSubDish;
    }

    public void setIngredientListForSubDish(List<Ingredient> ingredientListForSubDish) {
        this.ingredientListForSubDish = ingredientListForSubDish;
    }



//    public double getCalculatedPrice() {
//        return getIngredientList().stream().mapToDouble(Ingredient::getPrice).sum();
//    }

    public boolean isVegetarian() {
        return getIngredientListForSubDish().stream().allMatch(Ingredient::isVegetarian);
    }
//
//    public double getProfit() {
//        return getSalesPrice() - getCalculatedPrice();
//    }

}

