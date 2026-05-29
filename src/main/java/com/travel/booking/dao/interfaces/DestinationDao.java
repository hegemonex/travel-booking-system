package com.travel.booking.dao.interfaces;

import com.travel.booking.model.Destination;

import java.util.List;

public interface DestinationDao {
    void create(Destination destination);

    Destination findBy(Long id);

    List<Destination> findAll();

    void update(Destination destination);

    void delete(Long id);
}
