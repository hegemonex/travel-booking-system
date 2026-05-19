package com.travel.booking.util;

import com.travel.booking.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class ConnectionPool {

    private static final DatabaseConfig databaseConfig = new DatabaseConfig();

    private static final int POOL_SIZE = 10;

    private static final BlockingQueue<Connection> pool =
            new LinkedBlockingQueue<>(POOL_SIZE);

    static {
        try {
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(
                        databaseConfig.getUrl(),
                        databaseConfig.getUsername(),
                        databaseConfig.getPassword()
                );
                pool.offer(connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing connection pool", e);
        }
    }

    public static Connection getConnection() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }
}