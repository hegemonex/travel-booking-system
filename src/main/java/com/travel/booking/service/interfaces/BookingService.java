package com.travel.booking.service.interfaces;

import com.travel.booking.model.Booking;

import java.util.List;

public interface BookingService {
    void save(Booking booking);

    Booking findById(Long id);

    List<Booking> findAll();

    void update(Booking booking);

    void delete(Long id);
}
