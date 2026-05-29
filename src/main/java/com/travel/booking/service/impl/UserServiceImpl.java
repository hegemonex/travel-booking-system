package com.travel.booking.service.impl;

import com.travel.booking.mybatis.mapper.UserMapper;
import com.travel.booking.model.User;
import com.travel.booking.service.interfaces.UserService;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void save(User user) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            UserMapper mapper =
                    session.getMapper(UserMapper.class);

            mapper.create(user);

            session.commit();
        }
    }

    @Override
    public User findById(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            UserMapper mapper =
                    session.getMapper(UserMapper.class);

            return mapper.findBy(id);
        }
    }

    @Override
    public List<User> findAll() {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            UserMapper mapper =
                    session.getMapper(UserMapper.class);

            return mapper.findAll();
        }
    }

    @Override
    public void update(User user) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            UserMapper mapper =
                    session.getMapper(UserMapper.class);

            mapper.update(user);

            session.commit();
        }
    }

    @Override
    public void delete(Long id) {

        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            UserMapper mapper =
                    session.getMapper(UserMapper.class);

            mapper.delete(id);

            session.commit();
        }
    }
}