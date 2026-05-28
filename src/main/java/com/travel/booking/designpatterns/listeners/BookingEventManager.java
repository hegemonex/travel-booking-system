package com.travel.booking.designpatterns.listeners;

import com.travel.booking.designpatterns.listeners.interfaces.BookingListener;
import com.travel.booking.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingEventManager {

    private List<BookingListener> listeners = new ArrayList<>();

    public void subscribe(BookingListener listener) {
        listeners.add(listener);
    }

    public void notifyAllListeners(Booking booking) {
        for (BookingListener l : listeners) {
            l.onBookingCreated(booking);
        }
    }
}