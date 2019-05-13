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
    
    public boolean remove(BinaryTreeNode<T> nodeToRemove){
        BinaryTreeNode<T> tempBinaryTreeNode = root;
        BinaryTreeNode<T> parentBinaryTreeNode = root;
        boolean rightChild = false;

        //Search for node
        while(tempBinaryTreeNode != nodeToRemove){
            parentBinaryTreeNode = tempBinaryTreeNode;

            //Node not in tree
            if(root == null){
                return false;
            }

            if((nodeToRemove.getItem()).compareTo(tempBinaryTreeNode.getItem()) < 0){
                tempBinaryTreeNode = tempBinaryTreeNode.getLeft();
                rightChild = false;
            }else{
                tempBinaryTreeNode = tempBinaryTreeNode.getRight();
                rightChild = true;
            }
        }

        //Leaf
        if(tempBinaryTreeNode.getLeft() == null && tempBinaryTreeNode.getRight() == null){
            if(tempBinaryTreeNode == root){
                root = null;
            }else if(rightChild == true){
                parentBinaryTreeNode.setRight(null);
            }else{
                parentBinaryTreeNode.setLeft(null);
            }
        }

        //No right node
        else if(tempBinaryTreeNode.getRight() == null){
            if(tempBinaryTreeNode == root){
                root = tempBinaryTreeNode.getLeft();
            }else if(rightChild == true){
                parentBinaryTreeNode.setLeft(tempBinaryTreeNode.getLeft());
            }else{
                parentBinaryTreeNode.setRight(tempBinaryTreeNode.getLeft());
            }
        }

        //No left node
        else if(tempBinaryTreeNode.getLeft() == null){
            if(tempBinaryTreeNode == root){
                root = tempBinaryTreeNode.getRight();
            }else if(rightChild == true){
                parentBinaryTreeNode.setRight(tempBinaryTreeNode.getRight());
            }else{
                parentBinaryTreeNode.setLeft(tempBinaryTreeNode.getRight());

            }
        }

        //Both left and right node are present
        else{
            if(rightChild == true){
                BinaryTreeNode<T> tempLeftNode = tempBinaryTreeNode.getLeft();
                parentBinaryTreeNode.setRight(tempBinaryTreeNode.getRight());
                tempLeftNode
            }
        }
        return true;

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