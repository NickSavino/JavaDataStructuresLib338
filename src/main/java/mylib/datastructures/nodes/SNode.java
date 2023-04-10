package mylib.datastructures.nodes;

public class SNode<T> implements Comparable<SNode<T>> {

    // T stands for type
    private T data;

    // next and prev are references to the next and previous nodes
    private SNode<T> next;


    // Default constructor
    public SNode() {
        this.data = null;
        this.next = null;
    }

    // Constructor
    public SNode(T data) {

        this.data = data;
        this.next = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        T data = this.data;
        return data;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }

    public SNode<T> getNext() {
        SNode<T> next = this.next;
        return next;
    }



    /**
     * Compares this node to another node
     * 
     * @param o
     * @return 0 if the data is equal, 1 if this node is greater than the argument node, -1 if this node is less than the argument node
     */
    public int compareTo(SNode<T> o) {
        
        if (data == null && o.data == null) {
            return 0;
        } else if (data == null) {
            return -1;
        } else if (o.data == null) {
            return 1;
        }

        try {
            return ((Comparable<T>) data).compareTo(o.data);

        } catch (ClassCastException e) {
            throw new UnsupportedOperationException("Data of type " + data.getClass().getName() + " does not implement Comparable");
        }
    
    }

}