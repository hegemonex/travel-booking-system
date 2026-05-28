package com.travel.booking.mybatis.mybatisdao;

import com.travel.booking.dao.interfaces.TravelBookingSystemDao;
import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.mybatis.mapper.TravelBookingSystemMapper;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TravelBookingSystemBatisDao implements TravelBookingSystemDao {
    @Override
    public void create(TravelBookingSystem tbs) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TravelBookingSystemMapper mapper = session.getMapper(TravelBookingSystemMapper.class);
            mapper.create(tbs);
        }
    }

    @Override
    public TravelBookingSystem findBy(Long id) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession()) {
            TravelBookingSystemMapper mapper = session.getMapper(TravelBookingSystemMapper.class);
            return mapper.findBy(id);
        }
    }

    @Override
    public List<TravelBookingSystem> findAll() {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession()) {
            TravelBookingSystemMapper mapper = session.getMapper(TravelBookingSystemMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(TravelBookingSystem tbs) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TravelBookingSystemMapper mapper = session.getMapper(TravelBookingSystemMapper.class);
            mapper.update(tbs);
        }
    }

    @Override
    public void delete(Long id) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TravelBookingSystemMapper mapper = session.getMapper(TravelBookingSystemMapper.class);
            mapper.delete(id);
        }
    }
}
