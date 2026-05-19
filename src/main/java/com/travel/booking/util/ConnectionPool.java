package com.travel.booking.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionPool {
    private static final HikariDataSource dataSource;

    static {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");

        config.setUsername("root");

        config.setPassword("1234");

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() {

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
