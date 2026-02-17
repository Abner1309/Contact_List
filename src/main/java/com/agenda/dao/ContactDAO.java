package com.agenda.dao;

import com.agenda.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Contact> listAllContacts() throws RuntimeException {
        List<Contact> cont = new ArrayList<Contact>();
        String sql = "SELECT * FROM contacts ORDER BY name ASC";

        try (Connection conn = ConnectDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                Contact contact = new Contact(id, name, phone, email);

                cont.add(contact);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return cont;
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
