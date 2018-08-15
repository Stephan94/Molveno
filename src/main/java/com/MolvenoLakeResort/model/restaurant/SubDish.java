package com.MolvenoLakeResort.model.restaurant;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToMany(mappedBy = "subDishList")
    @JsonIgnore // print geen tabel van subDishes
    private List<MenuItem> menuItemList;



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

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public boolean isVegetarian() {
        return getIngredientListForSubDish().stream().allMatch(Ingredient::isVegetarian);
    }


}

