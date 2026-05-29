package com.travel.booking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Payment {

    private Long id;
    private String paymentMethod;
    private double amount;
    private boolean successful;
    private LocalDate paymentDate;
    private LocalDateTime createdAt;

    public Payment() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public boolean isSuccessful() { return successful; }
    public void setSuccessful(boolean successful) { this.successful = successful; }

    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public static class Builder {

        private final Payment payment = new Payment();

        public Builder id(Long id) {
            payment.id = id;
            return this;
        }

        public Builder paymentMethod(String paymentMethod) {
            payment.paymentMethod = paymentMethod;
            return this;
        }

        public Builder amount(double amount) {
            payment.amount = amount;
            return this;
        }

        public Builder successful(boolean successful) {
            payment.successful = successful;
            return this;
        }

        public Builder paymentDate(LocalDate paymentDate) {
            payment.paymentDate = paymentDate;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            payment.createdAt = createdAt;
            return this;
        }

        public Payment build() {
            return payment;
        }
    }
}