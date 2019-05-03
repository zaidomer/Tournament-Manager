class Node<T>{
    private T item;
    private Node<T> left;
    private Node<T> right;

    public Node(T item) {
        this.item = item;
        this.right = null;
        this.left = null;
    }

    public Node<T> getLeft(){
        return this.left;
    }

    public Node<T> getRight(){
        return this.right;
    }

    public T getItem(){
        return this.item;
    }

    public void setLeft(Node<T> leftItem){
        this.left = leftItem;
    }

    public void setRight(Node<T> rightItem){
        this.right = rightItem;
    }

    public void setItem(T item){
        this.item = item;
    }

    boolean isLeaf(){
        if(left == null && right == null){
            return true;
        }else{
            return false;
        }
    }
}