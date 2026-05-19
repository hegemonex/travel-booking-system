package com.travel.booking.dao.interfaces;

import com.travel.booking.model.TravelBookingSystem;

import java.util.List;

public interface TravelBookingSystemDao {
    void create(TravelBookingSystem tbs);

    TravelBookingSystem findBy(Long id);

    List<TravelBookingSystem> findAll();

    void update(TravelBookingSystem tbs);

    void delete(Long id);
}