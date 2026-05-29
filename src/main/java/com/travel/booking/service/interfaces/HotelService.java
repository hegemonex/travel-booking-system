package com.travel.booking.service.interfaces;

import com.travel.booking.dao.interfaces.HotelDao;
import com.travel.booking.model.Hotel;

import java.util.List;

public interface HotelService {
    void save(Hotel hotel);

    Hotel findById(Long id);

    List<Hotel> findAll();

    void update(Hotel hotel);

    void delete(Long id);
}
