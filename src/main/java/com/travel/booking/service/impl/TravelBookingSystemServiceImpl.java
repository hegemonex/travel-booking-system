package com.travel.booking.service.impl;

import com.travel.booking.dao.impl.TravelBookingSystemDaoImpl;
import com.travel.booking.dao.interfaces.TravelBookingSystemDao;
import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.service.interfaces.TravelBookingSystemService;

import java.util.List;

public class TravelBookingSystemServiceImpl implements TravelBookingSystemService {

    private final TravelBookingSystemDao travelBookingSystemDao = new TravelBookingSystemDaoImpl();

    @Override
    public void save(TravelBookingSystem tbs) {
        travelBookingSystemDao.create(tbs);
    }

    @Override
    public TravelBookingSystem findById(Long id) {
        return travelBookingSystemDao.findBy(id);
    }

    @Override
    public List<TravelBookingSystem> findAll() {
        return travelBookingSystemDao.findAll();
    }

    @Override
    public void update(TravelBookingSystem tbs) {
        travelBookingSystemDao.update(tbs);
    }

    @Override
    public void delete(Long id) {
        travelBookingSystemDao.delete(id);
    }
}