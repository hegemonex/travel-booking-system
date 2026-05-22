package com.travel.booking.dao.mybatis;

import com.travel.booking.model.TravelBookingSystem;

import java.util.List;

public interface TravelBookingSystemMapper {
    void create(TravelBookingSystem travelBookingSystem);

    TravelBookingSystem findBy(Long id);

    List<TravelBookingSystem> findAll();

    void update(TravelBookingSystem travelBookingSystem);

    void delete(Long id);
}
