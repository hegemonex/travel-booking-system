package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.TransportDao;
import com.travel.booking.model.Transport;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportDaoImpl implements TransportDao {

    private static final String INSERT = """
            INSERT INTO transports (id, type, capacity, available, transportPrice, createdAt)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, type, capacity, available, transportPrice, createdAt
            FROM transports
            WHERE id = ?
            """;

    private static final String SELECT_ALL = """
            SELECT id, type, capacity, available, transportPrice, createdAt
            FROM transports
            """;

    private static final String UPDATE = """
            UPDATE transports
            SET type = ?, capacity = ?, available = ?, transportPrice = ?
            WHERE id = ?
            """;

    private static final String DELETE = "DELETE FROM transports WHERE id = ?";

    @Override
    public void create(Transport transport) {
        Connection connection = ConnectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setLong(1, transport.getId());
            statement.setString(2, transport.getType());
            statement.setInt(3, transport.getCapacity());
            statement.setBoolean(4, transport.isAvailable());
            statement.setDouble(5, transport.getTransportPrice());
            statement.setTimestamp(6, Timestamp.valueOf(transport.getCreatedAt()));

            statement.executeUpdate();
            System.out.println("Transport created!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Transport findBy(Long id) {
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
    public List<Transport> findAll() {
        List<Transport> transports = new ArrayList<>();
        Connection connection = ConnectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                transports.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
        return transports;
    }

    @Override
    public void update(Transport transport) {
        Connection connection = ConnectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, transport.getType());
            statement.setInt(2, transport.getCapacity());
            statement.setBoolean(3, transport.isAvailable());
            statement.setDouble(4, transport.getTransportPrice());
            statement.setLong(5, transport.getId());

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

    private Transport mapRow(ResultSet rs) throws SQLException {
        Transport transport = new Transport();
        transport.setId(rs.getLong("id"));
        transport.setType(rs.getString("type"));
        transport.setCapacity(rs.getInt("capacity"));
        transport.setAvailable(rs.getBoolean("available"));
        transport.setTransportPrice(rs.getDouble("transportPrice"));
        transport.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
        return transport;
    }
}