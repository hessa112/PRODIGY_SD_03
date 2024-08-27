import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phonenumber;
    private String emailAddress;

    public Contact(String name, String phonenumber, String emailAddress) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.emailAddress = emailAddress;
    }

    public String getname() {
        return name;
    }
    public String getphonenumber() {
        return phonenumber;
    }
    public String getemailAddress() {
        return emailAddress;
    }

    public void displaycontact() {
        System.out.println("Name:" +name);
        System.out.println("Phone Number: " + phonenumber);
        System.out.println("Email Address: " + emailAddress);
    }

}

public class contactinformation {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
        do { 
            System.out.println("Contact Management System ");
            System.out.println("1. Add new contact");
            System.out.println("2. Delete contact");
            System.out.println("3. Edit contact");
            System.out.println("4. View contact");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());

            switch(choice) {
                case 1: addContact();
                        break;
                case 2: deleteContact();
                        break;
                case 3: editContact();
                        break;
                case 4: viewContact();
                        break;
                case 5: System.out.println("EXIT");
                default: System.out.println("invalid choice");
            }
        } while (choice != 5);
        input.close();
    }
    private static void addContact() {
        System.out.println("enter the name:");
        String name = input.nextLine();
        System.out.println("enter phone number: ");
        String phonenumber = input.nextLine();
        System.out.println("enter email address:");
        String emailAddress = input.nextLine();

        Contact newContact = new Contact(name, phonenumber, emailAddress);
        contacts.add(newContact);
        System.out.println("Contact added");
    }

    private static void deleteContact() {
        if(contacts.isEmpty()) {
            System.out.println("No contacts found");
        } else {
            System.out.println("Enter the index of the contact you wish to delete:");
            int index = Integer.parseInt(input.nextLine());


            if (index >= 0 && index < contacts.size()) {
                System.out.println("deleting");
            contacts.get(index).displaycontact();
            contacts.remove(index);
            System.out.println("Contact deleted");
        } else {
            System.out.println("Invalid index, Please enter a valid index.");
        }
    }
    }

    private static void editContact() {
        if(contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            viewContact();
            System.out.println("Enter the index of the contact you wish to edit:");
            int index = Integer.parseInt(input.nextLine());


            if(index >= 0 && index < contacts.size()) {
                System.out.println("Editing contacts");
                contacts.get(index).displaycontact();

                System.out.println("Enter name: ");
                String newname = input.nextLine();
                System.out.println("Enter phone number:");
                String newphonenumber = input.nextLine();
                System.out.println("Enter email address:");
                String newemailAddress = input.nextLine();

                Contact updatedContact = new Contact(newname, newphonenumber, newemailAddress);
                contacts.set(index, updatedContact);
                System.out.println("Contact updated successfully!");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }

    private static void viewContact() {
        if(contacts.isEmpty()) {
            System.out.println("No contacts found");
        } else {
            System.out.println("contact list:");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". ");
                contacts.get(i).displaycontact();

        }

    }
}
}
