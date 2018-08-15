package com.MolvenoLakeResort.model.restaurant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SubDish implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//
//    public List<Ingredient> getIngredientList() {
//        return ingredientList;
//    }
//
//    public void setIngredientList(List<Ingredient> ingredientList) {
//        this.ingredientList = ingredientList;
//    }

//    public double getSalesPrice() {
//        return salesPrice;
//    }

//    public double getCalculatedPrice() {
//        return getIngredientList().stream().mapToDouble(Ingredient::getPrice).sum();
//    }

//    public boolean isVegetarian() {
//        return getIngredientList().stream().allMatch(Ingredient::isVegetarian);
//    }
//
//    public double getProfit() {
//        return getSalesPrice() - getCalculatedPrice();
//    }

}

