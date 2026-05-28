package com.travel.booking.service.impl;

import com.travel.booking.mybatis.mapper.TripMapper;
import com.travel.booking.model.Trip;
import com.travel.booking.service.interfaces.HotelService;
import com.travel.booking.service.interfaces.TripService;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TripServiceImpl implements TripService {

    private final HotelService hotelService = new HotelServiceImpl();

    @Override
    public void save(Trip trip) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            TripMapper mapper = session.getMapper(TripMapper.class);
            mapper.create(trip);
        }
    }

    @Override
    public Trip findById(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            TripMapper mapper = session.getMapper(TripMapper.class);
            return mapper.findBy(id);
        }
    }

    @Override
    public List<Trip> findAll() {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            TripMapper mapper = session.getMapper(TripMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(Trip trip) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            TripMapper mapper = session.getMapper(TripMapper.class);
            mapper.update(trip);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            TripMapper mapper = session.getMapper(TripMapper.class);
            mapper.delete(id);
        }
    }

    @Override
    public void saveTripWithHotel(Trip trip) {

        save(trip);

        if (trip.getHotel() == null) {
            throw new RuntimeException("Hotel is null in Trip");
        }

        trip.getHotel().setTrip(trip);

        hotelService.save(trip.getHotel());
    }
}