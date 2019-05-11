class QueueNode<T>{
    private T item;
    private QueueNode<T> next;

    public QueueNode(T item){
        this.item = item;
        this.next = null;
    }

    public QueueNode(T item, QueueNode<T> next){
        this.item = item;
        this.next = next;
    }

    //Getters
    public QueueNode<T> getNext(){
        return next;
    }

    public T getItem(){
        return item;
    }

    //Setters
    public void setNext(QueueNode<T> next){
        this.next = next;
    }

    public void setItem(T item){
        this.item = item;
    }
}