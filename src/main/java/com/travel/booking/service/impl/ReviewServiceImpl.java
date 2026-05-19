package com.travel.booking.service.impl;

import com.travel.booking.dao.impl.ReviewDaoImpl;
import com.travel.booking.dao.interfaces.ReviewDao;
import com.travel.booking.model.Review;
import com.travel.booking.service.interfaces.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    private final ReviewDao reviewDao =  new ReviewDaoImpl();

    @Override
    public void save(Review review) {
        reviewDao.create(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewDao.findBy(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    @Override
    public void update(Review review) {
        reviewDao.update(review);
    }

    @Override
    public void delete(Long id) {
        reviewDao.delete(id);
    }
}
