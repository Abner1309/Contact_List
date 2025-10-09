package com.agenda.controller;

import com.agenda.model.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringJoiner;

public class ContactList {
    private ArrayList<Contact> myList;

    public ContactList() {
        this.myList = new ArrayList<>();
    }

    public String addContact(String name, String phone, String email) {
        Contact cont = new Contact(name, phone, email);
        myList.add(cont);
        return "Contact Added";
    }

    public void editName(String name, String newName) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getName().equals(name)) {
                myList.get(i).setName(newName);
            }
        }
    }

    public void editPhone(String name, String newPhone) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getName().equals(name)) {
                myList.get(i).setPhone(newPhone);
            }
        }
    }

    public void editEmail(String name, String newEmail) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getName().equals(name)) {
                myList.get(i).setEmail(newEmail);
            }
        }
    }


    public String removeContact(String name) {
        String answer = "Contact Not Found";
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getName().equals(name)) {
                myList.remove(i);
                answer = "Contact Removed";
                break;
            }
        }
        return answer;
    }

    public String showContacts() {
        myList.sort(Comparator.comparing(Contact::getName));
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < myList.size(); i++) {
            sj.add(myList.get(i).toString());
        }
        return sj.toString();
    }

    public String showSpecificContact(String name) {
        String answer = "Contact Not Found";
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getName().equals(name)) {
                return myList.get(i).toString();
            }
        }
        return answer;
    }
}
