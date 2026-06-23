package com.solvd.tests;

import com.travel.booking.model.Destination;
import com.travel.booking.service.impl.DestinationServiceImpl;
import com.travel.booking.service.interfaces.DestinationService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

public class DestinationTests {

    private DestinationService destinationService;

    @BeforeClass
    public void setup() {
        destinationService = new DestinationServiceImpl();
    }

    private Destination createDestination() {
        Destination destination = new Destination();
        destination.setCountry("UK");
        destination.setCity("London");
        destination.setDescription("Capital city");
        destination.setVisaRequired(false);
        destination.setCreatedAt(LocalDateTime.now());

        destinationService.save(destination);
        return destination;
    }

    @Test
    public void saveDestinationTest() {
        Destination destination = createDestination();

        Assert.assertNotNull(destination.getId(),
                "Destination should be saved.");
    }

    @Test
    public void findDestinationByIdTest() {
        Destination destination = createDestination();

        Destination found = destinationService.findById(destination.getId());

        Assert.assertNotNull(found,
                "Destination should be found.");
    }

    @Test
    public void findAllDestinationsTest() {
        List<Destination> destinations = destinationService.findAll();

        Assert.assertNotNull(destinations,
                "Destination list should not be null.");
    }

    @Test
    public void updateDestinationTest() {
        Destination destination = createDestination();

        destination.setCity("Manchester");
        destinationService.update(destination);

        Destination updated =
                destinationService.findById(destination.getId());

        Assert.assertEquals(updated.getCity(),
                "Manchester",
                "City should be updated.");
    }

    @Test
    public void deleteDestinationTest() {
        Destination destination = createDestination();

        destinationService.delete(destination.getId());

        Destination deleted =
                destinationService.findById(destination.getId());

        Assert.assertNull(deleted,
                "Deleted destination should not exist.");
    }
}