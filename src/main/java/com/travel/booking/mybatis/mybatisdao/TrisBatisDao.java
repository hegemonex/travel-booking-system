package com.travel.booking.mybatis.mybatisdao;

import com.travel.booking.dao.interfaces.TripDao;
import com.travel.booking.model.Trip;
import com.travel.booking.mybatis.mapper.TripMapper;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TrisBatisDao implements TripDao {

    @Override
    public void create(Trip trip) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TripMapper mapper = session.getMapper(TripMapper.class);
            mapper.create(trip);
        }
    }

    @Override
    public Trip findBy(Long id) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession()) {
            TripMapper mapper = session.getMapper(TripMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<Trip> findAll() {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession()) {
            TripMapper mapper = session.getMapper(TripMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(Trip trip) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TripMapper mapper = session.getMapper(TripMapper.class);
            mapper.update(trip);
        }
    }

    @Override
    public void delete(Long id) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TripMapper mapper = session.getMapper(TripMapper.class);
            mapper.delete(id);
        }
    }
}
