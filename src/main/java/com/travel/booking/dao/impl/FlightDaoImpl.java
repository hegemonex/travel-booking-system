package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.FlightDao;
import com.travel.booking.model.Flight;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDaoImpl implements FlightDao {

    private static final String INSERT = """
            INSERT INTO flights (id, airline, departureAirport, arrivalAirport, departureDate, arrivalDate,
                                 directFlight, ticketPrice, createdAt)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, airline, departureAirport, arrivalAirport, departureDate, arrivalDate,
                   directFlight, ticketPrice, createdAt
            FROM flights
            WHERE id = ?
            """;

    private static final String SELECT_ALL = """
            SELECT id, airline, departureAirport, arrivalAirport, departureDate, arrivalDate,
                   directFlight, ticketPrice, createdAt
            FROM flights
            """;

    private static final String UPDATE = """
            UPDATE flights
            SET airline = ?, departureAirport = ?, arrivalAirport = ?, departureDate = ?, arrivalDate = ?,
                directFlight = ?, ticketPrice = ?
            WHERE id = ?
            """;

    private static final String DELETE = "DELETE FROM flights WHERE id = ?";

    @Override
    public void create(Flight flight) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setLong(1, flight.getId());
            statement.setString(2, flight.getAirline());
            statement.setString(3, flight.getDepartureAirport());
            statement.setString(4, flight.getArrivalAirport());
            statement.setDate(5, Date.valueOf(flight.getDepartureDate()));
            statement.setDate(6, Date.valueOf(flight.getArrivalDate()));
            statement.setBoolean(7, flight.isDirectFlight());
            statement.setDouble(8, flight.getTicketPrice());
            statement.setTimestamp(9, Timestamp.valueOf(flight.getCreatedAt()));

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Flight findBy(Long id) {
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
    public List<Flight> findAll() {
        List<Flight> flights = new ArrayList<>();

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                flights.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flights;
    }

    @Override
    public void update(Flight flight) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1, flight.getAirline());
            statement.setString(2, flight.getDepartureAirport());
            statement.setString(3, flight.getArrivalAirport());
            statement.setDate(4, Date.valueOf(flight.getDepartureDate()));
            statement.setDate(5, Date.valueOf(flight.getArrivalDate()));
            statement.setBoolean(6, flight.isDirectFlight());
            statement.setDouble(7, flight.getTicketPrice());
            statement.setLong(8, flight.getId());

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

    private Flight mapRow(ResultSet rs) throws SQLException {
        Flight flight = new Flight();
        flight.setId(rs.getLong("id"));
        flight.setAirline(rs.getString("airline"));
        flight.setDepartureAirport(rs.getString("departureAirport"));
        flight.setArrivalAirport(rs.getString("arrivalAirport"));
        flight.setDepartureDate(rs.getDate("departureDate").toLocalDate());
        flight.setArrivalDate(rs.getDate("arrivalDate").toLocalDate());
        flight.setDirectFlight(rs.getBoolean("directFlight"));
        flight.setTicketPrice(rs.getDouble("ticketPrice"));
        flight.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
        return flight;
    }
}