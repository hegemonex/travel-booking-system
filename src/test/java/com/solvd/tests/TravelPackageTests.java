package com.solvd.tests;

import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.model.TravelPackage;
import com.travel.booking.service.impl.TravelBookingSystemServiceImpl;
import com.travel.booking.service.impl.TravelPackageServiceImpl;
import com.travel.booking.service.interfaces.TravelBookingSystemService;
import com.travel.booking.service.interfaces.TravelPackageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TravelPackageTests {

    private TravelPackageService packageService;
    private TravelBookingSystemService tbsService;

    @BeforeClass
    public void setup() {
        packageService = new TravelPackageServiceImpl();
        tbsService = new TravelBookingSystemServiceImpl();
    }

    private TravelPackage createPackage() {

        TravelBookingSystem tbs = new TravelBookingSystem();
        tbs.setSystemName("Test System");
        tbs.setCreatedAt(LocalDateTime.now());
        tbsService.save(tbs);

        TravelPackage pack = new TravelPackage();
        pack.setName("London Package");
        pack.setDescription("All inclusive");
        pack.setPackagePrice(1200);
        pack.setActive(true);
        pack.setStartDate(LocalDate.now());
        pack.setEndDate(LocalDate.now().plusDays(5));
        pack.setCreatedAt(LocalDateTime.now());
        pack.setTravelBookingSystem(tbs);

        packageService.save(pack);

        return pack;
    }

    @Test
    public void saveTravelPackageTest() {
        TravelPackage pack = createPackage();

        Assert.assertNotNull(pack.getId(),
                "Travel package should be saved.");
    }

    @Test
    public void findTravelPackageByIdTest() {
        TravelPackage pack = createPackage();

        Assert.assertNotNull(
                packageService.findById(pack.getId()),
                "Travel package should be found.");
    }

    @Test
    public void findAllTravelPackagesTest() {
        List<TravelPackage> packages = packageService.findAll();

        Assert.assertNotNull(packages,
                "Package list should not be null.");
    }

    @Test
    public void updateTravelPackageTest() {
        TravelPackage pack = createPackage();

        pack.setName("Updated Package");
        packageService.update(pack);

        TravelPackage updated =
                packageService.findById(pack.getId());

        Assert.assertEquals(updated.getName(),
                "Updated Package",
                "Package name should be updated.");
    }

    @Test
    public void deleteTravelPackageTest() {
        TravelPackage pack = createPackage();

        packageService.delete(pack.getId());

        Assert.assertNull(packageService.findById(pack.getId()),
                "Deleted package should not exist.");
    }
}