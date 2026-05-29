package com.travel.booking.designpatterns.factories;

import com.travel.booking.designpatterns.factories.interfaces.ServiceFactory;
import com.travel.booking.service.impl.*;
import com.travel.booking.service.interfaces.*;

public class MyBatisServiceFactory implements ServiceFactory {

    @Override
    public UserService createUserService() {
        return new UserServiceImpl();
    }

    @Override
    public BookingService createBookingService() {
        return new BookingServiceImpl();
    }

    @Override
    public FlightService createFlightService() {
        return new FlightServiceImpl();
    }

    @Override
    public HotelService createHotelService() {
        return new HotelServiceImpl();
    }

    @Override
    public PaymentService createPaymentService() {
        return new PaymentServiceImpl();
    }

    @Override
    public ReviewService createReviewService() {
        return new ReviewServiceImpl();
    }

    @Override
    public TransportService createTransportService() {
        return new TransportServiceImpl();
    }

    @Override
    public TravelBookingSystemService createTravelBookingSystemService() {
        return new TravelBookingSystemServiceImpl();
    }

    @Override
    public TravelPackageService createTravelPackageService() {
        return new TravelPackageServiceImpl();
    }

    @Override
    public TripService createTripService() {
        return new TripServiceImpl();
    }

    @Override
    public DestinationService createDestinationService() {
        return new DestinationServiceImpl();
    }
}