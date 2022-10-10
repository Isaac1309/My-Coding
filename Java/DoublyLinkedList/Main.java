public class Main {
    public static void main(String[] args) {
        System.out.println("DoublyLinkedList with simple data");
        DoublyLinkedList<String> names = new DoublyLinkedList<>();

                
        names.insert("Juan");
        names.insert("Pedro");
        names.insert("Jose");
        names.insert("Maria");
        
        System.out.println("\nPrint data backward");
        names.traverseBackward();
        System.out.println("\nPrint data forward");
        names.traverseForward();
    }
}
