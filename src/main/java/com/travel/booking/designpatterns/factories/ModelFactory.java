package com.travel.booking.designpatterns.factories;

import com.travel.booking.model.*;

public class ModelFactory {

    public static User createUser() {
        return new User();
    }

    public static Booking createBooking() {
        return new Booking();
    }

    public static Destination createDestination() {
        return new Destination();
    }

    public static Flight createFlight() {
        return new Flight();
    }

    public static Hotel createHotel() {
        return new Hotel();
    }

    public static Payment createPayment() {
        return new Payment();
    }

    public static Review createReview() {
        return new Review();
    }

    public static Transport createTransport() {
        return new Transport();
    }

    public static TravelBookingSystem createTravelBookingSystem() {
        return new TravelBookingSystem();
    }

    public static TravelPackage createTravelPackage() {
        return new TravelPackage();
    }

    public static Trip createTrip() {
        return new Trip();
    }
}
