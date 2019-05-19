/**
 * Project - TournamentManager
 * BinaryTreeNode.java
 * A Generic Binary Tree Node Object
 * @author Zaid Omer
 * @version May 12, 2019
 */

class BinaryTreeNode<T>{
    private T item;
    private String nodeName;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    /**
     * Binary Tree Node Constructor
     * @param item , the item stored in the node of type T
     * @param nodeName
     */
    public BinaryTreeNode(T item, String nodeName) {
        this.item = item;
        this.nodeName = nodeName;
        this.right = null;
        this.left = null;
    }

    /**
     * Binary Tree Node Constructor (another version)
     * @param item the item to add to the node, of type T
     */
    public BinaryTreeNode(T item) {
        this.item = item;
        this.right = null;
        this.left = null;
    }

    // Getters

    /**
     * Left node getter
     * @return left, the Node on the left of type BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> getLeft(){
        return this.left;
    }

    /**
     * Right node getter
     * @return right, the Node on the right of type BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> getRight(){
        return this.right;
    }

    /**
     * Node's item getter
     * @return item, the item in the node of type T
     */
    public T getItem(){
        return this.item;
    }

    /**
     * Node's name getter (I labelled each node with a name, like a player's name in
     * this case, to help organize the nodes rather than just random numbers)
     * @return nodeName, String the name of the node
     */
    public String getBinaryTreeNodeName(){
        return this.nodeName;
    }

    // Setters

    /**
     * Left node setter
     * @param leftItem , the node to the left, of type BinaryTreeNode<T>
     */
    public void setLeft(BinaryTreeNode<T> leftItem){
        this.left = leftItem;
    }

    /**
     * Right node setter
     * @param rightItem , the node to the right, of type BinaryTreeNode<T>
     */
    public void setRight(BinaryTreeNode<T> rightItem){
        this.right = rightItem;
    }

    /**
     * Item setter
     * @param item , the item to set in the node, of type T
     */
    public void setItem(T item){
        this.item = item;
    }

    /**
     * Binary tree node setter (a method to change all elements of the node at once)
     * @param node , the node to replace the current node with
     */
    public void setBinaryTreeNode(BinaryTreeNode<T> node){
        this.item = node.getItem();
        this.nodeName = node.getBinaryTreeNodeName();
        this.right = node.getRight();
        this.left = node.getLeft();
    }

    /**
     * Node name setter
     * @param nodeName
     */
    public void setBinaryTreeNodeName(String nodeName){
        this.nodeName = nodeName;
    }

    /**
     * determines of the node is a leaf or not
     * @return Boolean, true if the node is a leaf, false otherwise
     */
    boolean isLeaf(){
        if(left == null && right == null){
            return true;
        }else{
            return false;
        }
    }
}