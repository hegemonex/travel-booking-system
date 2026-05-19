package com.travel.booking.dao.interfaces;

import com.travel.booking.model.TravelPackage;

import java.util.List;

public interface TravelPackageDao {
    void create(TravelPackage travelPackage);

    TravelPackage findBy(Long id);

    List<TravelPackage> findAll();

    void update(TravelPackage travelPackage);

    void delete(Long id);
}