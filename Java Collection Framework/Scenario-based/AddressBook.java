import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;

public class AddressBook {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static HashMap<String, Contact> nameIndex = new HashMap<>();
    static HashSet<String> phoneNumbers = new HashSet<>();

    static class Contact {
        String name;
        String phone;
        String email;

        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String toString() {
            return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
        }
    }

    static boolean addContact(String name, String phone, String email) {
        if (phoneNumbers.contains(phone)) {
            System.out.println("Cannot add " + name + " - phone number " + phone + " already exists");
            return false;
        }

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        nameIndex.put(name.toLowerCase(), contact);
        phoneNumbers.add(phone);
        System.out.println("Added contact: " + name);
        return true;
    }

    static Contact searchByName(String name) {
        return nameIndex.get(name.toLowerCase());
    }

    static boolean deleteContact(String name) {
        Contact contact = nameIndex.get(name.toLowerCase());
        if (contact == null) {
            System.out.println("Contact " + name + " not found");
            return false;
        }

        contacts.remove(contact);
        nameIndex.remove(name.toLowerCase());
        phoneNumbers.remove(contact.phone);
        System.out.println("Deleted contact: " + name);
        return true;
    }

    static void displaySortedByName() {
        ArrayList<Contact> sortedContacts = new ArrayList<>(contacts);
        Collections.sort(sortedContacts, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c1.name.compareToIgnoreCase(c2.name);
            }
        });

        System.out.println("--- Contacts (sorted by name) ---");
        for (Contact c : sortedContacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        addContact("Rohit Sharma", "9876543210", "rohit.sharma@email.com");
        addContact("Neha Kulkarni", "9123456789", "neha.kulkarni@email.com");
        addContact("Vikram Singh", "9988776655", "vikram.singh@email.com");
        addContact("Anita Desai", "9876543210", "anita.desai@email.com");

        System.out.println();
        displaySortedByName();

        System.out.println();
        Contact found = searchByName("Vikram Singh");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Contact not found");
        }

        System.out.println();
        deleteContact("Neha Kulkarni");

        System.out.println();
        displaySortedByName();
    }
}