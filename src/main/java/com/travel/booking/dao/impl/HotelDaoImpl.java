package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.HotelDao;
import com.travel.booking.model.Hotel;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDaoImpl implements HotelDao {

    @Override
    public void create(Hotel hotel) {

        String sql = """
                INSERT INTO hotels (
                    name,
                    city,
                    address,
                    starRating,
                    breakfastIncluded,
                    pricePerNight,
                    createdAt,
                    trips_id
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        Connection connection = ConnectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, hotel.getName());
            statement.setString(2, hotel.getCity());
            statement.setString(3, hotel.getAddress());
            statement.setInt(4, hotel.getStarRating());
            statement.setBoolean(5, hotel.isBreakfastIncluded());
            statement.setDouble(6, hotel.getPricePerNight());
            statement.setTimestamp(7, Timestamp.valueOf(hotel.getCreatedAt()));
            statement.setLong(8, hotel.getTrip().getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Hotel findBy(Long id) {

        String sql = """
                SELECT * FROM hotels
                WHERE id = ?
                """;


        Connection connection = ConnectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setLong(1, id);

            try (ResultSet rs = statement.executeQuery()) {

                if (rs.next()) {

                    Hotel hotel = new Hotel();

                    hotel.setId(rs.getLong("id"));
                    hotel.setName(rs.getString("name"));
                    hotel.setCity(rs.getString("city"));
                    hotel.setAddress(rs.getString("address"));
                    hotel.setStarRating(rs.getInt("star_rating"));
                    hotel.setBreakfastIncluded(rs.getBoolean("breakfast_included"));
                    hotel.setPricePerNight(rs.getDouble("price_per_night"));
                    hotel.setCreatedAt(
                            rs.getTimestamp("created_at").toLocalDateTime()
                    );

                    return hotel;
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
    public List<Hotel> findAll() {

        String sql = "SELECT * FROM hotels";

        List<Hotel> hotels = new ArrayList<>();

        Connection connection = ConnectionPool.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
        ) {

            while (rs.next()) {

                Hotel hotel = new Hotel();

                hotel.setId(rs.getLong("id"));
                hotel.setName(rs.getString("name"));
                hotel.setCity(rs.getString("city"));
                hotel.setAddress(rs.getString("address"));
                hotel.setStarRating(rs.getInt("star_rating"));
                hotel.setBreakfastIncluded(rs.getBoolean("breakfast_included"));
                hotel.setPricePerNight(rs.getDouble("price_per_night"));
                hotel.setCreatedAt(
                        rs.getTimestamp("created_at").toLocalDateTime()
                );

                hotels.add(hotel);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }

        return hotels;
    }

    @Override
    public void update(Hotel hotel) {

        String sql = """
                UPDATE hotels
                SET
                    name = ?,
                    city = ?,
                    address = ?,
                    star_rating = ?,
                    breakfast_included = ?,
                    price_per_night = ?
                WHERE id = ?
                """;


        Connection connection = ConnectionPool.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, hotel.getName());
            statement.setString(2, hotel.getCity());
            statement.setString(3, hotel.getAddress());
            statement.setInt(4, hotel.getStarRating());
            statement.setBoolean(5, hotel.isBreakfastIncluded());
            statement.setDouble(6, hotel.getPricePerNight());
            statement.setLong(7, hotel.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {

        String sql = """
                DELETE FROM hotels
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
}