public class Main {
    public static void main(String[] args) {
        System.out.println("LinkedList with simple data");
        LinkedList<String> names = new LinkedList<>();
        
        names.insert("Juan");
        names.insert("Pedro");
        names.insert("Jose");
        
        names.traverse();
        System.out.println("\nRemoving simple data");
        names.remove("Pedro");
        names.traverse();

        System.out.println("\nLinkedList with Objects");
        LinkedList<Person> people = new LinkedList<>();

        Person p = new Person(23, "Juan");
        people.insert(p);
        people.insert(new Person(32, "Pedro"));
        people.insert(new Person(42, "Jose"));

        people.traverse();
        System.out.println("\nRemoving an object");
        people.remove(p);
        people.traverse();
    }
}
