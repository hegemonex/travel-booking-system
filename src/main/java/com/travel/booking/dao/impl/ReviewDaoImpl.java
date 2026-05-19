package com.travel.booking.dao.impl;

import com.travel.booking.dao.interfaces.ReviewDao;
import com.travel.booking.model.Review;
import com.travel.booking.model.Trip;
import com.travel.booking.model.User;
import com.travel.booking.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDaoImpl implements ReviewDao {

    private static final String INSERT = """
            INSERT INTO reviews (id, rating, comment, recommended, reviewDate, createdAt, user_id, trip_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, rating, comment, recommended, reviewDate, createdAt, user_id, trip_id
            FROM reviews
            WHERE id = ?
            """;

    private static final String SELECT_ALL = """
            SELECT id, rating, comment, recommended, reviewDate, createdAt, user_id, trip_id
            FROM reviews
            """;

    private static final String UPDATE = """
            UPDATE reviews
            SET rating = ?, comment = ?, recommended = ?, reviewDate = ?
            WHERE id = ?
            """;

    private static final String DELETE = "DELETE FROM reviews WHERE id = ?";

    @Override
    public void create(Review review) {
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setLong(1, review.getId());
            statement.setInt(2, review.getRating());
            statement.setString(3, review.getComment());
            statement.setBoolean(4, review.isRecommended());
            statement.setTimestamp(5, Timestamp.valueOf(review.getReviewDate().atStartOfDay()));
            statement.setTimestamp(6, Timestamp.valueOf(review.getCreatedAt()));
            statement.setLong(7, review.getUser().getId());
            statement.setLong(8, review.getTrip().getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Review findBy(Long id) {
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
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
    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                reviews.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }

    @Override
    public void update(Review review) {
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, review.getRating());
            statement.setString(2, review.getComment());
            statement.setBoolean(3, review.isRecommended());
            statement.setTimestamp(4, Timestamp.valueOf(review.getReviewDate().atStartOfDay()));
            statement.setLong(5, review.getId());

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

    private Review mapRow(ResultSet rs) throws SQLException {
        Review review = new Review();
        review.setId(rs.getLong("id"));
        review.setRating(rs.getInt("rating"));
        review.setComment(rs.getString("comment"));
        review.setRecommended(rs.getBoolean("recommended"));
        review.setReviewDate(rs.getTimestamp("reviewDate").toLocalDateTime().toLocalDate());
        review.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());

        User user = new User();
        user.setId(rs.getLong("user_id"));
        review.setUser(user);

        Trip trip = new Trip();
        trip.setId(rs.getLong("trip_id"));
        review.setTrip(trip);

        return review;
    }
}