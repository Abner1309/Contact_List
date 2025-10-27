package com.agenda.controller;

import java.sql.*;
import java.util.ArrayList;

public class ContactDAO {
    public void insertContact(String name, String phone, String email) throws RuntimeException {
        String sql = "INSERT INTO contacts(name, phone, email) VALUES(?, ?, ?)";
        try (Connection conn = ConnectDB.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String listAllContacts() throws RuntimeException {
        ArrayList<String> cont = new ArrayList<>();
        String sql = "SELECT * FROM contacts";

        try (Connection conn = ConnectDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String c = rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("phone") + " | " +
                        rs.getString("email");
                cont.add(c);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cont.toString();
    }

    public void updateContact(int id, String name, String phone, String email) throws RuntimeException {
        String sql = "UPDATE contacts SET name = ?, phone = ?, email = ? WHERE id = ?";
        try (Connection conn = ConnectDB.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, email);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeContact(int id) throws RuntimeException {
        String sql = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = ConnectDB.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
