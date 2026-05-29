package com.travel.booking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TravelPackage {

    private Long id;
    private String name;
    private String description;
    private double packagePrice;
    private boolean active;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;
    private List<Trip> trips;
    private TravelBookingSystem travelBookingSystem;

    public TravelPackage() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPackagePrice() { return packagePrice; }
    public void setPackagePrice(double packagePrice) { this.packagePrice = packagePrice; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<Trip> getTrips() { return trips; }
    public void setTrips(List<Trip> trips) { this.trips = trips; }

    public TravelBookingSystem getTravelBookingSystem() { return travelBookingSystem; }
    public void setTravelBookingSystem(TravelBookingSystem travelBookingSystem) {
        this.travelBookingSystem = travelBookingSystem;
    }

    public static class Builder {

        private final TravelPackage travelPackage = new TravelPackage();

        public Builder id(Long id) {
            travelPackage.id = id;
            return this;
        }

        public Builder name(String name) {
            travelPackage.name = name;
            return this;
        }

        public Builder description(String description) {
            travelPackage.description = description;
            return this;
        }

        public Builder packagePrice(double packagePrice) {
            travelPackage.packagePrice = packagePrice;
            return this;
        }

        public Builder active(boolean active) {
            travelPackage.active = active;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            travelPackage.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            travelPackage.endDate = endDate;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            travelPackage.createdAt = createdAt;
            return this;
        }

        public Builder trips(List<Trip> trips) {
            travelPackage.trips = trips;
            return this;
        }

        public Builder travelBookingSystem(TravelBookingSystem travelBookingSystem) {
            travelPackage.travelBookingSystem = travelBookingSystem;
            return this;
        }

        public TravelPackage build() {
            return travelPackage;
        }
    }
}