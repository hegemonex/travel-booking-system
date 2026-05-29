package com.travel.booking.service.interfaces;

import com.travel.booking.model.Destination;

import java.util.List;

public interface DestinationService {
    void save(Destination destination);

    Destination findById(Long id);

    List<Destination> findAll();

    void update(Destination destination);

    void delete(Long id);
}
