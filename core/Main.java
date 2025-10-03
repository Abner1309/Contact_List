package core;

import java.util.Scanner;

public class Main {
    private static void showMenu() {
        System.out.println("\n>>>CONTACT LIST<<<");
        System.out.println("Select An Option:");
        System.out.println("1. Add Contact.");
        System.out.println("2. Remove Contact.");
        System.out.println("3. List All Contacts.");
        System.out.println("4. Search Contact.");
        System.out.println("5. Exit.\n");
        System.out.print("Option: ");
    }

    public static void main(String[] args) {
        ContactList lt = new ContactList();
        Scanner scanner = new Scanner(System.in); 
        boolean condition = true;
        int choice;
        String name, lastName, phone, email;

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
                case 1:
                    System.out.print("Name: ");
                    name = scanner.nextLine(); 
                    System.out.print("Last Name: ");
                    lastName = scanner.nextLine();
                    System.out.print("Phone: ");
                    phone = scanner.nextLine();
                    System.out.print("E-mail: ");
                    email = scanner.nextLine();
                    lt.addContact(name, lastName, phone, email); 
                    break;
                case 2:
                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    System.out.print("Last Name: ");
                    lastName = scanner.nextLine();
                    lt.removeContact(name, lastName);
                    break;
                case 3:
                    System.out.println("\n--- CONTACTS LIST ---");
                    System.out.println(lt.showContacts());
                    System.out.println("---------------------\n");
                    break;
                case 4:
                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    System.out.print("Last Name: ");
                    lastName = scanner.nextLine();
                    System.out.println("\n--- SEARCH RESULT ---");
                    System.out.println(lt.showSpecificContact(name, lastName));
                    System.out.println("---------------------\n");
                    break;
                case 5:
                    condition = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Number. Please enter an option between 1 and 5.");
            }
        }
        scanner.close();
    }
}