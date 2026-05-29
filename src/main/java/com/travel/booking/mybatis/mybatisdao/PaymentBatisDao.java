package com.travel.booking.mybatis.mybatisdao;

import com.travel.booking.dao.interfaces.PaymentDao;
import com.travel.booking.model.Payment;
import com.travel.booking.mybatis.mapper.PaymentMapper;
import com.travel.booking.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PaymentBatisDao implements PaymentDao {

    @Override
    public void create(Payment payment) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            mapper.create(payment);
        }
    }

    @Override
    public Payment findBy(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<Payment> findAll() {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void update(Payment payment) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            mapper.update(payment);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session =
                     MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            mapper.delete(id);
        }
    }
}
