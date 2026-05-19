package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.TripDao;
import com.travel.booking.model.*;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TripDaoImpl implements TripDao {

    private static final String INSERT = """
            INSERT INTO trips (id, title, description, price, availabe, departureDate, returnDate, createdAt,
                               flight_id, transport_id, travel_package_id, travel_booking_system_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, title, description, price, availabe, departureDate, returnDate, createdAt,
                   flight_id, transport_id, travel_package_id, travel_booking_system_id
            FROM trips
            WHERE id = ?
            """;

    private static final String SELECT_ALL = """
            SELECT id, title, description, price, availabe, departureDate, returnDate, createdAt,
                   flight_id, transport_id, travel_package_id, travel_booking_system_id
            FROM trips
            """;

    private static final String UPDATE = """
            UPDATE trips
            SET title = ?, description = ?, price = ?, availabe = ?, departureDate = ?, returnDate = ?,
                flight_id = ?, transport_id = ?, travel_package_id = ?, travel_booking_system_id = ?
            WHERE id = ?
            """;

    private static final String DELETE = "DELETE FROM trips WHERE id = ?";

    @Override
    public void create(Trip trip) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setLong(1, trip.getId());
            statement.setString(2, trip.getTitle());
            statement.setString(3, trip.getDescription());
            statement.setDouble(4, trip.getPrice());
            statement.setBoolean(5, trip.isAvailabe());
            statement.setTimestamp(6, Timestamp.valueOf(trip.getDepartureDate().atStartOfDay()));
            statement.setTimestamp(7, Timestamp.valueOf(trip.getReturnDate().atStartOfDay()));
            statement.setTimestamp(8, Timestamp.valueOf(trip.getCreatedAt()));
            statement.setLong(9, trip.getFlight().getId());
            statement.setLong(10, trip.getTransport().getId());
            statement.setLong(11, trip.getTravelPackage().getId());
            statement.setLong(12, trip.getTravelBookingSystem().getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Trip findBy(Long id) {
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
    public List<Trip> findAll() {
        List<Trip> trips = new ArrayList<>();

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                trips.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trips;
    }

    @Override
    public void update(Trip trip) {
        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1, trip.getTitle());
            statement.setString(2, trip.getDescription());
            statement.setDouble(3, trip.getPrice());
            statement.setBoolean(4, trip.isAvailabe());
            statement.setTimestamp(5, Timestamp.valueOf(trip.getDepartureDate().atStartOfDay()));
            statement.setTimestamp(6, Timestamp.valueOf(trip.getReturnDate().atStartOfDay()));
            statement.setLong(7, trip.getFlight().getId());
            statement.setLong(8, trip.getTransport().getId());
            statement.setLong(9, trip.getTravelPackage().getId());
            statement.setLong(10, trip.getTravelBookingSystem().getId());
            statement.setLong(11, trip.getId());

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

    private Trip mapRow(ResultSet rs) throws SQLException {
        Trip trip = new Trip();
        trip.setId(rs.getLong("id"));
        trip.setTitle(rs.getString("title"));
        trip.setDescription(rs.getString("description"));
        trip.setPrice(rs.getDouble("price"));
        trip.setAvailabe(rs.getBoolean("availabe"));
        trip.setDepartureDate(rs.getDate("departureDate").toLocalDate());
        trip.setReturnDate(rs.getDate("returnDate").toLocalDate());

        Flight flight = new Flight();
        flight.setId(rs.getLong("flight_id"));
        trip.setFlight(flight);

        Transport transport = new Transport();
        transport.setId(rs.getLong("transport_id"));
        trip.setTransport(transport);

        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setId(rs.getLong("travel_package_id"));
        trip.setTravelPackage(travelPackage);

        TravelBookingSystem tbs = new TravelBookingSystem();
        tbs.setId(rs.getLong("travel_booking_system_id"));
        trip.setTravelBookingSystem(tbs);

        return trip;
    }
}