package com.example.webproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCHelper {
    final static String HOST1="10.100.164.35";
    final static String HOST2="119.3.158.9";
    private static final String URL = "jdbc:mysql://"+HOST1+":3306/web_restaurant";
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    private static final Logger LOGGER = Logger.getLogger(JDBCHelper.class.getName());
;
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to create connection", e);
        }
        return connection;
    }
}