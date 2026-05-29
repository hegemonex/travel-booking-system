package com.travel.booking.model;

import java.time.LocalDateTime;

public class Hotel {

    private Long id;
    private String name;
    private String city;
    private String address;
    private Trip trip;
    private int starRating;
    private boolean breakfastIncluded;
    private double pricePerNight;
    private LocalDateTime createdAt;

    public Hotel() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Trip getTrip() { return trip; }
    public void setTrip(Trip trip) { this.trip = trip; }

    public int getStarRating() { return starRating; }
    public void setStarRating(int starRating) { this.starRating = starRating; }

    public boolean isBreakfastIncluded() { return breakfastIncluded; }
    public void setBreakfastIncluded(boolean breakfastIncluded) { this.breakfastIncluded = breakfastIncluded; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public static class Builder {

        private final Hotel hotel = new Hotel();

        public Builder id(Long id) {
            hotel.id = id;
            return this;
        }

        public Builder name(String name) {
            hotel.name = name;
            return this;
        }

        public Builder city(String city) {
            hotel.city = city;
            return this;
        }

        public Builder address(String address) {
            hotel.address = address;
            return this;
        }

        public Builder trip(Trip trip) {
            hotel.trip = trip;
            return this;
        }

        public Builder starRating(int starRating) {
            hotel.starRating = starRating;
            return this;
        }

        public Builder breakfastIncluded(boolean breakfastIncluded) {
            hotel.breakfastIncluded = breakfastIncluded;
            return this;
        }

        public Builder pricePerNight(double pricePerNight) {
            hotel.pricePerNight = pricePerNight;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            hotel.createdAt = createdAt;
            return this;
        }

        public Hotel build() {
            return hotel;
        }
    }
}