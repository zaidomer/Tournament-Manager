class Team<T extends Comparable<T>> {
    private String teamName;
    private Node<T> root;
    
    Team(String teamName){
        this.teamName = teamName;
        root = null;
    }
    
    public void add(Node<T> nodeToAdd){
        boolean nodePlaced = false;
        Node<T> tempNode = root;
        while(nodePlaced == false){
            if(root == null){
                root = nodeToAdd;
            }else{
                if((nodeToAdd.getItem()).compareTo(tempNode.getItem()) >= 0){
                    if(tempNode.getRight() == null){
                        tempNode.setRight(nodeToAdd);
                        nodePlaced = true;
                    }
                    tempNode.setRight(tempNode.getRight());
                }else{
                    if(tempNode.getLeft() == null){
                        tempNode.setLeft(nodeToAdd);
                        nodePlaced = true;
                    }
                    tempNode.setLeft(tempNode.getLeft());
                }
            }
        }
    }
    
    public void remove(){
        
    }
    
    public boolean isEmpty(Node<T> node){
        if(){

        }
    }
    
    public void contains(){
        
    }
    
    public int size(Node<T> root){
        if((root.getRight() != null) && (root.getLeft() != null)){
            return 2 + size(root.getRight()) + size(root.getLeft());
        }else if(root.getRight() != null){
            return 1 + size(root.getRight());
        }else if(root.getLeft() != null){
            return 1 + size(root.getLeft());
        }else{
            return 0;
        }
    }
}
