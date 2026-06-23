package com.travel.booking.service.impl;

import com.travel.booking.mybatis.mapper.BookingMapper;
import com.travel.booking.model.Booking;
import com.travel.booking.service.interfaces.BookingService;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    @Override
    public void save(Booking booking) {

        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            BookingMapper mapper = session.getMapper(BookingMapper.class);
            mapper.create(booking);
        }
    }

    @Override
    public Booking findById(Long id) {

        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {

            BookingMapper mapper = session.getMapper(BookingMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<Booking> findAll() {

        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {

            BookingMapper mapper = session.getMapper(BookingMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(Booking booking) {

        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            BookingMapper mapper = session.getMapper(BookingMapper.class);
            mapper.update(booking);
        }
    }

    @Override
    public void delete(Long id) {

        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            BookingMapper mapper = session.getMapper(BookingMapper.class);
            mapper.delete(id);
        }
    }

    @Override
    public List<Booking> findCompleteBookingInfo() {

        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {

            BookingMapper mapper = session.getMapper(BookingMapper.class);
            return mapper.findCompleteBookingInfo();
        }
    }
}