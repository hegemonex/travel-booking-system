package com.travel.booking.dao.interfaces;

import com.travel.booking.model.Review;

import java.util.List;

public interface ReviewDao {
    void create(Review review);

    Review findBy(Long id);

    List<Review> findAll();

    void update(Review review);

    void delete(Long id);
}
