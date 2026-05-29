package com.travel.booking.dao.interfaces;

import com.travel.booking.model.Payment;

import java.util.List;

public interface PaymentDao {

    void create(Payment payment);

    Payment findBy(Long id);

    List<Payment> findAll();

    void update(Payment payment);

    void delete(Long id);
}
