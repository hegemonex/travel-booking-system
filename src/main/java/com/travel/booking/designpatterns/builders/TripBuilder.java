package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.*;

import java.time.LocalDate;
import java.util.List;

public class TripBuilder {

    private final Trip trip = new Trip();

    public TripBuilder id(Long id) {
        trip.setId(id);
        return this;
    }

    public TripBuilder hotel(Hotel hotel) {
        trip.setHotel(hotel);
        return this;
    }

    public TripBuilder flight(Flight flight) {
        trip.setFlight(flight);
        return this;
    }

    public TripBuilder transport(Transport transport) {
        trip.setTransport(transport);
        return this;
    }

    public TripBuilder packages(Package packages) {
        trip.setPackage(packages);
        return this;
    }

    public TripBuilder travelPackage(TravelPackage travelPackage) {
        trip.setTravelPackage(travelPackage);
        return this;
    }

    public TripBuilder travelBookingSystem(TravelBookingSystem travelBookingSystem) {
        trip.setTravelBookingSystem(travelBookingSystem);
        return this;
    }

    public TripBuilder title(String title) {
        trip.setTitle(title);
        return this;
    }

    public TripBuilder description(String description) {
        trip.setDescription(description);
        return this;
    }

    public TripBuilder price(Double price) {
        trip.setPrice(price);
        return this;
    }

    public TripBuilder available(boolean available) {
        trip.setAvailabe(available);
        return this;
    }

    public TripBuilder departureDate(LocalDate departureDate) {
        trip.setDepartureDate(departureDate);
        return this;
    }

    public TripBuilder returningDate(LocalDate returningDate) {
        trip.setReturnDate(returningDate);
        return this;
    }

    public TripBuilder createdAt(LocalDate createdAt) {
        trip.setCreatedAt(createdAt);
        return this;
    }

    public TripBuilder destinations(List<Destination> destinations){
        trip.setDestinations(destinations);
        return this;
    }

    public TripBuilder reviews(List<Review> reviews){
        trip.setReviews(reviews);
        return this;
    }

    public Trip build() {
        return trip;
    }
}
