class BinaryTree<T extends Comparable<T>>{
    private Node<T> root;
    
    BinaryTree(){
        root = new Node<T>(null, null);
    }
    
    public void add(Node<T> nodeToAdd){
        boolean nodePlaced = false;
        
        if(root.getItem() == null){
            root = nodeToAdd;
            nodePlaced = true;
        }else{
            Node<T> tempNode = root;
            Node<T> parentNode;
            while(nodePlaced == false){
                parentNode = tempNode;
                if((nodeToAdd.getItem()).compareTo(tempNode.getItem()) >= 0){
                    tempNode = tempNode.getRight();
                    if(tempNode == null){
                        parentNode.setRight(nodeToAdd);
                        nodePlaced = true;
                    }
                }else{
                    tempNode = tempNode.getLeft();
                    if(tempNode == null){
                        parentNode.setLeft(nodeToAdd);
                        nodePlaced = true;
                    }
                }
            }
        }
    }
    
    public void remove(){
        
    }
    
    public boolean isEmpty(Node<T> node){
        if(node == null){
            return true;
        }else{
            return false;
        }
    }
    
    public void contains(T item){
        Node<T> tempNode = root;
        boolean itemFound = false;
        while(itemFound == false){
            
        }
        
    }
    
    public int size(Node<T> root){
        if((root.getRight() != null) && (root.getLeft() != null)){
            return 2 + size(root.getRight()) + size(root.getLeft());
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
    public Node<T> getRoot(){
        return root;
    }
    
    //Setters
    public void setRoot(Node<T> root){
        this.root = root;
    }
}