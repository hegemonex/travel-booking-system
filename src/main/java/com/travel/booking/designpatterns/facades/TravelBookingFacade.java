package com.travel.booking.designpatterns.facades;

import com.travel.booking.model.Booking;
import com.travel.booking.model.Payment;
import com.travel.booking.model.Trip;
import com.travel.booking.service.interfaces.BookingService;
import com.travel.booking.service.interfaces.PaymentService;
import com.travel.booking.service.interfaces.TripService;

public class TravelBookingFacade {

    private final TripService tripService;
    private final BookingService bookingService;
    private final PaymentService paymentService;

    public TravelBookingFacade(
            TripService tripService,
            BookingService bookingService,
            PaymentService paymentService
    ) {
        this.tripService = tripService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    public void createFullBooking(Trip trip, Booking booking, Payment payment) {

        tripService.saveTripWithHotel(trip);

        paymentService.save(payment);

        booking.setPayment(payment);

        bookingService.save(booking);
    }
}