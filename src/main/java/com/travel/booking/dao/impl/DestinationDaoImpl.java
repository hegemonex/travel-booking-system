package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.DestinationDao;
import com.travel.booking.model.Destination;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DestinationDaoImpl implements DestinationDao {

    private static final String INSERT = """
            INSERT INTO destinations (id, country, city, description, visaRequired, createdAt)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, country, city, description, visaRequired, createdAt
            FROM destinations
            WHERE id = ?
            """;

    private static final String SELECT_ALL = """
            SELECT id, country, city, description, visaRequired, createdAt
            FROM destinations
            """;

    private static final String UPDATE = """
            UPDATE destinations
            SET country = ?, city = ?, description = ?, visaRequired = ?
            WHERE id = ?
            """;

    private static final String DELETE = "DELETE FROM destinations WHERE id = ?";

    @Override
    public void create(Destination destination) {
        Connection connection = ConnectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setLong(1, destination.getId());
            statement.setString(2, destination.getCountry());
            statement.setString(3, destination.getCity());
            statement.setString(4, destination.getDescription());
            statement.setBoolean(5, destination.isVisaRequired());
            statement.setTimestamp(6, Timestamp.valueOf(destination.getCreatedAt()));

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Destination findBy(Long id) {
        Connection connection = ConnectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
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
    public List<Destination> findAll() {
        List<Destination> destinations = new ArrayList<>();
        Connection connection = ConnectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                destinations.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
        return destinations;
    }

    @Override
    public void update(Destination destination) {
        Connection connection = ConnectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, destination.getCountry());
            statement.setString(2, destination.getCity());
            statement.setString(3, destination.getDescription());
            statement.setBoolean(4, destination.isVisaRequired());
            statement.setLong(5, destination.getId());

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

    private Destination mapRow(ResultSet rs) throws SQLException {
        Destination destination = new Destination();
        destination.setId(rs.getLong("id"));
        destination.setCountry(rs.getString("country"));
        destination.setCity(rs.getString("city"));
        destination.setDescription(rs.getString("description"));
        destination.setVisaRequired(rs.getBoolean("visaRequired"));
        destination.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
        return destination;
    }
}