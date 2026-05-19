package com.travel.booking.service.impl;

import com.travel.booking.dao.impl.FlightDaoImpl;
import com.travel.booking.dao.interfaces.FlightDao;
import com.travel.booking.model.Flight;
import com.travel.booking.service.interfaces.FlightService;

import java.util.List;

public class FlightServiceImpl implements FlightService {

    FlightDao flightDao =  new FlightDaoImpl();

    @Override
    public void save(Flight flight) {
        flightDao.create(flight);
    }

    @Override
    public Flight findById(Long id) {
        return flightDao.findBy(id);
    }

    @Override
    public List<Flight> findAll() {
        return flightDao.findAll();
    }

    @Override
    public void update(Flight flight) {
        flightDao.update(flight);
    }

    @Override
    public void delete(Long id) {
        flightDao.delete(id);
    }
}
