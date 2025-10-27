package com.agenda.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:sqlite:contacts.db";

    public static Connection connect() throws RuntimeException {
        try {
            return DriverManager.getConnection(URL);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
