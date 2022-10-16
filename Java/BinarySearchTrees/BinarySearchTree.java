public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public void insert(T data) {
        if(root==null){
            root=new Node<>(data, null);
        }else{
            insert(data, root);
        }
    }
    private void insert(T data, Node<T> node){
        if(node.getData().compareTo(data)>0){
            if(node.getLeftChild() != null)
                insert(data, node.getLeftChild());

            else
                node.setLeftChild(new Node<>(data, node));
        }
        else {
            if(node.getRightChild() != null)
                insert(data, node.getRightChild());

            else
                node.setRightChild(new Node<>(data, node));
        }
    }

    @Override
    public void remove(T data) {
        if(root!=null) remove(data, root);
    }
    private void remove(T data, Node<T> node) {
        if(node==null) return;
        if(node.getData().compareTo(data)>0){
            remove(data, node.getLeftChild());
        }else if(node.getData().compareTo(data)<0){
            remove(data, node.getRightChild());
        }else{
            if(node.getLeftChild()==null && node.getRightChild()==null){
                System.out.println("\nRemoving a leaf node");
                Node<T> parent = node.getParentNode();
                if(parent!=null && parent.getLeftChild()==node){
                    parent.setLeftChild(null);
                }else if(parent!=null && parent.getRightChild()==node){
                    parent.setRightChild(null);
                }
                if(parent==null) root=null;
                node=null;
            }
            else if(node.getLeftChild()==null && node.getRightChild()!=null){
                System.out.println("\nRemoving a node with only a right child");
                Node<T> parent = node.getParentNode();
                if(parent!=null && parent.getLeftChild()==node){
                    parent.setLeftChild(node.getRightChild());
                }else if(parent!=null && parent.getRightChild()==node){
                    parent.setRightChild(node.getRightChild());
                }
                if(parent==null) {
                    root=node.getRightChild();
                }
                node.getRightChild().setParentNode(parent);
                node=null;
            }
            else if(node.getLeftChild()!=null && node.getRightChild()==null){
                System.out.println("\nRemoving a node with only a left child");
                Node<T> parent = node.getParentNode();
                if(parent!=null && parent.getLeftChild()==node){
                    parent.setLeftChild(node.getLeftChild());
                }else if(parent!=null && parent.getRightChild()==node){
                    parent.setRightChild(node.getLeftChild());
                }
                if(parent==null) {
                    root=node.getLeftChild();
                }
                node.getLeftChild().setParentNode(parent);
                node=null;
            }
            else{
                System.out.println("\n\nRemoving a node with 2 children");
                Node<T> predecessor = getPredecessor(node.getLeftChild());
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);
                remove(data, predecessor);
            }
        }
    }
    private Node<T> getPredecessor(Node<T> node){
        if(node.getRightChild()!=null)
            return getPredecessor(node.getRightChild());
        return node;
    }

    @Override
    public void traversal() {
        if(root==null) return;
        traversal(root);
    }
    private void traversal(Node<T> node) {
        if(node.getLeftChild()!=null){
            traversal(node.getLeftChild());
        }
        System.out.print(node+" - ");
        if(node.getRightChild()!=null){
            traversal(node.getRightChild());
        }
    }

    @Override
    public T getMax() {
        if(root==null) return null;
        return getMax(root);
    }
    private T getMax(Node<T> node){
        if(node.getRightChild()!=null){
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if(root==null) return null;
        return getMin(root);
    }
    private T getMin(Node<T> node){
        if(node.getLeftChild()!=null){
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }
}
