import java.util.Hashtable;
import java.util.Scanner;

public class StudentContactManager {
    public static void main(String[] args) {
        // Initialize the hash table to store student contacts
        Hashtable<String, String[]> contacts = new Hashtable<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("\n--- Student Contact Manager ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. List All Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Safely parse input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1: // Add contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    contacts.put(name, new String[]{email, phone});
                    System.out.println("Contact added successfully!");
                    break;

                case 2: // View contact
                    System.out.print("Enter name to view: ");
                    name = scanner.nextLine();
                    if (contacts.containsKey(name)) {
                        String[] details = contacts.get(name);
                        System.out.println("Email: " + details[0]);
                        System.out.println("Phone: " + details[1]);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3: // Delete contact
                    System.out.print("Enter name to delete: ");
                    name = scanner.nextLine();
                    if (contacts.remove(name) != null) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4: // List all contacts
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts to display.");
                    } else {
                        System.out.println("\n--- All Contacts ---");
                        for (String key : contacts.keySet()) {
                            String[] value = contacts.get(key);
                            System.out.println("Name: " + key);
                            System.out.println("Email: " + value[0]);
                            System.out.println("Phone: " + value[1]);
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 5: // Exit program
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default: // Invalid option
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        }
    }
}
