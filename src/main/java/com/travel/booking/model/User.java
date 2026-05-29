package com.travel.booking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private List<Booking> bookings;
    private List<Review> reviews;
    private TravelBookingSystem travelBookingSystem;

    public User() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }

    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }

    public TravelBookingSystem getTravelBookingSystem() { return travelBookingSystem; }
    public void setTravelBookingSystem(TravelBookingSystem travelBookingSystem) {
        this.travelBookingSystem = travelBookingSystem;
    }

    public static class Builder {

        private final User user = new User();

        public Builder id(Long id) {
            user.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            user.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            user.phoneNumber = phoneNumber;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            user.birthDate = birthDate;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            user.createdAt = createdAt;
            return this;
        }

        public Builder bookings(List<Booking> bookings) {
            user.bookings = bookings;
            return this;
        }

        public Builder reviews(List<Review> reviews) {
            user.reviews = reviews;
            return this;
        }

        public Builder travelBookingSystem(TravelBookingSystem travelBookingSystem) {
            user.travelBookingSystem = travelBookingSystem;
            return this;
        }

        public User build() {
            return user;
        }
    }
}