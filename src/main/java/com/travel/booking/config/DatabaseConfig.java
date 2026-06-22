package com.travel.booking.config;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static final Properties properties =
            new Properties();

    static {

        try (InputStream input =
                     DatabaseConfig.class
                             .getClassLoader()
                             .getResourceAsStream("sql/config.properties")) {

            properties.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUsername() {
        return properties.getProperty("db.username");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }

    public static String getDriver() {
        return properties.getProperty("db.driver");
    }
}