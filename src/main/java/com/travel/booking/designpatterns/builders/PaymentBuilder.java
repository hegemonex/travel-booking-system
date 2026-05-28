package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.Payment;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentBuilder {

    private final Payment payment = new Payment();

    public PaymentBuilder id(Long id) {
        payment.setId(id);
        return this;
    }

    public PaymentBuilder paymentMethod(String paymentMethod) {
        payment.setPaymentMethod(paymentMethod);
        return this;
    }

    public PaymentBuilder amount(double amount) {
        payment.setAmount(amount);
        return this;
    }

    public PaymentBuilder successful(boolean successful) {
        payment.setSuccessful(successful);
        return this;
    }

    public PaymentBuilder paymentDate(LocalDate paymentDate) {
        payment.setPaymentDate(paymentDate);
        return this;
    }

    public PaymentBuilder createdAt(LocalDateTime createdAt) {
        payment.setCreatedAt(createdAt);
        return this;
    }

    public Payment build() {
        return payment;
    }
}
