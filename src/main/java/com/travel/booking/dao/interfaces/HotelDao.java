package com.travel.booking.dao.interfaces;

import com.travel.booking.model.Destination;
import com.travel.booking.model.Hotel;

import java.util.List;

public interface HotelDao {

    void create(Hotel hotel);

    Hotel findBy(Long id);

    List<Hotel> findAll();

    void update(Hotel hotel);

    void delete(Long id);
}
