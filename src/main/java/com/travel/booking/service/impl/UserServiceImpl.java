package com.travel.booking.service.impl;

import com.travel.booking.dao.interfaces.UserDao;
import com.travel.booking.dao.impl.UserDaoImpl;
import com.travel.booking.model.User;
import com.travel.booking.service.interfaces.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void save(User user) {
        userDao.create(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findBy(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
