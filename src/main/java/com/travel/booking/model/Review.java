package com.travel.booking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Review {

    private Long id;
    private User user;
    private Trip trip;
    private int rating;
    private String comment;
    private boolean recommended;
    private LocalDate reviewDate;
    private LocalDateTime createdAt;

    public Review() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Trip getTrip() { return trip; }
    public void setTrip(Trip trip) { this.trip = trip; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public boolean isRecommended() { return recommended; }
    public void setRecommended(boolean recommended) { this.recommended = recommended; }

    public LocalDate getReviewDate() { return reviewDate; }
    public void setReviewDate(LocalDate reviewDate) { this.reviewDate = reviewDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public static class Builder {

        private final Review review = new Review();

        public Builder id(Long id) {
            review.id = id;
            return this;
        }

        public Builder user(User user) {
            review.user = user;
            return this;
        }

        public Builder trip(Trip trip) {
            review.trip = trip;
            return this;
        }

        public Builder rating(int rating) {
            review.rating = rating;
            return this;
        }

        public Builder comment(String comment) {
            review.comment = comment;
            return this;
        }

        public Builder recommended(boolean recommended) {
            review.recommended = recommended;
            return this;
        }

        public Builder reviewDate(LocalDate reviewDate) {
            review.reviewDate = reviewDate;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            review.createdAt = createdAt;
            return this;
        }

        public Review build() {
            return review;
        }
    }
}