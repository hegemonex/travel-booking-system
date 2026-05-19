package com.travel.booking.util;

import com.travel.booking.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionPool {

    private static final DatabaseConfig databaseConfig = new DatabaseConfig();

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    databaseConfig.getUrl(),
                    databaseConfig.getUsername(),
                    databaseConfig.getPassword()
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}