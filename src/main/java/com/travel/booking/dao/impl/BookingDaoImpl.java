package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.BookingDao;
import com.travel.booking.model.*;
import com.travel.booking.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao {
    @Override
    public void create(Booking booking) {
        String sql = """
                INSERT INTO bookings (user_id, trip_id, payments_id)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setLong(1, booking.getId());
            statement.setLong(2, booking.getTrip().getId());
            statement.setLong(3, booking.getPayment().getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Booking findBy(Long id) {
        String sql = """
                SELECT * FROM bookings
                WHERE id = ?
                """;

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setLong(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {

                    Booking b = new Booking();
                    b.setId(rs.getLong("id"));

                    User user = new User();
                    user.setId(rs.getLong("user_id"));
                    b.setUser(user);

                    Trip trip = new Trip();
                    trip.setId(rs.getLong("trip_id"));
                    b.setTrip(trip);

                    Payment payment = new Payment();
                    payment.setId(rs.getLong("payments_id"));
                    b.setPayment(payment);

                    return b;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Booking> findAll() {
        String sql = "SELECT * FROM bookings";

        List<Booking> list = new ArrayList<>();

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
        ) {

            while (rs.next()) {
                Booking b = new Booking();
                b.setId(rs.getLong("id"));

                User user = new User();
                user.setId(rs.getLong("user_id"));
                b.setUser(user);

                Trip trip = new Trip();
                trip.setId(rs.getLong("trip_id"));
                b.setTrip(trip);

                Payment payment = new Payment();
                payment.setId(rs.getLong("payments_id"));
                b.setPayment(payment);

                list.add(b);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void update(Booking booking) {
        String sql = """
            UPDATE bookings
            SET user_id = ?, trip_id = ?, payments_id = ?
            WHERE id = ?
            """;

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setLong(1, booking.getUser().getId());
            statement.setLong(2, booking.getTrip().getId());
            statement.setLong(3, booking.getPayment().getId());
            statement.setLong(4, booking.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = """
            DELETE FROM bookings
            WHERE id = ?
            """;

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Booking> findCompleteBookingInfo() {

        String sql = """
                SELECT 
                    b.id AS booking_id,
                
                    u.id AS user_id,
                    u.firstName,
                    u.lastName,
                    u.email,
                
                    t.id AS trip_id,
                
                    p.id AS payment_id,
                
                    f.id AS flight_id,
                    f.airline,
                
                    tp.id AS package_id,
                    tp.name AS package_name
                
                FROM bookings b
                INNER JOIN users u
                    ON b.user_id = u.id
                INNER JOIN trips t
                    ON b.trip_id = t.id
                INNER JOIN payments p
                    ON b.payments_id = p.id
                INNER JOIN flights f
                    ON t.flight_id = f.id
                INNER JOIN travel_packages tp
                    ON t.travel_package_id = tp.id
                """;

        List<Booking> bookings = new ArrayList<>();

        try (
                Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
        ) {

            while (rs.next()) {

                Booking booking = new Booking();
                booking.setId(rs.getLong("booking_id"));

                User user = new User();
                user.setId(rs.getLong("user_id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));

                Flight flight = new Flight();
                flight.setId(rs.getLong("flight_id"));
                flight.setAirline(rs.getString("airline"));

                TravelPackage travelPackage = new TravelPackage();
                travelPackage.setId(rs.getLong("package_id"));
                travelPackage.setName(rs.getString("package_name"));

                Trip trip = new Trip();
                trip.setId(rs.getLong("trip_id"));
                trip.setFlight(flight);
                trip.setTravelPackage(travelPackage);

                Payment payment = new Payment();
                payment.setId(rs.getLong("payment_id"));

                booking.setUser(user);
                booking.setTrip(trip);
                booking.setPayment(payment);

                bookings.add(booking);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return bookings;
    }
}
