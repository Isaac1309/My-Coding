import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName())>=0) return false;
        return myContacts.add(contact);
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        int exists = findContact(newContact);
        if (position>=0&&exists<0) {
            myContacts.set(position, newContact);
            return true;
        }
        return false;
    }
    public boolean removeContact(Contact contact){
        int position = findContact(contact);
        if (position>=0) {
            myContacts.remove(position);
            return true;
        }
        else return false;
    }
    private int findContact(Contact contactToFind){
        return myContacts.indexOf(contactToFind);
    }
    private int findContact(String nameContactToFind){
        for (int i=0; i<myContacts.size();i++){
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(nameContactToFind)) return i;
        }
        return -1;
    }
    public Contact queryContact(String searchContact){
        int position = findContact(searchContact);
        if (position>=0) {
            return myContacts.get(position);
        }
        return null;
    }
    public void printContacts(){
        System.out.println("Contact List:");
        for (int i=0;i<myContacts.size();i++){
            System.out.println((i+1)+". "+myContacts.get(i).getName()+" -> "+myContacts.get(i).getPhoneNumber());
        }
    }
}
