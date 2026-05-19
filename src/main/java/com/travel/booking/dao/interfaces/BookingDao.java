package com.travel.booking.dao.interfaces;

import com.travel.booking.model.Booking;

import java.util.List;

public interface BookingDao {
    void create(Booking booking);

    Booking findBy(Long id);

    List<Booking> findAll();

    void update(Booking booking);

    void delete(Long id);
}
