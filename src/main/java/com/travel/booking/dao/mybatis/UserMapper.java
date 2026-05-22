package com.travel.booking.dao.mybatis;

import com.travel.booking.model.User;

import java.util.List;

public interface UserMapper {

    void create(User user);

    User findBy(Long id);

    List<User> findAll();

    void update(User user);

    void delete(Long id);
}