package com.travel.booking.service.impl;

import com.travel.booking.dao.impl.HotelDaoImpl;
import com.travel.booking.dao.impl.TripDaoImpl;
import com.travel.booking.dao.interfaces.HotelDao;
import com.travel.booking.dao.interfaces.TripDao;
import com.travel.booking.model.Hotel;
import com.travel.booking.model.Trip;
import com.travel.booking.service.interfaces.HotelService;
import com.travel.booking.service.interfaces.TripService;

import java.util.List;

public class TripServiceImpl implements TripService {

    private final TripDao tripDao = new TripDaoImpl();
    private final HotelService hotelService = new HotelServiceImpl();

    @Override
    public void save(Trip trip) {
        tripDao.create(trip);
    }

    @Override
    public Trip findById(Long id) {
        return tripDao.findBy(id);
    }

    @Override
    public List<Trip> findAll() {
        return tripDao.findAll();
    }

    @Override
    public void update(Trip trip) {
        tripDao.update(trip);
    }

    @Override
    public void delete(Long id) {
        tripDao.delete(id);
    }

    @Override
    public void saveTripWithHotel(Trip trip) {

        tripDao.create(trip);

        Hotel hotel = trip.getHotel();

        hotel.setTrip(trip);

        hotelService.save(hotel);
    }
}