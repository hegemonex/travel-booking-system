package com.travel.booking.service.impl;

import com.travel.booking.mybatis.mapper.PaymentMapper;
import com.travel.booking.model.Payment;
import com.travel.booking.service.interfaces.PaymentService;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public void save(Payment payment) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            mapper.create(payment);
        }
    }

    @Override
    public Payment findById(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            return mapper.findById(id);
        }
    }
}