public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(11);
        bst.insert(5);
        bst.insert(16);
        bst.insert(13);
        bst.insert(-1);
        bst.insert(18);

        System.out.println("Getting the Min");
        System.out.println(bst.getMin());
        System.out.println("\nGetting the Max");
        System.out.println(bst.getMax());
        System.out.println("\nGetting the traversal");
        bst.traversal();
    }
}
