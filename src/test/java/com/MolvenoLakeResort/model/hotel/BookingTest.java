package com.MolvenoLakeResort.model.hotel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class BookingTest {


    private Booking booking;

    @Before
    public void setUp(){
        booking = new Booking(LocalDateTime.of(2018,8,2,14,0), LocalDateTime.of(2018,8,7,14,0), 2);
    }

    @Test
    public void testSetAndGetForID(){
        this.booking.setID(5);
        int actual = this.booking.getID();
        Assert.assertEquals(5, actual);
    }

}
