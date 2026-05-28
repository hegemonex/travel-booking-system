package com.travel.booking.mybatis.mapper;

import com.travel.booking.model.Flight;

import java.util.List;

public interface FlightMapper {
    void create(Flight flight);

    Flight findBy(Long id);

    List<Flight> findAll();

    void update(Flight flight);

    void delete(Long id);
}
