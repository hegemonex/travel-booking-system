package com.travel.booking.service.impl;

import com.travel.booking.dao.impl.TripDaoImpl;
import com.travel.booking.dao.interfaces.TripDao;
import com.travel.booking.model.Trip;
import com.travel.booking.service.interfaces.TripService;

import java.util.List;

public class TripServiceImpl implements TripService {

    TripDao tripDao = new TripDaoImpl();

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
}
