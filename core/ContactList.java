package core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringJoiner;

public class ContactList {
    private ArrayList<Contact> myList;

    public ContactList() {
        this.myList = new ArrayList<>();
    }

    public String addContact(String name, String lastName, String phone, String email) {
        Contact cont = new Contact(name, lastName, phone, email);
        myList.add(cont);
        myList.sort(Comparator.comparing(Contact::getName));
        return "Contact Added";
    }

    public String removeContact(String name, String lastName) {
        String answer = "Contact Not Found";
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getName().equals(name) &&
            myList.get(i).getLastName().equals(lastName)) {
                myList.remove(i);
                answer = "Contact Removed";
                break;
            }
        }
        return answer;
    }

    public String showContacts() {
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < myList.size(); i++) {
            sj.add(myList.get(i).toString());
        }
        return sj.toString();
    }

    public String showSpecificContact(String name, String lastName) {
        String answer = "Contact Not Found";
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getName().equals(name) &&
            myList.get(i).getLastName().equals(lastName)) {
                return myList.get(i).toString();
            }
        }
        return answer;
    }
}
