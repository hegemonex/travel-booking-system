package com.travel.booking.model;

import java.time.LocalDate;
import java.util.List;

public class Trip {

    private Long id;
    private Hotel hotel;
    private Flight flight;
    private Transport transport;
    private TravelPackage travelPackage;
    private TravelBookingSystem travelBookingSystem;
    private String title;
    private String description;
    private double price;
    private boolean available;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private LocalDate createdAt;
    private List<Destination> destinations;
    private List<Review> reviews;

    public Trip() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }

    public Transport getTransport() { return transport; }
    public void setTransport(Transport transport) { this.transport = transport; }

    public TravelPackage getTravelPackage() { return travelPackage; }
    public void setTravelPackage(TravelPackage travelPackage) { this.travelPackage = travelPackage; }

    public TravelBookingSystem getTravelBookingSystem() { return travelBookingSystem; }
    public void setTravelBookingSystem(TravelBookingSystem travelBookingSystem) {
        this.travelBookingSystem = travelBookingSystem;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailabe() { return available; }
    public void setAvailabe(boolean available) { this.available = available; }

    public LocalDate getDepartureDate() { return departureDate; }
    public void setDepartureDate(LocalDate departureDate) { this.departureDate = departureDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public List<Destination> getDestinations() { return destinations; }
    public void setDestinations(List<Destination> destinations) { this.destinations = destinations; }

    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }

    public static class Builder {

        private final Trip trip = new Trip();

        public Builder id(Long id) {
            trip.id = id;
            return this;
        }

        public Builder hotel(Hotel hotel) {
            trip.hotel = hotel;
            return this;
        }

        public Builder flight(Flight flight) {
            trip.flight = flight;
            return this;
        }

        public Builder transport(Transport transport) {
            trip.transport = transport;
            return this;
        }

        public Builder travelPackage(TravelPackage travelPackage) {
            trip.travelPackage = travelPackage;
            return this;
        }

        public Builder travelBookingSystem(TravelBookingSystem travelBookingSystem) {
            trip.travelBookingSystem = travelBookingSystem;
            return this;
        }

        public Builder title(String title) {
            trip.title = title;
            return this;
        }

        public Builder description(String description) {
            trip.description = description;
            return this;
        }

        public Builder price(double price) {
            trip.price = price;
            return this;
        }

        public Builder available(boolean available) {
            trip.available = available;
            return this;
        }

        public Builder departureDate(LocalDate departureDate) {
            trip.departureDate = departureDate;
            return this;
        }

        public Builder returnDate(LocalDate returnDate) {
            trip.returnDate = returnDate;
            return this;
        }

        public Builder createdAt(LocalDate createdAt) {
            trip.createdAt = createdAt;
            return this;
        }

        public Builder destinations(List<Destination> destinations) {
            trip.destinations = destinations;
            return this;
        }

        public Builder reviews(List<Review> reviews) {
            trip.reviews = reviews;
            return this;
        }

        public Trip build() {
            return trip;
        }
    }
}