package com.agenda.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    public static void createRelation() throws RuntimeException {
        String sql = """
                CREATE TABLE IF NOT EXISTS contacts (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                phone TEXT,
                email TEXT
                );
                """;

        try (Connection conn = ConnectDB.connect();
        Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
