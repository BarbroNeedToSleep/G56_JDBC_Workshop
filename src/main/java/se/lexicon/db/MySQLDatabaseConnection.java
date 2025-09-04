package se.lexicon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabaseConnection {

    private static String URL = "jdbc:mysql://localhost:3306/world";
    private static String USER = "root";
    private static String PASSWORD = "12345PipMurre";

    // Private constructor to prevent instantiation
    private MySQLDatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER, PASSWORD);
    }
}