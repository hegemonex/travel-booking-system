package com.travel.booking.dao.mybatis;

import com.travel.booking.model.Transport;

import java.util.List;

public interface TransportMapper {
    void create(Transport transport);

    Transport findBy(Long id);

    List<Transport> findAll();

    void update(Transport transport);

    void delete(Long id);
}
