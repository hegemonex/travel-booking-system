package com.travel.booking.service.interfaces;

import com.travel.booking.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findById(Long id);

    List<User> findAll();

    void update(User user);

    void delete(Long id);
}
