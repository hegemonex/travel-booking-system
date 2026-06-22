package com.solvd.tests;

import com.travel.booking.model.TravelPackage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TravelPackageTests extends BaseTests {

    @Test
    public void shouldSetName() {
        TravelPackage pack = new TravelPackage();

        pack.setName("Europe Tour");

        Assert.assertEquals(pack.getName(), "Europe Tour");
    }

    @Test
    public void shouldSetDescription() {
        TravelPackage pack = new TravelPackage();

        pack.setDescription("All Inclusive");

        Assert.assertEquals(pack.getDescription(), "All Inclusive");
    }

    @Test
    public void shouldSetPrice() {
        TravelPackage pack = new TravelPackage();

        pack.setPackagePrice(1500);

        Assert.assertEquals(pack.getPackagePrice(), 1500.0);
    }

    @Test
    public void shouldBeActive() {
        TravelPackage pack = new TravelPackage();

        pack.setActive(true);

        Assert.assertTrue(pack.isActive());
    }

    @Test
    public void shouldSetStartDate() {
        TravelPackage pack = new TravelPackage();

        LocalDate date = LocalDate.of(2025, 6, 1);

        pack.setStartDate(date);

        Assert.assertEquals(pack.getStartDate(), date);
    }
}
