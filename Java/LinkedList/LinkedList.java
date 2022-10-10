public class LinkedList<T extends Comparable<T>> implements List<T>{

    private Node<T> root;
    private int numberOfItems;

    @Override
    public void insert(T data) {
        if(this.root==null){
            root=new Node<>(data);
        }else{
            insertBeginning(data);
            //insertEnding(data, root);
        }
    }
    private void insertBeginning(T data){
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root=newNode;
    }
    private void insertEnding(T data, Node<T> node){
        if(node.getNextNode()!=null){
            insertEnding(data, node.getNextNode());
        }else{
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {
        if(root==null)return;
        if(root.getData().compareTo(data)==0){
            root = root.getNextNode();
        }else{
            remove(data, root, root.getNextNode());
        }
    }
    private void remove(T data, Node<T> previosNode,Node<T> actualNode) {
        while(actualNode!=null){
            if(actualNode.getData().compareTo(data)==0){
                numberOfItems--;
                previosNode.setNextNode(actualNode.getNextNode());
                actualNode=null;
                return;
            }
            previosNode=actualNode;
            actualNode=actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {
        if(root==null)return;
        Node<T> actualNode = root;
        while(actualNode!=null){
            System.out.println(actualNode);
            actualNode=actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return this.numberOfItems;
    }
    
}
