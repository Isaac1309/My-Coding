import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static MobilePhone mobilePhone=new MobilePhone("0039 330 4404");

    public static void main(String[] args) {
        boolean quit=false;
        startPhone();
        printActions();
        while (!quit){
            int action=scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Shutting down...");
                    quit=true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    break;
            }
        }
    }

    private static void addNewContact(){
        System.out.println("Insert the name:");
        String name=scanner.nextLine();
        System.out.println("Insert the PhoneNumber:");
        String number=scanner.nextLine();
        Contact contact=Contact.createContact(name,number);
        if(mobilePhone.addNewContact(contact)){
            System.out.println("The new contact added: "+name+" -> "+number);
        }else System.out.println("Can't add"+name+" in the contact's list");
    }
    private static void updateContact(){
        System.out.println("Insert a existing contact name:");
        String name=scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord==null){
            System.out.println("Contact not found");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName=scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String number=scanner.nextLine();
        Contact newContact=Contact.createContact(newName,number);
        if(mobilePhone.updateContact(existingContactRecord,newContact)){
            System.out.println("Successfully updated record");
        }else System.out.println("Error updating record");
    }
    private static void removeContact(){
        System.out.println("Insert a existing contact name:");
        String name=scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord==null){
            System.out.println("Contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted");
        }else System.out.println("Error deleting record");
    }
    private static void queryContact(){
        System.out.println("Insert a existing contact name:");
        String name=scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord==null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: "+existingContactRecord.getName()+" phone number is"+ existingContactRecord.getPhoneNumber());
    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }
    private static void printActions(){
        System.out.println("\nAvailable actions: \npress\n" +
                "0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update a contact\n" +
                "4 - to delete a contact\n" +
                "5 - to query a contact\n" +
                "6 - to print the list of actions\n" +
                "Choose your action: ");
    }
}
