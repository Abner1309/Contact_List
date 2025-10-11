package com.agenda.controller;

import com.agenda.model.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringJoiner;

public class ContactList {
    private final ArrayList<Contact> myList;

    public ContactList() {
        this.myList = new ArrayList<>();
    }

    public String addContact(String name, String phone, String email) {
        Contact cont = new Contact(name, phone, email);
        myList.add(cont);
        return "Contact Added";
    }

    public String updateContact(int number, String newName, String newPhone, String newEmail) {
        for (Contact contact : myList) {
            if (contact.getId() == number) {
                contact.setName(newName);
                contact.setPhone(newPhone);
                contact.setEmail(newEmail);
                return "Updated Contact";
            }
        }
        return "Contact Not Found";
    }

    public String removeContact(int number) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getId() == number) {
                myList.remove(i);
                return "Contact Removed";
            }
        }
        return "Contact Not Found";
    }

    public String showContacts() {
        myList.sort(Comparator.comparing(Contact::getName));
        StringJoiner sj = new StringJoiner("\n");
        for (Contact contact : myList) {
            sj.add(contact.toString());
        }
        return sj.toString();
    }

    public String showSpecificContact(int number) {
        for (Contact contact : myList) {
            if (contact.getId() == number) {
                return contact.toString();
            }
        }
        return "Contact Not Found";
    }
}
