package com.travel.booking.mybatis.mybatisdao;

import com.travel.booking.dao.interfaces.HotelDao;
import com.travel.booking.model.Hotel;
import com.travel.booking.mybatis.mapper.HotelMapper;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HotelBatisDao implements HotelDao {
    @Override
    public void create(Hotel hotel) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            HotelMapper mapper = session.getMapper(HotelMapper.class);
            mapper.create(hotel);
        }
    }

    @Override
    public Hotel findBy(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {
            HotelMapper mapper = session.getMapper(HotelMapper.class);
            return mapper.findById(id);
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
