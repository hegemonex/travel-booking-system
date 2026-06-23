package com.travel.booking.mybatis.mybatisdao;

import com.travel.booking.dao.interfaces.TransportDao;
import com.travel.booking.model.Transport;
import com.travel.booking.mybatis.mapper.TransportMapper;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TransportBatisDao implements TransportDao {
    @Override
    public void create(Transport transport) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TransportMapper mapper = session.getMapper(TransportMapper.class);
            mapper.create(transport);
        }
    }

    @Override
    public Transport findBy(Long id) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession()) {
            TransportMapper mapper = session.getMapper(TransportMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<Transport> findAll() {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession()) {
            TransportMapper mapper = session.getMapper(TransportMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(Transport transport) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TransportMapper mapper = session.getMapper(TransportMapper.class);
            mapper.update(transport);
        }
    }

    @Override
    public void delete(Long id) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TransportMapper mapper = session.getMapper(TransportMapper.class);
            mapper.delete(id);
        }
    }
}
