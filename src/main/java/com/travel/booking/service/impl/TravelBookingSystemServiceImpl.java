package com.travel.booking.service.impl;

import com.travel.booking.mybatis.mapper.TravelBookingSystemMapper;
import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.service.interfaces.TravelBookingSystemService;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TravelBookingSystemServiceImpl implements TravelBookingSystemService {

    @Override
    public void save(TravelBookingSystem system) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            TravelBookingSystemMapper mapper =
                    session.getMapper(TravelBookingSystemMapper.class);

            mapper.create(system);
        }
    }

    @Override
    public TravelBookingSystem findById(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            TravelBookingSystemMapper mapper =
                    session.getMapper(TravelBookingSystemMapper.class);

            return mapper.findById(id);
        }
    }

    @Override
    public List<TravelBookingSystem> findAll() {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            TravelBookingSystemMapper mapper =
                    session.getMapper(TravelBookingSystemMapper.class);

            return mapper.findAll();
        }
    }

    @Override
    public void update(TravelBookingSystem system) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            TravelBookingSystemMapper mapper =
                    session.getMapper(TravelBookingSystemMapper.class);

            mapper.update(system);
        }
    }

    @Override
    public void delete(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            TravelBookingSystemMapper mapper =
                    session.getMapper(TravelBookingSystemMapper.class);

            mapper.delete(id);
        }
    }
}