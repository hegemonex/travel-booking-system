package com.travel.booking.service.interfaces;

import com.travel.booking.model.Review;

import java.util.List;

public interface ReviewService {
    void save(Review review);

    Review findById(Long id);

    List<Review> findAll();

    void update(Review review);

    void delete(Long id);
}
