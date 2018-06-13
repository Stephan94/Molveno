package com.MolvenoLakeResort.model;

import com.MolvenoLakeResort.model.restaurant.Ingredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {

    private Ingredient ingredient;

    //ZET DE CONSTRUCTOR BOVEN AAN ZODAT HET VOOR ALLE TESTS GELDT
    //DIT IS EEN FIELD

    @Test
    public void testSetAndGetForIngredient() {


        this.ingredient.setPrice(2.00);

        double actual = this.ingredient.getPrice();

        Assert.assertEquals(2.10, actual,1.0);

        actual = this.ingredient.getPrice();

        Assert.assertEquals(2.10, actual,1.0);


    }
}
