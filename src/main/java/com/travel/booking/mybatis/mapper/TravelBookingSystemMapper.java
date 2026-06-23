package com.travel.booking.mybatis.mapper;

import com.travel.booking.model.TravelBookingSystem;

import java.util.List;

public interface TravelBookingSystemMapper {
    void create(TravelBookingSystem travelBookingSystem);

    TravelBookingSystem findById(Long id);

    List<TravelBookingSystem> findAll();

    void update(TravelBookingSystem travelBookingSystem);

    void delete(Long id);
}
