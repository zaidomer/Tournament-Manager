class Node<T>{
    private T item;
    private String nodeName;
    private Node<T> left;
    private Node<T> right;

    public Node(T item, String nodeName) {
        this.item = item;
        this.nodeName = nodeName;
        this.right = null;
        this.left = null;
    }

    public Node(T item) {
        this.item = item;
        this.nodeName = nodeName;
        this.right = null;
        this.left = null;
    }

    // Getters
    public Node<T> getLeft(){
        return this.left;
    }

    public Node<T> getRight(){
        return this.right;
    }

    public T getItem(){
        return this.item;
    }

    public String getNodeName(){
        return this.nodeName;
    }

    // Setters
    public void setLeft(Node<T> leftItem){
        this.left = leftItem;
    }

    public void setRight(Node<T> rightItem){
        this.right = rightItem;
    }

    public void setItem(T item){
        this.item = item;
    }

    public void setNode(Node<T> node){
        this.item = node.getItem();
        this.nodeName = node.getNodeName();
        this.right = node.getRight();
        this.left = node.getLeft();
    }

    public void setNodeName(String nodeName){
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