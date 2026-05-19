package com.travel.booking.service.interfaces;

import com.travel.booking.model.Transport;

import java.util.List;

public interface TransportService {
    void save(Transport transport);

    Transport findById(Long id);

    List<Transport> findAll();

    void update(Transport transport);

    void delete(Long id);
}