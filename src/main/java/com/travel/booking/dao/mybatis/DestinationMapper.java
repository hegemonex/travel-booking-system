package com.travel.booking.dao.mybatis;

import com.travel.booking.model.Destination;

import java.util.List;

public interface DestinationMapper {
    void create(Destination destination);

    Destination findBy(Long id);

    List<Destination> findAll();

    void update(Destination destination);

    void delete(Long id);
}
