package com.travel.booking.mybatis.mapper;

import com.travel.booking.model.User;

import java.util.List;

public interface UserMapper {

    void create(User user);

    User findById(Long id);

    List<User> findAll();

    void update(User user);

    void delete(Long id);
}