package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.UserDao;
import com.travel.booking.model.User;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String INSERT = """
            INSERT INTO users (id, firstName, lastName, email, phoneNumber, dateOfBirth, createdAt, travel_booking_system_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, firstName, lastName, email, phoneNumber, dateOfBirth, createdAt
            FROM users
            WHERE id = ?
            """;

    private static final String SELECT_ALL = """
            SELECT id, firstName, lastName, email, phoneNumber, dateOfBirth, createdAt
            FROM users
            """;

    private static final String UPDATE = """
            UPDATE users
            SET firstName = ?, lastName = ?, email = ?, phoneNumber = ?
            WHERE id = ?
            """;

    private static final String DELETE = "DELETE FROM users WHERE id = ?";

    @Override
    public void create(User user) {
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setLong(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPhoneNumber());
            statement.setDate(6, Date.valueOf(user.getBirthDate()));
            statement.setTimestamp(7, Timestamp.valueOf(user.getCreatedAt()));
            statement.setLong(8, user.getTravelBookingSystem().getId());

            statement.executeUpdate();
            System.out.println("User created!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findBy(Long id) {
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);   // WHERE id = ?, not user_id

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                users.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void update(User user) {
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhoneNumber());
            statement.setLong(5, user.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User mapRow(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setBirthDate(rs.getDate("dateOfBirth").toLocalDate());
        user.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
        return user;
    }
}