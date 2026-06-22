package com.solvd.tests;

import com.travel.booking.model.Destination;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DestinationTests extends BaseTests {

    @Test
    public void shouldSetCountry() {
        Destination destination = new Destination();

        destination.setCountry("UK");

        Assert.assertEquals(destination.getCountry(), "UK");
    }

    @Test
    public void shouldSetCity() {
        Destination destination = new Destination();

        destination.setCity("London");

        Assert.assertEquals(destination.getCity(), "London");
    }

    @Test
    public void shouldSetDescription() {
        Destination destination = new Destination();

        destination.setDescription("Capital");

        Assert.assertEquals(destination.getDescription(), "Capital");
    }

    @Test
    public void shouldSetVisaRequirement() {
        Destination destination = new Destination();

        destination.setVisaRequired(true);

        Assert.assertTrue(destination.isVisaRequired());
    }

    @Test
    public void destinationShouldNotRequireVisa() {
        Destination destination = new Destination();

        destination.setVisaRequired(false);

        Assert.assertFalse(destination.isVisaRequired());
    }
}