package com.travel.booking.dao.mybatis;

import com.travel.booking.model.TravelPackage;

import java.util.List;

public interface TravelPackageMapper {
    void create(TravelPackage travelPackage);

    TravelPackage findBy(Long id);

    List<TravelPackage> findAll();

    void update(TravelPackage travelPackage);

    void delete(Long id);
}
