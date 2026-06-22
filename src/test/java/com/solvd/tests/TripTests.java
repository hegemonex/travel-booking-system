package com.solvd.tests;

import com.travel.booking.model.Trip;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TripTests extends BaseTests {

    @Test
    public void shouldSetTitle() {
        Trip trip = new Trip();

        trip.setTitle("London Trip");

        Assert.assertEquals(trip.getTitle(), "London Trip");
    }

    @Test
    public void shouldSetDescription() {
        Trip trip = new Trip();

        trip.setDescription("5 days");

        Assert.assertEquals(trip.getDescription(), "5 days");
    }

    @Test
    public void shouldSetPrice() {
        Trip trip = new Trip();

        trip.setPrice(999);

        Assert.assertEquals(trip.getPrice(), 999.0);
    }

    @Test
    public void shouldSetAvailable() {
        Trip trip = new Trip();

        trip.setAvailabe(true);

        Assert.assertTrue(trip.isAvailabe());
    }

    @Test
    public void shouldSetDepartureDate() {
        Trip trip = new Trip();

        LocalDate date = LocalDate.of(2025, 6, 1);

        trip.setDepartureDate(date);

        Assert.assertEquals(trip.getDepartureDate(), date);
    }
}