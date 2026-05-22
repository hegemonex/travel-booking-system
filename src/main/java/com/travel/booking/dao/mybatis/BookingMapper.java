package com.travel.booking.dao.mybatis;

import com.travel.booking.model.Booking;

import java.util.List;

public interface BookingMapper {

        void create(Booking booking);

        Booking findBy(Long id);

        List<Booking> findAll();

        void update(Booking booking);

        void delete(Long id);

        List<Booking> findCompleteBookingInfo();
}
