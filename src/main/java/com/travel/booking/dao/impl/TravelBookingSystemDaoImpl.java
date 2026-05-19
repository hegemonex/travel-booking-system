package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.TravelBookingSystemDao;
import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TravelBookingSystemDaoImpl implements TravelBookingSystemDao {

    private static final String INSERT = """
            INSERT INTO travel_booking_system (id, system_name, created_at)
            VALUES (?, ?, ?)
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, system_name, created_at
            FROM travel_booking_system
            WHERE id = ?
            """;

    private static final String SELECT_ALL = """
            SELECT id, system_name, created_at
            FROM travel_booking_system
            """;

    private static final String UPDATE = """
            UPDATE travel_booking_system
            SET system_name = ?
            WHERE id = ?
            """;

    private static final String DELETE = "DELETE FROM travel_booking_system WHERE id = ?";

    @Override
    public void create(TravelBookingSystem tbs) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setLong(1, tbs.getId());
            statement.setString(2, tbs.getSystemName());
            statement.setDate(3, Date.valueOf(tbs.getCreatedAt().toLocalDate()));

            statement.executeUpdate();
            System.out.println("TravelBookingSystem created!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TravelBookingSystem findBy(Long id) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)
        ) {
            statement.setLong(1, id);

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
    public List<TravelBookingSystem> findAll() {
        List<TravelBookingSystem> list = new ArrayList<>();

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void update(TravelBookingSystem tbs) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1, tbs.getSystemName());
            statement.setLong(2, tbs.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE)
        ) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private TravelBookingSystem mapRow(ResultSet rs) throws SQLException {
        TravelBookingSystem tbs = new TravelBookingSystem();
        tbs.setId(rs.getLong("id"));
        tbs.setSystemName(rs.getString("system_name"));
        tbs.setCreatedAt(rs.getDate("created_at").toLocalDate().atStartOfDay());
        return tbs;
    }
}