package com.MolvenoLakeResort.model.restaurant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User u;
    @Before
    public void setUp(){
        this.u = new User("someFirstName", "someLastName");
    }

    @Test
    public void testSetAndGetForNumberOfSnares(){

        this.u.setFirstName("Mo");
        this.u.setLastName("Salem");

        Assert.assertEquals("Mo", this.u.getFirstName());
        Assert.assertEquals("Salem", this.u.getLastName());
    }
}
