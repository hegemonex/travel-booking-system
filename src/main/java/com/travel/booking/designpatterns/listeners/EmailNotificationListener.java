package com.travel.booking.designpatterns.listeners;

import com.travel.booking.designpatterns.listeners.interfaces.BookingListener;
import com.travel.booking.model.Booking;

public class EmailNotificationListener implements BookingListener {
    public void onBookingCreated(Booking booking) {
        System.out.println("Email sent for booking!");
    }
}
