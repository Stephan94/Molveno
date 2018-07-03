package com.MolvenoLakeResort.model.restaurant;

import java.util.ArrayList;

public class MenuItem {

    private String menuId;
    private double actualPrice;
    private double suggestedPrice;

    public MenuItem(ArrayList<MenuItem> main, String menuId, double actualPrice, double suggestedPrice) {
        this.menuId = menuId;
        this.actualPrice = actualPrice;
        this.suggestedPrice = suggestedPrice;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public double getActualPrice() {
        return this.actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getSuggestedPrice() {
        return this.suggestedPrice;
    }

    public void setSuggestedPrice(double suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }
}



