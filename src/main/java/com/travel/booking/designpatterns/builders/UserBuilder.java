package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.Booking;
import com.travel.booking.model.Review;
import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserBuilder {

    private final User user =  new User();

    public UserBuilder id(Long id) {
        this.user.setId(id);
        return this;
    }

    public UserBuilder firstName(String firstName) {
        this.user.setFirstName(firstName);
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.user.setLastName(lastName);
        return this;
    }

    public UserBuilder email(String email) {
        this.user.setEmail(email);
        return this;
    }

    public UserBuilder phone(String phone) {
        user.setPhoneNumber(phone);
        return this;
    }

    public UserBuilder birthDate(LocalDate birthDate) {
        user.setBirthDate(birthDate);
        return this;
    }

    public UserBuilder createdAt(LocalDateTime createdAt) {
        user.setCreatedAt(createdAt);
        return this;
    }

    public UserBuilder bookings(List<Booking> bookings){
        user.setBookings(bookings);
        return this;
    }

    public UserBuilder reviews(List<Review> reviews){
        user.setReviews(reviews);
        return this;
    }

    public UserBuilder travelBookingSystem(TravelBookingSystem travelBookingSystem){
        user.setTravelBookingSystem(travelBookingSystem);
        return this;
    }

    public User build() {
        return user;
    }
}
