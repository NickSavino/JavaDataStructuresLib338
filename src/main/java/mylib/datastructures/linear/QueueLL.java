package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;


/**
 * Linked List Based Queue Data Structure
 * 
 * Follows First-in-first-out principles
 * new elments are inserted at the tail
 * items are dequeued at the head
 */
public class QueueLL<T> extends SLL<T> {
    


    public QueueLL() {
        super();
    }

    public QueueLL(T data) {

    }

    /**
     * Inserts an element into the queue
     * @param node
     */
    public void enqueue(T node) {
        super.insertTail(node);
    }

    /**
     * Returns and removes the head of the queue
     * 
     * @return returns value at the front of the queue
     */
    public T dequeue() {
        
        if (isEmpty()) {
            return null;
        }

        SNode<T> data = super.getHead();
        super.deleteHead();
        return data.get();
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return super.getHead().get();
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void insertHead(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }
    
    @Override
    public void insertTail(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

    @Override
    public void insert(T node, int index) {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");

    }

    @Override
    public void sortedInsert(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

    @Override
    public SNode<T> search(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

    @Override
    public void deleteHead() {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

    @Override
    public void deleteTail() {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

    @Override
    public void delete(T node) {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

    @Override
    public boolean isSorted() {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

    @Override
    public SNode<T> getHead() {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

    @Override
    public SNode<T> getTail() {
        throw new UnsupportedOperationException("Operation not supporteed for QueueLL");
    }

}
