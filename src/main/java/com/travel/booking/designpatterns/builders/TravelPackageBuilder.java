package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.model.TravelPackage;
import com.travel.booking.model.Trip;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TravelPackageBuilder {

    private final TravelPackage travelPackage = new TravelPackage();

    public TravelPackageBuilder id(Long id) {
        travelPackage.setId(id);
        return this;
    }

    public  TravelPackageBuilder name(String name) {
        travelPackage.setName(name);
        return this;
    }

    public TravelPackageBuilder description(String description) {
        travelPackage.setDescription(description);
        return this;
    }

    public TravelPackageBuilder packagePrice(Double packagePrice) {
        travelPackage.setPackagePrice(packagePrice);
        return this;
    }

    public TravelPackageBuilder active(Boolean active) {
        travelPackage.setActive(active);
        return this;
    }

    public TravelPackageBuilder startDate(LocalDate startDate) {
        travelPackage.setStartDate(startDate);
        return this;
    }

    public TravelPackageBuilder endDate(LocalDate endDate) {
        travelPackage.setEndDate(endDate);
        return this;
    }

    public TravelPackageBuilder createdAt(LocalDateTime  createdAt) {
        travelPackage.setCreatedAt(createdAt);
        return this;
    }

    public TravelPackageBuilder trips(List<Trip> trips) {
        travelPackage.setTrips(trips);
        return this;
    }

    public TravelPackageBuilder travelBookingSystem(TravelBookingSystem travelBookingSystem) {
        travelPackage.setTravelBookingSystem(travelBookingSystem);
        return this;
    }

    public TravelPackage build() {
        return travelPackage;
    }
}

