package com.travel.booking.mybatis.mapper;

import com.travel.booking.model.Hotel;

import java.util.List;

public interface HotelMapper {
    void create(Hotel hotel);

    Hotel findById(Long id);

    List<Hotel> findAll();

    void update(Hotel hotel);

    void delete(Long id);
}
