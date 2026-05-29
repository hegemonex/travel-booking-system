package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.Booking;
import com.travel.booking.model.Payment;
import com.travel.booking.model.Trip;
import com.travel.booking.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingBuilder {

    private final Booking booking = new Booking();

    public BookingBuilder user(User user) {
        booking.setUser(user);
        return this;
    }

    public BookingBuilder trip(Trip trip) {
        booking.setTrip(trip);
        return this;
    }

    public BookingBuilder payment(Payment payment) {
        booking.setPayment(payment);
        return this;
    }

    public BookingBuilder id(Long id) {
        booking.setId(id);
        return this;
    }

    public BookingBuilder totalPrice(double price) {
        booking.setTotalPrice(price);
        return this;
    }

    public BookingBuilder confirmed(boolean confirmed) {
        booking.setConfirmed(confirmed);
        return this;
    }

    public BookingBuilder bookingDate(LocalDate date) {
        booking.setBookingDate(date);
        return this;
    }

    public BookingBuilder createdAt(LocalDateTime time) {
        booking.setCreatedAt(time);
        return this;
    }

    public Booking build() {
        return booking;
    }
}
