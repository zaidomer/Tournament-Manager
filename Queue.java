import java.io.*;
import java.util.Scanner;

class Queue<T>{
    private QueueNode<T> root;

    Queue(){
        root = new QueueNode<T>(null);
    }

    public void enqueue(QueueNode<T> nodeToAdd){
        if(root.getItem() == null){
            root = nodeToAdd;
        }else{
            QueueNode<T> tempNode = root;
            while(tempNode.getNext() != null){
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(nodeToAdd);
        }
    }

    public T dequeue(){
        QueueNode<T> previousRoot = root;
        root = root.getNext();
        return previousRoot.getItem();
    }

    public int size(){
        int count = 1;
        QueueNode<T> tempNode = root;
        if(root.getItem() == null){
            return 0;
        }else{
            while(tempNode.getNext() != null){
                count++;
                tempNode = tempNode.getNext();
            }
            return count;
        }       
    }

    
}