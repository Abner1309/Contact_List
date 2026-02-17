package com.agenda.model;

import java.util.StringJoiner;

public class Contact {
    private static int nextId = 0;

    private final int id;
    private String name;
    private String phone;
    private String email;    

    public Contact(String name, String phone, String email) {
        this.id = nextId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        nextId++;
    }

    public Contact(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" | ");
        sj.add(getName());
        sj.add(getPhone());
        sj.add(getEmail());
        return sj.toString();
    }
}
