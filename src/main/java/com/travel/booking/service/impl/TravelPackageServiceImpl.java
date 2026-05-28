package com.travel.booking.service.impl;

import com.travel.booking.mybatis.mapper.TravelPackageMapper;
import com.travel.booking.model.TravelPackage;
import com.travel.booking.service.interfaces.TravelPackageService;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TravelPackageServiceImpl implements TravelPackageService {

    @Override
    public void save(TravelPackage travelPackage) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            TravelPackageMapper mapper =
                    session.getMapper(TravelPackageMapper.class);

            mapper.create(travelPackage);
        }
    }

    @Override
    public TravelPackage findById(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            TravelPackageMapper mapper =
                    session.getMapper(TravelPackageMapper.class);

            return mapper.findBy(id);
        }
    }

    @Override
    public List<TravelPackage> findAll() {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            TravelPackageMapper mapper =
                    session.getMapper(TravelPackageMapper.class);

            return mapper.findAll();
        }
    }

    @Override
    public void update(TravelPackage travelPackage) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            TravelPackageMapper mapper =
                    session.getMapper(TravelPackageMapper.class);

            mapper.update(travelPackage);
        }
    }

    @Override
    public void delete(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            TravelPackageMapper mapper =
                    session.getMapper(TravelPackageMapper.class);

            mapper.delete(id);
        }
    }
}