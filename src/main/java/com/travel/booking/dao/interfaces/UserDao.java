package com.travel.booking.dao.interfaces;

import com.travel.booking.model.User;

import java.util.List;

public interface UserDao {

    void create(User user);

    User findBy(Long id);

    List<User> findAll();

    void update(User user);

    void delete(Long id);
}
