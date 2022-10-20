public class ReadBlackTree <T extends Comparable<T>> implements Tree<T>{
    private Node<T> root;

    @Override
    public void insert(T data) {
        if(root==null){
            root=new Node<>(data, null);
            settleViolations(root);
        }else{
            insert(data, root);
        }
    }
    private void insert(T data, Node<T> node){
        if(node.getData().compareTo(data)>0){
            if(node.getLeftChild() != null)
                insert(data, node.getLeftChild());
            else{
                Node<T> newNode=new Node<>(data, node);
                node.setLeftChild(newNode);
                settleViolations(newNode);
            }
        }
        else {
            if(node.getRightChild() != null)
                insert(data, node.getRightChild());
            else{
                Node<T> newNode=new Node<>(data, node);
                node.setRightChild(newNode);
                settleViolations(newNode);
            }
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
    private void settleViolations(Node<T> node){
        Node<T> parentNode = null;
        Node<T> grandParentNode = null;   
        while(node!=root && isRed(node) && isRed(node.getParentNode())){
            parentNode = node.getParentNode();
            grandParentNode = parentNode.getParentNode();    
            if(parentNode==grandParentNode.getLeftChild()){
                Node<T> uncle = grandParentNode.getRightChild();
                if(uncle!=null && isRed(uncle)){
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node=grandParentNode;
                }else{
                    if(node==parentNode.getRightChild()){
                        leftRotation(parentNode);
                        node=parentNode;
                        parentNode=grandParentNode;
                    }
                    rightRotation(grandParentNode);
                    System.out.println("Recoroling "+parentNode+" + "+ grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node=parentNode;
                }
            }else{
                Node<T> uncle = grandParentNode.getLeftChild();
                if(uncle!=null && isRed(uncle)){
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node=grandParentNode;
                }else{
                    if(node==parentNode.getLeftChild()){
                        rightRotation(parentNode);
                        node=parentNode;
                        parentNode=grandParentNode;
                    }
                    leftRotation(grandParentNode);
                    System.out.println("Recoroling "+parentNode+" + "+ grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node=parentNode;
                }
            }
        }
        if(isRed(root)){
            System.out.println("Recoloring the root to black");
            root.setColor(NodeColor.BLACK);
        }
    }

    private boolean isRed(Node<T> node){
        if(node == null) return false;
        return node.getColor()==NodeColor.RED;
    }

    private Node<T> getPredecessor(Node<T> node){
        if(node.getRightChild()!=null)
            return getPredecessor(node.getRightChild());
        return node;
    }

    @Override
    public void traverse() {
        if(root!=null) traverse(root);
    }
    private void traverse(Node<T> node) {
        if(node.getLeftChild()!=null){
            traverse(node.getLeftChild());
        }
        System.out.print(node+" - ");
        if(node.getRightChild()!=null){
            traverse(node.getRightChild());
        }
    }
    
    private void rightRotation(Node<T> node){
        System.out.println("Doing a Right Rotation on node: "+node);
        Node<T> tempLeftChild=node.getLeftChild();
        Node<T> grandChild=tempLeftChild.getRightChild();
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);
        if(grandChild!=null)
            grandChild.setParentNode(node);
        Node<T> tempParent=node.getParentNode();
        node.setParentNode(tempLeftChild);
        tempLeftChild.setParentNode(tempParent);
        if(tempLeftChild.getParentNode()!=null && tempLeftChild.getParentNode().getLeftChild()==node){
            tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
        }
        if(tempLeftChild.getParentNode()!=null && tempLeftChild.getParentNode().getRightChild()==node){
            tempLeftChild.getParentNode().setRightChild(tempLeftChild);
        }
        if(node==root)
        root=tempLeftChild;
    }

    private void leftRotation(Node<T> node){
        System.out.println("Doing a Left Rotation on node: "+node);
        Node<T> tempRightChild=node.getRightChild();
        Node<T> grandChild=tempRightChild.getLeftChild();
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);
        if(grandChild!=null)
            grandChild.setParentNode(node);
        Node<T> tempParent=node.getParentNode();
        node.setParentNode(tempRightChild);
        tempRightChild.setParentNode(tempParent);
        if(tempRightChild.getParentNode()!=null && tempRightChild.getParentNode().getLeftChild()==node){
            tempRightChild.getParentNode().setLeftChild(tempRightChild);
        }
        if(tempRightChild.getParentNode()!=null && tempRightChild.getParentNode().getRightChild()==node){
            tempRightChild.getParentNode().setRightChild(tempRightChild);
        }
        if(node==root)
        root=tempRightChild;
    }

}
