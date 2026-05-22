package com.travel.booking.dao.mybatis;

import com.travel.booking.model.Payment;

public interface PaymentMapper {
    void create(Payment payment);
    Payment findById(Long id);
}