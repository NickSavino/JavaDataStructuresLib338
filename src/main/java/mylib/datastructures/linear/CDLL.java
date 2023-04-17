package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;
import mylib.datastructures.nodes.TNode;

public class CDLL<T extends Comparable<T>> extends DLL<T> {
    
    /**
     * Constructor to initialize an empty list
     */
    public CDLL() {
        super();
    }

    /**
     * Constructor overload with one node initializes the list with head and tail pointing
     * to the same node and self referencing
     * @param node the node to initialize the list with
     */
    public CDLL(DNode<T> node) {
            super(node);
    }

    /**
     * Constructor overload with data initializes the list with head and tail pointing
     * @param data the data to initialize the list with
     */
    public CDLL(T data) {
        super(data);
    }

    /**
     * Inserts a node at the head of the list
     * @param node the node to be inserted
     */
    @Override
    public void insertHead(T data) {
        DNode<T> newNode = new DNode<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            head.setNext(head);
            head.setPrev(head);
        } else {
            newNode.setNext(head); // newNode.next = head;
            newNode.setPrev(tail); // newNode.prev = tail;
            head.setPrev(newNode); // head.prev = newNode;
            tail.setNext(newNode); // tail.next = newNode;
            head = newNode; // head = newNode;
        }
        size++;
    }

    /**
     * Inserts a node at the tail of the list
     * @param node the node to be inserted
     */
    @Override
    public void insertTail(T data) {
        if (this.tail == null) {
            this.tail = new DNode<T>(data);
            this.head = this.tail;
            this.tail.setNext(this.tail);
            this.tail.setPrev(this.tail);
        } else {
            DNode<T> newNode = new DNode<T>(data);
            head.setPrev(newNode); // this.head.prev = newNode;
            tail.setNext(newNode); // this.tail.next = newNode;
            newNode.setPrev(this.tail); // newNode.prev = this.tail;
            newNode.setNext(this.head); // newNode.next = this.head;
            this.tail = newNode; // this.tail = newNode;
        }
        size++;
    }

    /**
     * Inserts a node at the given index
     * @param node the node to be inserted
     * @param index the index where the node is to be inserted
     */
    @Override
    public void insert(T node, int index) {
        
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        DNode<T> nodeToInsert = new DNode<T>(node);
        DNode<T> curr = this.head;
        if (index == 0) {
            insertHead(node);
            return;
        }
        else if (index == this.size) {
            insertTail(node);
            return;
        } else {
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }  
            nodeToInsert.setPrev(curr.getPrev());
            nodeToInsert.setNext(curr);
            curr.getPrev().setNext(nodeToInsert);
            curr.setPrev(nodeToInsert);
        }


        this.size++;
    }

    /**
     * Deletes the head node if found
     */
    @Override
    public void deleteHead() {
        if (this.head == null) {
            throw new NullPointerException("List is empty");
        }

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(this.tail); // this.head.prev = this.tail;
            this.tail.setNext(this.head); // this.tail.next = this.head;
        }
    }

    /**
     * Deletes the tail node if found
     */
    @Override
    public void deleteTail() {

        if (this.tail == null) {
            throw new NullPointerException("List is empty");
        }

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(this.head); // this.tail.next = this.head;
            this.head.setPrev(this.tail); // this.head.prev = this.tail;
        }
    }

    /**
     * Deletes the node if found
     * @param node the node to be deleted
     */
    @Override
    public void delete(T node) {
        if (this.head == null) {
            throw new NullPointerException("List is empty");
        }

        DNode<T> curr = this.head;
        while (curr.getData() != node && curr != this.tail) {
            curr = curr.getNext();
        }
       
        if (curr == this.tail) {
            this.deleteTail();
        } else {
            curr.getPrev().setNext(curr.getNext()); // curr.prev.next = curr.next;
            curr.getNext().setPrev(curr.getPrev()); // curr.next.prev = curr.prev;
        }
    }


    @Override
    public void sortedInsert(T node) {
        
        if (!isSorted()) {
            sort();
        }

        DNode<T> nodeToInsert = new DNode<T>(node);
        DNode<T> curr = this.head;
        
    }

    /**
     * Sorts the list in ascending order
     */
    @Override
    public void sort() {

        if (this.head == null) {
            return;
        }

        DNode<T> curr = this.head;
    
        
    }

    /**
     * Clears the list
     */
    @Override
    public void clear() {
        // TODO: Implement clear
    }

    /**
     * Prints the list information on the screen, this includes:
     *  - List Length
     *  - Sorted Status
     *  - List Contents
     */
    @Override
    public void print() {
        // TODO: Implement print
    }

    /**
     * Checks if the list is sorted
     * @return true if the list is sorted, false otherwise
     */
    @Override
    public boolean isSorted() {

        if (this.head == null) {
            return true;
        }

        DNode<T> curr = this.head;
        while (curr.getNext() != this.head) {
            if (curr.getData().compareTo(curr.getNext().getData()) > 0) {
                return false;
            }
        }
        return true;
    }

}