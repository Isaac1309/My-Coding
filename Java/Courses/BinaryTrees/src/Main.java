public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(14);
        bst.insert(16);
        bst.insert(6);
        bst.insert(-1);
        bst.insert(20);

        System.out.println(bst.getMinValue());
        System.out.println(bst.getMaxValue());
        bst.traversal();

        bst.delete(20);

        System.out.println(bst.getMinValue());
        System.out.println(bst.getMaxValue());
        bst.traversal();
    }
}
