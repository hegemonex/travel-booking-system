package com.travel.booking.mybatis.mapper;

import com.travel.booking.model.Payment;

import java.util.List;

public interface PaymentMapper {

    void create(Payment payment);

    Payment findById(Long id);

    List<Payment> findAll();

    void update(Payment payment);

    void delete(Long id);
}