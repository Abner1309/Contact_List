package com.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static String userHome = System.getProperty("user.home");
    private static String dbPath = userHome + "/contacts.db";
    private static String urlFinal = "jdbc:sqlite:" + dbPath;
    private static final String URL = urlFinal;

    public static Connection connect() throws RuntimeException {
        try {
            return DriverManager.getConnection(URL);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
