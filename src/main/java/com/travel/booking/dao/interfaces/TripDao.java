package com.travel.booking.dao.interfaces;

import com.travel.booking.model.Trip;

import java.util.List;

public interface TripDao {
    void create(Trip trip);

    Trip findBy(Long id);

    List<Trip> findAll();

    void update(Trip trip);

    void delete(Long id);
}
