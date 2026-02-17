package com.agenda.view;

import com.agenda.model.ContactList;

import java.util.Scanner;

public class Menu {
    private static void showMenu() {
        System.out.println("\n>>>CONTACT LIST<<<");
        System.out.println("Select An Option:");
        System.out.println("1. Add Contact.");
        System.out.println("2. Update Name.");
        System.out.println("3. Remove Contact.");
        System.out.println("4. List All Contacts.");
        System.out.println("5. Search Contact.");
        System.out.println("6. Exit.\n");
        System.out.print("Option: ");
    }

    public static void main(String[] args) {
        ContactList lt = new ContactList();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean condition = true;
            int number, choice;
            String name, newName, phone, newPhone, email, newEmail;
            while (condition) {
                showMenu();
                String choiceLine = scanner.nextLine();
                
                try {
                    choice = Integer.parseInt(choiceLine);
                }
                catch (NumberFormatException e) {
                    choice = 0;
                }
                
                switch (choice) {
                    case 1 -> {
                        System.out.print("Name: ");
                        name = scanner.nextLine();
                        System.out.print("Phone: ");
                        phone = scanner.nextLine();
                        System.out.print("E-mail: ");
                        email = scanner.nextLine();
                        System.out.println(lt.addContact(name, phone, email));
                    }
                    case 2 -> {
                        System.out.print("ID: ");
                        number = Integer.parseInt(scanner.nextLine());
                        System.out.print("New Name: ");
                        newName = scanner.nextLine();
                        System.out.print("New Phone: ");
                        newPhone = scanner.nextLine();
                        System.out.print("New Email: ");
                        newEmail = scanner.nextLine();
                        System.out.println(lt.updateContact(number, newName, newPhone, newEmail));
                    }
                    case 3 -> {
                        System.out.print("ID: ");
                        number = Integer.parseInt(scanner.nextLine());
                        System.out.println(lt.removeContact(number));
                    }
                    case 4 -> {
                        System.out.println("\n--- CONTACTS LIST ---");
                        System.out.println(lt.showContacts());
                        System.out.println("---------------------\n");
                    }
                    case 5 -> {
                        System.out.print("ID: ");
                        number = Integer.parseInt(scanner.nextLine());
                        System.out.println("\n--- SEARCH RESULT ---");
                        System.out.println(lt.showSpecificContact(number));
                        System.out.println("---------------------\n");
                    }
                    case 6 -> {
                        condition = false;
                        System.out.println("Exiting application. Goodbye!");
                    }
                    default -> System.out.println("Invalid Number. Please enter an option between 1 and 5.");
                }
            }
        }
    }
}