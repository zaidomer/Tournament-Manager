class BinaryTreeNode<T>{
    private T item;
    private String nodeName;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T item, String nodeName) {
        this.item = item;
        this.nodeName = nodeName;
        this.right = null;
        this.left = null;
    }

    public BinaryTreeNode(T item) {
        this.item = item;
        this.nodeName = nodeName;
        this.right = null;
        this.left = null;
    }

    // Getters
    public BinaryTreeNode<T> getLeft(){
        return this.left;
    }

    public BinaryTreeNode<T> getRight(){
        return this.right;
    }

    public T getItem(){
        return this.item;
    }

    public String getBinaryTreeNodeName(){
        return this.nodeName;
    }

    // Setters
    public void setLeft(BinaryTreeNode<T> leftItem){
        this.left = leftItem;
    }

    public void setRight(BinaryTreeNode<T> rightItem){
        this.right = rightItem;
    }

    public void setItem(T item){
        this.item = item;
    }

    public void setBinaryTreeNode(BinaryTreeNode<T> node){
        this.item = node.getItem();
        this.nodeName = node.getBinaryTreeNodeName();
        this.right = node.getRight();
        this.left = node.getLeft();
    }

    public void setBinaryTreeNodeName(String nodeName){
        this.nodeName = nodeName;
    }

    boolean isLeaf(){
        if(left == null && right == null){
            return true;
        }else{
            return false;
        }
    }
}