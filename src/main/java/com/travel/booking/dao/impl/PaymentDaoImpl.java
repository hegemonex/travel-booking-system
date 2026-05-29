package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.PaymentDao;
import com.travel.booking.model.Payment;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

    private static final String INSERT = """
            INSERT INTO payments (paymentMethod, amount, successful, paymentDate, createdAt)
            VALUES (?, ?, ?, ?, ?)
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, paymentMethod, amount, successful, paymentDate, createdAt
            FROM payments
            WHERE id = ?
            """;

    private static final String SELECT_ALL = """
            SELECT id, paymentMethod, amount, successful, paymentDate, createdAt
            FROM payments
            """;

    private static final String UPDATE = """
            UPDATE payments
            SET paymentMethod = ?, amount = ?, successful = ?, paymentDate = ?
            WHERE id = ?
            """;

    private static final String DELETE = "DELETE FROM payments WHERE id = ?";

    @Override
    public void create(Payment payment) {
        Connection connection = ConnectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, payment.getPaymentMethod());
            statement.setDouble(2, payment.getAmount());
            statement.setBoolean(3, payment.isSuccessful());
            statement.setDate(4, Date.valueOf(payment.getPaymentDate()));
            statement.setTimestamp(5, Timestamp.valueOf(payment.getCreatedAt()));

            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    payment.setId(keys.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Payment findBy(Long id) {
        Connection connection = ConnectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {

            statement.setLong(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public List<Payment> findAll() {
        List<Payment> payments = new ArrayList<>();
        Connection connection = ConnectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                payments.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
        return payments;
    }

    @Override
    public void update(Payment payment) {
        Connection connection = ConnectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setString(1, payment.getPaymentMethod());
            statement.setDouble(2, payment.getAmount());
            statement.setBoolean(3, payment.isSuccessful());
            statement.setDate(4, Date.valueOf(payment.getPaymentDate()));
            statement.setLong(5, payment.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = ConnectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {

            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    private Payment mapRow(ResultSet rs) throws SQLException {
        Payment payment = new Payment();
        payment.setId(rs.getLong("id"));
        payment.setPaymentMethod(rs.getString("paymentMethod"));
        payment.setAmount(rs.getDouble("amount"));
        payment.setSuccessful(rs.getBoolean("successful"));
        payment.setPaymentDate(rs.getDate("paymentDate").toLocalDate());
        payment.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
        return payment;
    }
}