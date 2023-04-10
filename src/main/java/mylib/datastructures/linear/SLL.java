package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class SLL<T extends Comparable<T>> {

    protected SNode<T> head;
    protected SNode<T> tail;

    protected int size;

    /**
     * Creates a new empty list
     */
    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    /**
     * Creates a new list with the given head and tail
     * 
     * @param head
     */
    public SLL(T head) {
        SNode<T> node = new SNode<T>(head);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    /**
     * inserts a node at the head of the list
     * 
     * @param node the node to insert at the head of the list
     * 
     *             1. Create a new node
     *             2. Set the new node's next pointer to the head
     *             3. Set the head to the new node
     *             4. If the list is empty, set the tail to the new node
     *             5. Increment the size of the list
     */
    public void insertHead(T node) {
        SNode<T> newHead = new SNode<T>(node);

        newHead.setNext(head);

        head = newHead;

        // If the tail is null, set the tail to the new head
        if (tail == null) {
            tail = newHead;
        }
        size++;
    }

    /**
     * Inserts a node at the tail of the list
     * 
     * @param node
     */
    public void insertTail(T node) {
        SNode<T> newNode = new SNode<T>(node);

        // If the tail is null, set the tail to the new node
        if (tail != null) {
            tail.setNext(newNode);
            tail = newNode;
        }
        else if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            head.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    /**
     * Inserts a node at the given index
     * 
     * @param node
     * @param index
     */
    public void insert(T node, int index) {

        // If index is 0, insert at head
        if (index == 0) {
            insertHead(node);
            return;
        }

        // If index is equal to the size of the list, insert at tail
        if (index == this.size) {
            insertTail(node);
            return;
        }

        // If index is greater than the size of the list, throw an error
        if (index > getSize()) {
            throw new IndexOutOfBoundsException("Index is greater than the size of the list");
        }

        SNode<T> curr = head;

        if (this.size == 1) {
            if (index == 1) {
                insertTail(node);
            }
            else {
                insertHead(node);
            }
            return;
        }

        // Traverse to the node before the index
        while (curr.getNext() != null && index > 1) {
            curr = curr.getNext();
            index--;
        }

        // set the nodes next pointer to the node at the index
        SNode<T> temp = new SNode<T>(node);
        temp.setNext(curr.getNext());
        // sets the node.next before the index to the new node
        curr.setNext(temp);
        size++;
    }

    /**
     * Inserts a node in the list in ascending order
     * Must check for list sort validity
     * - If list is found to be out of order, it must call the sort function first
     * before inserting
     * - Note that you should only execute sort if the list is found to be out of
     * order to avoid
     * slowing down the insertion by executing sorting every time you insert
     * - Might need to implement a helper function isSorted(), or find a creative
     * way to know if the list is sorted
     * 
     * @param node
     */
    public void sortedInsert(T node) {
        if (!isSorted()) {
            sort();
        }

        SNode<T> newNode = new SNode<T>(node);


        if (head == null) {
            head = newNode;
            return;
        }

        if (newNode.compareTo(head) < 0) {
            insertHead(node);
            return;
        }

        SNode<T> curr = head;


        // traverse list until suitable location is found
        while (curr.getNext() != null && newNode.compareTo(curr.getNext()) >= 0) {
            curr = curr.getNext();
        }

        // Insert new Node
        SNode<T> temp = curr.getNext();
        curr.setNext(newNode);
        newNode.setNext(temp);
        size++;
            

    }

    /**
     * Searches for a node in the list
     * 
     * @param node
     * @return returns the object if found, null otherwise
     */
    public T search(T node) {
        SNode<T> nodeToFind = new SNode<T>(node);
        SNode<T> curr = head;
        while (curr != null) {
            if (curr.getData() == nodeToFind.getData()) {
                System.out.println("Found node: " + curr.getData());
                return curr.getData();
            }
            curr = curr.getNext();
        }
        System.out.println("Node not found");
        return null;
    }

    /**
     * Deletes the head node if found
     */
    public void deleteHead() {
        SNode<T> temp = head;
        head = head.getNext();
        temp.setNext(null);
        this.size--;
    }

    /**
     * Deletes the tail node if found
     */
    public void deleteTail() {
        SNode<T> curr = head;
        while (curr.getNext() != tail) {
            curr = curr.getNext();
        }
        curr.setNext(null);
        tail = curr;
        this.size--;
    }

    /**
     * Deletes the node at the given index if found
     * 
     * @param node
     */
    public void delete(T node) {

        if (head == null) {
            return;
        }

        if (head.getData().equals(node)) {
            head = head.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
        }

        SNode<T> curr = head.getNext();
        SNode<T> prev = head;
        while (curr != null) {
            if (curr.getData().equals(node)) {
                if (curr == tail) {
                    tail = prev;
                }
                prev.setNext(curr.getNext());
                size--;
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }
    

    /**
     * Applies inplace insertion sort to the list
     * The insertion part will start from the head unlike the usual insertion sort
     * algorithm
     * Note that the sort method and SortedInsert can use each other to efficiently
     * reduce code redundancy (not mandatory)
     * 
     * @return nothing
     */
    public void sort() {

        if (head == null || head.getNext() == null) {
            return;
        }

        SLL<T> sortedList = new SLL<>();
        SNode<T> curr = head;

        while (curr != null) {
            SNode<T> nextNode = curr.getNext();
            T value = curr.getData();
            sortedList.sortedInsert(value);
            curr = nextNode;
        }

        head = sortedList.head;
        tail = sortedList.tail;
        size = sortedList.size;
    }

    /**
     * Deletes the whole list
     */
    public void clear() {

        SNode<T> curr = head;
        if (curr == null) {
            return;
        }
        while (curr != null) {
            SNode<T> temp = curr;
            curr = curr.getNext();
            temp.setNext(null);
        }

        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Prints the list information on the screen, this includes
     * - List Length
     * - Sorted Status
     * - List Contents
     * - Make sure to show information with relevant print statements to be readable
     * by the user
     */
    public void print() {
        int index = 0;

        SNode<T> curr = head;
        System.out.println("----------------------");
        while (curr != null) {
            System.out.print("  Index: " + index);
            System.out.println(" | Node: " + curr.getData());
            curr = curr.getNext();
            index++;
        }
        System.out.println("----------------------");
        System.out.println("List Length: " + getSize());
        System.out.println("Sorted Status: " + isSorted());
        System.out.println("----------------------");

    }

    /**
     * Returns the size of the list
     * 
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Determines if the list is sorted
     * - If the list is empty, it is considered sorted
     * - If the list has only one node, it is considered sorted
     * - If the list has more than one node, it is considered sorted if all nodes
     * are in ascending order
     * 
     * @return true if sorted, false otherwise
     */
    public boolean isSorted() {

        if (this.size == 0 || this.size == 1) {
            return true;
        }

        SNode<T> curr = head;

        // traverse through the list and check if the list is sorted
        while (curr.getNext() != null) {
            if (curr.compareTo(curr.getNext()) > 0) {
                return false;
            }
            curr = curr.getNext();
        }
        return true;
    }

    /**
     * Returns the head of the list
     * 
     * @return
     */
    public SNode<T> getHead() {
        SNode<T> temp = new SNode<T>(head);
        return temp;
    }

    /**
     * Returns the tail of the list
     * 
     * @return
     */
    public SNode<T> getTail() {
        SNode<T> temp = new SNode<T>(tail);
        return temp;
    }

}
