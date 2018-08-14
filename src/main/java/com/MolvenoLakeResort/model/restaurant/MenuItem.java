package com.MolvenoLakeResort.model.restaurant;

import javax.persistence.*;
import java.util.List;

@Entity
public class MenuItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private double salesPrice;




    @ManyToMany
    @JoinTable(name = "menuItem_ingredient",
            joinColumns = @JoinColumn(name = "menuItem_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private List<Ingredient> ingredientList;





// add constructor

    public MenuItem() {

    }

    public MenuItem(String name, double salesPrice) {
        this.name = name;
        this.salesPrice = salesPrice;
    }

// Dit is een test!!!!

    // add getter and setter


    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getCalculatedPrice() {
        return getIngredientList().stream().mapToDouble(Ingredient::getPrice).sum();
    }

    public double getProfit() {
        return getSalesPrice() - getCalculatedPrice();
    }
}



