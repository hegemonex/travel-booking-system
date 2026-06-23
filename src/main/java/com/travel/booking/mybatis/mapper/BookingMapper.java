package com.travel.booking.mybatis.mapper;

import com.travel.booking.model.Booking;

import java.util.List;

public interface BookingMapper {

        void create(Booking booking);

        Booking findById(Long id);

        List<Booking> findAll();

        void update(Booking booking);

        void delete(Long id);

        List<Booking> findCompleteBookingInfo();
}
