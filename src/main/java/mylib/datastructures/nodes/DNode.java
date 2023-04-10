package mylib.datastructures.nodes;

public class DNode<T> implements Comparable<DNode<T>> {
    
    // T stands for type
    private T data;

    private DNode<T> next;
    private DNode<T> prev;

    public DNode() {
        this.next = null;
        this.prev = null;
        this.data = null;
    }

    public DNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    
    public void set(T data) {
        this.data = data;
    }

    public T get() {
        T data = this.data;
        return data;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode<T> getNext() {
        DNode<T> next = this.next;
        return next;
    }


    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }

    public DNode<T> getPrev() {
        DNode<T> prev = this.prev;
        return prev;
    }

    

    @Override
    /**
     * Compares this node to another node
     * 
     * @param o
     * @return 0 if the data is equal, 1 if this node is greater than the argument node, -1 if this node is less than the argument node
     */
    public int compareTo(DNode<T> o) {
        
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
