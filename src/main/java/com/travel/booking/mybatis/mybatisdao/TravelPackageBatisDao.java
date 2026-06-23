package com.travel.booking.mybatis.mybatisdao;

import com.travel.booking.dao.interfaces.TravelPackageDao;
import com.travel.booking.model.TravelPackage;
import com.travel.booking.mybatis.mapper.TravelPackageMapper;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TravelPackageBatisDao implements TravelPackageDao {
    @Override
    public void create(TravelPackage travelPackage) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TravelPackageMapper mapper = session.getMapper(TravelPackageMapper.class);
            mapper.create(travelPackage);
        }
    }

    @Override
    public TravelPackage findBy(Long id) {
        try(SqlSession session =
                MyBatisUtil.getSqlSessionFactory().openSession()) {
            TravelPackageMapper mapper = session.getMapper(TravelPackageMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<TravelPackage> findAll() {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession()) {
            TravelPackageMapper mapper = session.getMapper(TravelPackageMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(TravelPackage travelPackage) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TravelPackageMapper mapper = session.getMapper(TravelPackageMapper.class);
            mapper.update(travelPackage);
        }
    }

    @Override
    public void delete(Long id) {
        try(SqlSession session =
                    MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            TravelPackageMapper mapper = session.getMapper(TravelPackageMapper.class);
            mapper.delete(id);
        }
    }
}
