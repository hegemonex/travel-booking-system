package com.travel.booking.service.impl;

import com.travel.booking.mybatis.mapper.ReviewMapper;
import com.travel.booking.model.Review;
import com.travel.booking.service.interfaces.ReviewService;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Override
    public void save(Review review) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            ReviewMapper mapper =
                    session.getMapper(ReviewMapper.class);

            mapper.create(review);
        }
    }

    @Override
    public Review findById(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            ReviewMapper mapper =
                    session.getMapper(ReviewMapper.class);

            return mapper.findBy(id);
        }
    }

    @Override
    public List<Review> findAll() {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            ReviewMapper mapper =
                    session.getMapper(ReviewMapper.class);

            return mapper.findAll();
        }
    }

    @Override
    public void update(Review review) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            ReviewMapper mapper =
                    session.getMapper(ReviewMapper.class);

            mapper.update(review);
        }
    }

    @Override
    public void delete(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            ReviewMapper mapper =
                    session.getMapper(ReviewMapper.class);

            mapper.delete(id);
        }
    }
}