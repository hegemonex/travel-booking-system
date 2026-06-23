package com.travel.booking.mybatis.mybatisdao;

import com.travel.booking.dao.interfaces.FlightDao;
import com.travel.booking.model.Flight;
import com.travel.booking.mybatis.mapper.FlightMapper;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FlightBatisDao implements FlightDao {
    @Override
    public void create(Flight flight) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            FlightMapper mapper = session.getMapper(FlightMapper.class);
            mapper.create(flight);
        }
    }

    @Override
    public Flight findBy(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {
            FlightMapper mapper = session.getMapper(FlightMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<Flight> findAll() {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {
            FlightMapper mapper = session.getMapper(FlightMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(Flight flight) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            FlightMapper mapper = session.getMapper(FlightMapper.class);
            mapper.update(flight);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            FlightMapper mapper = session.getMapper(FlightMapper.class);
            mapper.delete(id);
        }
    }
}
