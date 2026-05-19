package com.travel.booking.service.interfaces;

import com.travel.booking.model.Flight;

import java.util.List;

public interface FlightService {
    void save(Flight flight);

    Flight findById(Long id);

    List<Flight> findAll();

    void update(Flight flight);

    void delete(Long id);
}
