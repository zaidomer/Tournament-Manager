/**
 * Project - TournamentManager
 * BinaryTree.java
 * A File to make the binary tree object
 * @author Zaid Omer
 * @version May 12, 2019
 */

class BinaryTree<T extends Comparable<T>>{
    private BinaryTreeNode<T> root;

    /**
     * BinaryTree Constructor
     */
    BinaryTree(){
        root = new BinaryTreeNode<T>(null, null);
    }

    /**
     * BinaryTree Constructor
     * @param root , root of tree of type BinaryTreeNode
     */
    BinaryTree(BinaryTreeNode<T> root){
        this.root = root;
    }

    /**
     * Add nodes to binary tree
     * @param nodeToAdd this is the node to add to the tree NOTE:
     * ususally, there would be an item as a parameter of type T. I used a node as it makes it easier to use
     * as i have more than just one item in each node (e.g. a node label)
     */
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

    /**
     * Method to remove nodes from a binary tree
     * @param parent , the node before the one to be removed, of type BinaryTreeNode
     * @param nodeToRemove ,the node to get rid of from the tree, of type BinaryTreeNode
     * @return Boolean true if item has been removed, false otherwise
     */
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

    /**
     * Helper methods to re-add nodes that don't need to be removed
     * @param tempNode this is the node which has been removed from the tree
     * @return Boolean, returns true at the end of  re-adding all nodes
     */
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

    /**
     * This checks to ee if the tree has the node with the name specified (the same as contains,
     * but looking at node names is more practical for this progam)
     * @param nodeName , the node which needs to be determined if it's in the tree or not, of type String
     * @param root , the root of the tree, used for taversing the tree, od type BinaryTreeNode
     * @return Boolean true if the node is in the tree, false otherwise
     */
    public boolean containsNodeName(String nodeName, BinaryTreeNode<T> root){
        if(root.getBinaryTreeNodeName()!= null && root.getBinaryTreeNodeName().equals(nodeName)){
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

    /**
     * returns the size of a tree
     * @param root this is the beginning of the tree, of type BinaryTreeNode
     * @return int the size of the tree
     */
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

    /**
     * Root getter
     * @return root , the root of the tree, of type BinaryTreeNode
     */
    public BinaryTreeNode<T> getRoot(){
        return root;
    }

    /**
     * Root setter
     * @param root , the root of the tree, of type BinaryTreeNode
     */
    public void setRoot(BinaryTreeNode<T> root){
        this.root = root;
    }
}