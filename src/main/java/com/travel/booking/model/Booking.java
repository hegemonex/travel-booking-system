package com.travel.booking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {

    private Long id;
    private Trip trip;
    private User user;
    private Payment payment;
    private double totalPrice;
    private boolean confirmed;
    private LocalDate bookingDate;
    private LocalDateTime createdAt;

    public Booking() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Trip getTrip() { return trip; }
    public void setTrip(Trip trip) { this.trip = trip; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }


    public static class Builder {

        private final Booking booking = new Booking();

        public Builder id(Long id) {
            booking.id = id;
            return this;
        }

        public Builder trip(Trip trip) {
            booking.trip = trip;
            return this;
        }

        public Builder user(User user) {
            booking.user = user;
            return this;
        }

        public Builder payment(Payment payment) {
            booking.payment = payment;
            return this;
        }

        public Builder totalPrice(double totalPrice) {
            booking.totalPrice = totalPrice;
            return this;
        }

        public Builder confirmed(boolean confirmed) {
            booking.confirmed = confirmed;
            return this;
        }

        public Builder bookingDate(LocalDate bookingDate) {
            booking.bookingDate = bookingDate;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            booking.createdAt = createdAt;
            return this;
        }

        public Booking build() {
            return booking;
        }
    }
}