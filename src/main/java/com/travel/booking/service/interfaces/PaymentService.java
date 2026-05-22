package com.travel.booking.service.interfaces;

import com.travel.booking.model.Payment;

public interface PaymentService {
    void save(Payment payment);
    Payment findById(Long id);
}