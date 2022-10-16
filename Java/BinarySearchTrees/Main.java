public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(12);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(8);
        bst.insert(16);
        bst.insert(27);

        System.out.println("Getting the Min");
        System.out.println(bst.getMin());
        System.out.println("\nGetting the Max");
        System.out.println(bst.getMax());
        System.out.println("\nGetting the traversal");
        bst.traversal();
        bst.remove(16);
        bst.traversal();
        bst.remove(20);
        bst.traversal();
        bst.remove(12);
        bst.traversal();

        BinarySearchTree<Person> bstPerson = new BinarySearchTree<>();

        bstPerson.insert(new Person(11, "Juan"));
        bstPerson.insert(new Person(6, "Moises"));
        bstPerson.insert(new Person(60, "Cristian"));
        bstPerson.insert(new Person(78, "Ana"));
        bstPerson.insert(new Person(10, "Guillermo"));
        bstPerson.insert(new Person(4, "Andrea"));
        bstPerson.insert(new Person(50, "Monserrat"));
        
        bstPerson.traversal();
    }
}
