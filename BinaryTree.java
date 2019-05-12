class BinaryTree<T extends Comparable<T>>{
    private BinaryTreeNode<T> root;
    
    BinaryTree(){
        root = new BinaryTreeNode<T>(null, null);
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
    
    public void remove(){
        
    }
    
    public boolean isEmpty(BinaryTreeNode<T> node){
        if(node == null){
            return true;
        }else{
            return false;
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