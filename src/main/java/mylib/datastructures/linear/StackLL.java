package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class StackLL<T> extends SLL<T> {
    
    //pointer that keeps a reference to the top of the stack
    protected SNode<T> top;

    /**
     * Default Constructor
     * No Arguments
     * Create an empty stack
     * returns none
     */
    public StackLL() {
        super();
        this.top = null;
    }

    /**
     * pushes an element into the top of the stock
     * 
     * @param data the element to be pushed into the stack
     */
    public void push(T data) {
        SNode<T> newElement = new SNode<T>(data);
        newElement.setNext(top);
        top = newElement;
        size++;
    }

    /**
     * Removes and returns the element from the top of the stack
     * @return data 
     */
    public T pop() {
    
        if (isEmpty()) {
            throw new IllegalAccessError("Stack is empty");
        }
        T data = top.getData();
        // Updates the top pointer to the next element
        top = top.getNext();
        size--;
        return data;
    }

    /**
     * returns a copy of the value at the top of the stack without popping it
     * 
     * @return returns the top element
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalAccessError("Stack is empty");
        }
        return top.getData();
    }

    /**
     * Determines if the stack is empty
     * @return returns true if yes, false otherwise
     */
    public boolean isEmpty() {
        if (this.size == 0){
            return true;
        }
        return false;
    }

    //Must override all the functions that violate the Stack data structure and leave them empty
    @Override
    public void insertHead(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }
    
    @Override
    public void insertTail(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public void insert(T node, int index) {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public void sortedInsert(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public T search(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public void deleteHead() {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public void deleteTail() {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public void delete(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public boolean isSorted() {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public SNode<T> getHead() {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

    @Override
    public SNode<T> getTail() {
        throw new UnsupportedOperationException("Operation not supporteed for StackLL");
    }

}
