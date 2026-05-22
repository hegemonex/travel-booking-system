package com.travel.booking.dao.mybatis;

import com.travel.booking.model.Trip;

import java.util.List;

public interface TripMapper {
    void create(Trip trip);

    Trip findBy(Long id);

    List<Trip> findAll();

    void update(Trip trip);

    void delete(Long id);

    void saveTripWithHotel(Trip trip);
}
