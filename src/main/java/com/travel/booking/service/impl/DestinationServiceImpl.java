package com.travel.booking.service.impl;

import com.travel.booking.dao.impl.DestinationDaoImpl;
import com.travel.booking.dao.interfaces.DestinationDao;
import com.travel.booking.model.Destination;
import com.travel.booking.service.interfaces.DestinationService;

import java.util.List;

public class DestinationServiceImpl implements DestinationService {

    DestinationDao destinationDao = new DestinationDaoImpl();

    @Override
    public void save(Destination destination) {
        destinationDao.create(destination);
    }

    @Override
    public Destination findById(Long id) {
        return destinationDao.findBy(id);
    }

    @Override
    public List<Destination> findAll() {
        return destinationDao.findAll();
    }

    @Override
    public void update(Destination destination) {
        destinationDao.update(destination);
    }

    @Override
    public void delete(Long id) {
        destinationDao.delete(id);
    }
}
