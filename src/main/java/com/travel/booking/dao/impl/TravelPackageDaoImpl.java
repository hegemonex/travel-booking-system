package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.TravelPackageDao;
import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.model.TravelPackage;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TravelPackageDaoImpl implements TravelPackageDao {

    private static final String INSERT = """
            INSERT INTO travel_packages (id, name, description, packagePrice, active, startDate, endDate, createdAt, travel_booking_system_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, name, description, packagePrice, active, startDate, endDate, createdAt, travel_booking_system_id
            FROM travel_packages
            WHERE id = ?
            """;

    private static final String SELECT_ALL = """
            SELECT id, name, description, packagePrice, active, startDate, endDate, createdAt, travel_booking_system_id
            FROM travel_packages
            """;

    private static final String UPDATE = """
            UPDATE travel_packages
            SET name = ?, description = ?, packagePrice = ?, active = ?, startDate = ?, endDate = ?
            WHERE id = ?
            """;

    private static final String DELETE = "DELETE FROM travel_packages WHERE id = ?";

    @Override
    public void create(TravelPackage travelPackage) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setLong(1, travelPackage.getId());
            statement.setString(2, travelPackage.getName());
            statement.setString(3, travelPackage.getDescription());
            statement.setDouble(4, travelPackage.getPackagePrice());
            statement.setBoolean(5, travelPackage.isActive());
            statement.setDate(6, Date.valueOf(travelPackage.getStartDate()));
            statement.setDate(7, Date.valueOf(travelPackage.getEndDate()));
            statement.setTimestamp(8, Timestamp.valueOf(travelPackage.getCreatedAt()));
            statement.setLong(9, travelPackage.getTravelBookingSystem().getId());

            statement.executeUpdate();
            System.out.println("TravelPackage created!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TravelPackage findBy(Long id) {
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
    public List<TravelPackage> findAll() {
        List<TravelPackage> packages = new ArrayList<>();

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                packages.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return packages;
    }

    @Override
    public void update(TravelPackage travelPackage) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1, travelPackage.getName());
            statement.setString(2, travelPackage.getDescription());
            statement.setDouble(3, travelPackage.getPackagePrice());
            statement.setBoolean(4, travelPackage.isActive());
            statement.setDate(5, Date.valueOf(travelPackage.getStartDate()));
            statement.setDate(6, Date.valueOf(travelPackage.getEndDate()));
            statement.setLong(7, travelPackage.getId());

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

    private TravelPackage mapRow(ResultSet rs) throws SQLException {
        TravelPackage tp = new TravelPackage();
        tp.setId(rs.getLong("id"));
        tp.setName(rs.getString("name"));
        tp.setDescription(rs.getString("description"));
        tp.setPackagePrice(rs.getDouble("packagePrice"));
        tp.setActive(rs.getBoolean("active"));
        tp.setStartDate(rs.getDate("startDate").toLocalDate());
        tp.setEndDate(rs.getDate("endDate").toLocalDate());
        tp.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());

        TravelBookingSystem tbs = new TravelBookingSystem();
        tbs.setId(rs.getLong("travel_booking_system_id"));
        tp.setTravelBookingSystem(tbs);

        return tp;
    }
}