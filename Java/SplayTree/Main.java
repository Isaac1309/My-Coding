public class Main {
    public static void main(String[] args){
        //You can uncomment the use of the "splay" method in the "SplayTree" file located in the "insert" method to see how it works
        System.out.println("No use of splay when you insert");
        Tree<Integer> splayTree = new SplayTree<>();

        splayTree.insert(32);
        splayTree.insert(10);
        splayTree.insert(55);
        splayTree.insert(1);
        splayTree.insert(19);
        splayTree.insert(41);
        splayTree.insert(16);
        splayTree.insert(12);

        splayTree.find(12);
        System.out.println(splayTree.getRoot());
    }
}
