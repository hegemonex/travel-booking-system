package com.travel.booking.mybatis.mybatisdao;

import com.travel.booking.dao.interfaces.DestinationDao;
import com.travel.booking.model.Destination;
import com.travel.booking.mybatis.mapper.DestinationMapper;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DestinationBatisDao implements DestinationDao {
    @Override
    public void create(Destination destination) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            DestinationMapper mapper = session.getMapper(DestinationMapper.class);
            mapper.create(destination);
        }
    }

    @Override
    public Destination findBy(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {
            DestinationMapper mapper = session.getMapper(DestinationMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<Destination> findAll() {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {
            DestinationMapper mapper = session.getMapper(DestinationMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(Destination destination) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            DestinationMapper mapper = session.getMapper(DestinationMapper.class);
            mapper.update(destination);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            DestinationMapper mapper = session.getMapper(DestinationMapper.class);
            mapper.delete(id);
        }
    }
}
