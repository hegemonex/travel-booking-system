package com.travel.booking.service.interfaces;

import com.travel.booking.model.TravelPackage;

import java.util.List;

public interface TravelPackageService {
    void save(TravelPackage travelPackage);

    TravelPackage findById(Long id);

    List<TravelPackage> findAll();

    void update(TravelPackage travelPackage);

    void delete(Long id);
}