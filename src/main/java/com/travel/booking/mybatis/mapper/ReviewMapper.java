package com.travel.booking.mybatis.mapper;

import com.travel.booking.model.Review;

import java.util.List;

public interface ReviewMapper {
    void create(Review review);

    Review findBy(Long id);

    List<Review> findAll();

    void update(Review review);

    void delete(Long id);
}
