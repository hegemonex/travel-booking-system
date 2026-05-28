package com.travel.booking.designpatterns.listeners.interfaces;

import com.travel.booking.model.Booking;

public interface BookingListener {
    void onBookingCreated(Booking booking);
}