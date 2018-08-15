package com.MolvenoLakeResort.model.restaurant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MenuItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private double salesPrice;
    private MenuCategory menuCategory;




    @ManyToMany
    @JoinTable(name = "menuItem_ingredient",
            joinColumns = @JoinColumn(name = "menuItem_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private List<Ingredient> ingredientList = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "menuItem_subDish",
            joinColumns = @JoinColumn(name = "menuItem_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subDish_id", referencedColumnName = "id"))
    private List<SubDish> subDishList = new ArrayList<>();


// add constructor

    public MenuItem() {

    }

    public MenuItem(String name, double salesPrice) {
        this.name = name;
        this.salesPrice = salesPrice;
    }

// Dit is een test!!!!

    // add getter and setter


    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
    }

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
        double totalPriceIngredientList = getIngredientList().stream().mapToDouble(Ingredient::getPrice).sum();
        double totalPriceSubDishList = getSubDishList().stream().flatMapToDouble(s -> s.getIngredientListForSubDish().stream().mapToDouble(i -> i.getPrice())).sum();
        return totalPriceIngredientList + totalPriceSubDishList;
    }

    public boolean isVegetarian() {
        return getIngredientList().stream().allMatch(Ingredient::isVegetarian);
    }

    public double getProfit() {
        return getSalesPrice() - getCalculatedPrice();
    }

    public List<SubDish> getSubDishList() {
        return subDishList;
    }

    public void setSubDishList(List<SubDish> subDishList) {
        this.subDishList = subDishList;
    }
}



