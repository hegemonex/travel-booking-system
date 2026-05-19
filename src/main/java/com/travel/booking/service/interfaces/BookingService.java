package com.travel.booking.service.interfaces;

import com.travel.booking.model.Booking;
import com.travel.booking.model.Hotel;

import java.util.List;

public interface BookingService {
    void save(Booking booking);

    Booking findById(Long id);

    List<Booking> findAll();

    void update(Booking booking);

    void delete(Long id);

    List<Booking> findCompleteBookingInfo();
}
