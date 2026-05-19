package com.travel.booking.service.impl;

import com.travel.booking.dao.impl.TravelPackageDaoImpl;
import com.travel.booking.dao.interfaces.TravelPackageDao;
import com.travel.booking.model.TravelPackage;
import com.travel.booking.service.interfaces.TravelPackageService;

import java.util.List;

public class TravelPackageServiceImpl implements TravelPackageService {

    private final TravelPackageDao travelPackageDao = new TravelPackageDaoImpl();

    @Override
    public void save(TravelPackage travelPackage) {
        travelPackageDao.create(travelPackage);
    }

    @Override
    public TravelPackage findById(Long id) {
        return travelPackageDao.findBy(id);
    }

    @Override
    public List<TravelPackage> findAll() {
        return travelPackageDao.findAll();
    }

    @Override
    public void update(TravelPackage travelPackage) {
        travelPackageDao.update(travelPackage);
    }

    @Override
    public void delete(Long id) {
        travelPackageDao.delete(id);
    }
}