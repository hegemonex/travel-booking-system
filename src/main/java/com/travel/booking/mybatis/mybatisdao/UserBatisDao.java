package com.travel.booking.mybatis.mybatisdao;

import com.travel.booking.dao.interfaces.UserDao;
import com.travel.booking.model.User;
import com.travel.booking.mybatis.mapper.UserMapper;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserBatisDao implements UserDao {
    @Override
    public void create(User user) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.create(user);
        }
    }

    @Override
    public User findBy(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.findBy(id);
        }
    }


    @Override
    public List<User> findAll() {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(User user) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.update(user);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {

            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.delete(id);
        }
    }
}