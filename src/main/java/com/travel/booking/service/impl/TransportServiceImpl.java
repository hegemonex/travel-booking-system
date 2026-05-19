package com.travel.booking.service.impl;

import com.travel.booking.dao.interfaces.TransportDao;
import com.travel.booking.dao.impl.TransportDaoImpl;
import com.travel.booking.model.Transport;
import com.travel.booking.service.interfaces.TransportService;

import java.util.List;

public class TransportServiceImpl implements TransportService {

    private final TransportDao transportDao = new TransportDaoImpl();

    @Override
    public void save(Transport transport) {
        transportDao.create(transport);
    }

    @Override
    public Transport findById(Long id) {
        return transportDao.findBy(id);
    }

    @Override
    public List<Transport> findAll() {
        return transportDao.findAll();
    }

    @Override
    public void update(Transport transport) {
        transportDao.update(transport);
    }

    @Override
    public void delete(Long id) {
        transportDao.delete(id);
    }
}