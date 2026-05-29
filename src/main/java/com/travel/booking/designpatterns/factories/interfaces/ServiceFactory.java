package com.travel.booking.designpatterns.factories.interfaces;

import com.travel.booking.service.interfaces.*;

public interface ServiceFactory {

    UserService createUserService();

    BookingService createBookingService();

    FlightService createFlightService();

    HotelService createHotelService();

    PaymentService createPaymentService();

    ReviewService createReviewService();

    TransportService createTransportService();

    TravelBookingSystemService createTravelBookingSystemService();

    TravelPackageService createTravelPackageService();

    TripService createTripService();

    DestinationService createDestinationService();
}