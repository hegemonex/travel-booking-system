package com.travel.booking.service.interfaces;

import com.travel.booking.dao.interfaces.TripDao;
import com.travel.booking.model.Hotel;
import com.travel.booking.model.Trip;

import java.util.List;

public interface TripService {

    void save(Trip trip);

    Trip findById(Long id);

    List<Trip> findAll();

    void update(Trip trip);

    void delete(Long id);


    void saveTripWithHotel(Trip trip);
}