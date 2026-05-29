package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.Review;
import com.travel.booking.model.Trip;
import com.travel.booking.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReviewBuilder {

    private final Review review = new Review();

    public ReviewBuilder id(Long id){
        review.setId(id);
        return this;
    }

    public ReviewBuilder user(User user){
        review.setUser(user);
        return this;
    }

    public ReviewBuilder trip(Trip trip){
        review.setTrip(trip);
        return this;
    }

    public ReviewBuilder rating(int rating){
        review.setRating(rating);
        return this;
    }

    public ReviewBuilder comment(String comment){
        review.setComment(comment);
        return this;
    }

    public ReviewBuilder recommended(boolean recommended){
        review.setRecommended(recommended);
        return this;
    }

    public ReviewBuilder reviewDate(LocalDate date){
        review.setReviewDate(date);
        return this;
    }

    public ReviewBuilder createdAt(LocalDateTime createdAt){
        review.setCreatedAt(createdAt);
        return this;
    }

    public Review build() {
        return review;
    }
}
