package com.travel.booking.service.interfaces;

import com.travel.booking.model.TravelBookingSystem;

import java.util.List;

public interface TravelBookingSystemService {
    void save(TravelBookingSystem tbs);

    TravelBookingSystem findById(Long id);

    List<TravelBookingSystem> findAll();

    void update(TravelBookingSystem tbs);

    void delete(Long id);
}