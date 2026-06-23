package com.travel.booking.mybatis.mapper;

import com.travel.booking.model.Trip;

import java.util.List;

public interface TripMapper {
    void create(Trip trip);

    Trip findById(Long id);

    List<Trip> findAll();

    void update(Trip trip);

    void delete(Long id);

    void saveTripWithHotel(Trip trip);
}
