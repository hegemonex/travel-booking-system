package com.travel.booking.service.impl;

import com.travel.booking.dao.impl.HotelDaoImpl;
import com.travel.booking.dao.interfaces.HotelDao;
import com.travel.booking.model.Hotel;
import com.travel.booking.service.interfaces.HotelService;

import java.util.List;

public class HotelServiceImpl implements HotelService {

    private final HotelDao hotelDao = new HotelDaoImpl();

    @Override
    public void save(Hotel hotel) {
        hotelDao.create(hotel);
    }

    @Override
    public Hotel findById(Long id) {
        return hotelDao.findBy(id);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelDao.findAll();
    }

    @Override
    public void update(Hotel hotel) {
        hotelDao.update(hotel);
    }

    @Override
    public void delete(Long id) {
        hotelDao.delete(id);
    }
}