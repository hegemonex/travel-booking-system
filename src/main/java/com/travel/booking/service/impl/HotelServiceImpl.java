package com.travel.booking.service.impl;

import com.travel.booking.mybatis.mapper.HotelMapper;
import com.travel.booking.model.Hotel;
import com.travel.booking.service.interfaces.HotelService;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HotelServiceImpl implements HotelService {

    @Override
    public void save(Hotel hotel) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            HotelMapper mapper = session.getMapper(HotelMapper.class);
            mapper.create(hotel);
        }
    }

    @Override
    public Hotel findById(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            HotelMapper mapper = session.getMapper(HotelMapper.class);
            return mapper.findBy(id);
        }
    }

    @Override
    public List<Hotel> findAll() {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            HotelMapper mapper = session.getMapper(HotelMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(Hotel hotel) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            HotelMapper mapper = session.getMapper(HotelMapper.class);
            mapper.update(hotel);
        }
    }

    @Override
    public void delete(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            HotelMapper mapper = session.getMapper(HotelMapper.class);
            mapper.delete(id);
        }
    }
}