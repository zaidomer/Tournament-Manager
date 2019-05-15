class BinaryTree<T extends Comparable<T>>{
    private BinaryTreeNode<T> root;
    
    BinaryTree(){
        root = new BinaryTreeNode<T>(null, null);
    }
    
    BinaryTree(BinaryTreeNode<T> root){
        this.root = root;
    }
    
    public void add(BinaryTreeNode<T> nodeToAdd){
        boolean nodePlaced = false;
        if(root.getItem() == null){
            root = nodeToAdd;
            nodePlaced = true;
        }else{
            BinaryTreeNode<T> tempBinaryTreeNode = root;
            BinaryTreeNode<T> parentBinaryTreeNode;
            while(nodePlaced == false){
                parentBinaryTreeNode = tempBinaryTreeNode;
                if((nodeToAdd.getItem()).compareTo(tempBinaryTreeNode.getItem()) >= 0){
                    tempBinaryTreeNode = tempBinaryTreeNode.getRight();
                    if(tempBinaryTreeNode == null){
                        parentBinaryTreeNode.setRight(nodeToAdd);
                        nodePlaced = true;
                    }
                }else{
                    tempBinaryTreeNode = tempBinaryTreeNode.getLeft();
                    if(tempBinaryTreeNode == null){
                        parentBinaryTreeNode.setLeft(nodeToAdd);
                        nodePlaced = true;
                    }
                }
            }
        }
    }
    
    public boolean remove(BinaryTreeNode<T> parent, BinaryTreeNode<T> nodeToRemove){
        if(parent.getLeft() != null && parent.getLeft().getItem().equals(nodeToRemove.getItem())){
            BinaryTreeNode<T> tempNode = parent.getLeft();
            parent.setLeft(null);
            addRemovedNodes(tempNode);            
            return true;
        }else if(parent.getRight() != null && parent.getRight().getItem().equals(nodeToRemove.getItem())){
            BinaryTreeNode<T> tempNode = parent.getRight();
            parent.setRight(null);
            addRemovedNodes(tempNode);
            return true;
        }else if((parent.getRight() != null) && (parent.getLeft() != null)){
            return remove(parent.getRight(), nodeToRemove) || remove(parent.getLeft(), nodeToRemove);
        }else if(parent.getRight() != null){
            return remove(parent.getRight(), nodeToRemove);
        }else if(parent.getLeft() != null){
            return remove(parent.getLeft(), nodeToRemove);
        }else{
            return false;
        }
    }
    
    public boolean addRemovedNodes(BinaryTreeNode<T> tempNode){
        if((tempNode.getRight() != null) && (tempNode.getLeft() != null)){
            add(tempNode.getRight());
            add(tempNode.getLeft());
            return addRemovedNodes(tempNode.getRight()) || addRemovedNodes(tempNode.getLeft());
        }else if(tempNode.getRight() != null){
            add(tempNode.getRight());
            return addRemovedNodes(tempNode.getRight());
        }else if(tempNode.getLeft() != null){
            add(tempNode.getLeft());
            return addRemovedNodes(tempNode.getLeft());
        }else{
            return true;
        }
    }
    
    public boolean containsItem(T item){
        BinaryTreeNode<T> tempBinaryTreeNode = root;
        boolean itemFound = false;
        // while(itemFound == false){
            
        // }
        return true;
    }

    public boolean containsNodeName(String nodeName, BinaryTreeNode<T> root){
        if(root.getBinaryTreeNodeName().equals(nodeName)){
            return true;
        }else if((root.getRight() != null) && (root.getLeft() != null)){
            return containsNodeName(nodeName, root.getRight()) || containsNodeName(nodeName, root.getLeft());
        }else if(root.getRight() != null){
            return containsNodeName(nodeName, root.getRight());
        }else if(root.getLeft() != null){
            return containsNodeName(nodeName, root.getLeft());
        }else{
            return false;
        }
    }
    
    public int size(BinaryTreeNode<T> root){
        if((root.getRight() != null) && (root.getLeft() != null)){
            return 1 + size(root.getRight()) + size(root.getLeft());
        }else if(root.getRight() != null){
            return 1 + size(root.getRight());
        }else if(root.getLeft() != null){
            return 1 + size(root.getLeft());
        }else if(root.getItem() != null){
            return 1;
        }else{
            return 0;
        }
    }
    
    //Getters
    public BinaryTreeNode<T> getRoot(){
        return root;
    }
    
    //Setters
    public void setRoot(BinaryTreeNode<T> root){
        this.root = root;
    }
}