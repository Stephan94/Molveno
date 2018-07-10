package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Guest;
import com.MolvenoLakeResort.model.restaurant.persistence.GuestRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class GuestControllerTest {

    @InjectMocks
    private GuestController controller;

    @Mock
    private GuestRepository guestRepository;

    @Test
    public void testCreateWithNew() {

        // Given
        Guest g = new Guest();
        g.setFirstName("Donald");
        g.setLastName("Duck");

        Guest g2 = new Guest();
        g2.setFirstName("Donald");
        g2.setLastName("Trump");
        g2.setId(3);

        Mockito.when(this.guestRepository.findByFirstName("Donald")).thenReturn(g2);
        Mockito.when((this.guestRepository.save(g))).thenReturn(g2);

		// When
        ResponseEntity<Guest> responseFromController = this.controller.create(g);


		// Then
        Assert.assertNotNull(responseFromController.getBody());
        Assert.assertEquals(3, responseFromController.getBody().getId());
        Assert.assertEquals(HttpStatus.CREATED, responseFromController.getStatusCode());
    }

    @Test
    public void testCreateWithNonExisting() {

        // Given
        Guest g = new Guest();
        g.setFirstName("Donald");
        g.setLastName("Duck");

        Guest g2 = new Guest();
        g2.setFirstName("Donald");
        g2.setLastName("Trump");
        g2.setId(3);

        Mockito.when(this.guestRepository.findByFirstName("Donald")).thenReturn(null);
        Mockito.when((this.guestRepository.save(g))).thenReturn(g2);

		// When
        ResponseEntity<Guest> responseFromController = this.controller.create(g);


		// Then
        Assert.assertNotNull(responseFromController.getBody());
        Assert.assertEquals(3, responseFromController.getBody().getId());
        Assert.assertEquals(HttpStatus.CREATED, responseFromController.getStatusCode());
    }

    @Test
    public void testCreateWithConflict() {

        // Given
        Guest g = new Guest();
        g.setFirstName("Donald");
        g.setLastName("Duck");

        Mockito.when(this.guestRepository.findByFirstName("Donald")).thenReturn(g);

		// When
        ResponseEntity<Guest> responseFromController = this.controller.create(g);

		// Then
        Assert.assertNull(responseFromController.getBody());
        Assert.assertEquals(HttpStatus.CONFLICT, responseFromController.getStatusCode());
    }
}
