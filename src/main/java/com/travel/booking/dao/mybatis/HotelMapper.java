package com.travel.booking.dao.mybatis;

import com.travel.booking.model.Hotel;

import java.util.List;

public interface HotelMapper {
    void create(Hotel hotel);

    Hotel findBy(Long id);

    List<Hotel> findAll();

    void update(Hotel hotel);

    void delete(Long id);
}
