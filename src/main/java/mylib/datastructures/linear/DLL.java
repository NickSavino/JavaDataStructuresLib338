package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class DLL<T extends Comparable<T>> {

    protected DNode<T> head;
    protected DNode<T> tail;
    private int size;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DLL(T head) {
        DNode<T> node = new DNode<T>(head);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    /**
     * inserts a node at the head of the list
     * 
     * @param node the node to insert at the head of the list 
     * 
     *  1. Create a new node
     *  2. Set the new node's next pointer to the head
     *  3. Set the head to the new node
     *  4. If the list is empty, set the tail to the new node
     *  5. Increment the size of the list
     */
    public void insertHead(T node) {
        DNode<T> newHead = new DNode<T>(node);

        if (head != null) {
            head.setPrev(newHead);
            newHead.setNext(head);
            newHead.setPrev(null);
        }

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
        DNode<T> newNode = new DNode<T>(node);

        if (tail != null) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            newNode.setNext(null);
        }
        

        tail = newNode;

        if (head == null) {
            head = newNode;
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
        if (index == getSize()) {
            insertTail(node);
            return;
        }

        // If index is greater than the size of the list, throw an error
        if (index > getSize()) {
            throw new IndexOutOfBoundsException("Index is greater than the size of the list");
        }

        DNode<T> curr = head;

        // Traverse to the node before the index
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        // set the nodes next pointer to the node at the index and the index nodes previous pointer to the new node
        DNode<T> temp = new DNode<T>(node);
        temp.setNext(curr.getNext());
        temp.setPrev(curr);
        temp.getNext().setPrev(temp);
        // set the nodes previous pointer to the node before the index
        // sets the node.next before the index to the new node
        curr.setNext(temp);
        size++;
    }

    /**
     * Inserts a node in the list in ascending order
     * Must check for list sort validity
     *    - If list is found to be out of order, it must call the sort function first before inserting
     *    - Note that you should only execute sort if the list is found to be out of order to avoid 
     *      slowing down the insertion by executing sorting every time you insert
     *    - Might need to implement a helper function isSorted(), or find a creative
     *      way to know if the list is sorted
     * 
     * @param node
     */
    public void sortedInsert(T node) {
        if (!isSorted()) {
            sort();
        }

        DNode<T> newNode = new DNode<T>(node);


        // If the list is empty, insert at head
        if (head == null) {
            insertHead(node);
            return;
        }

        // If the new node is less than the head, insert at head
        if (newNode.compareTo(head) < 0) {
            insertHead(node);
            return;
        }

        DNode<T> curr = head;


        // traverse list until suitable location is found
        while (curr.getNext() != null && newNode.compareTo(curr.getNext()) >= 0) {
            curr = curr.getNext();
        }

        // Insert new Node
        DNode<T> temp = curr.getNext();
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
        DNode<T> curr = head;
        while (curr != null) {
            if (curr.getData().equals(node)) {
                System.out.println("Found node: " + curr.getData());
                
                // return a deep copy of the node
                return new DNode<T>(curr.getData()).getData();
            }
            curr = curr.getNext();
        }
        return null;
    }

    /**
     * Deletes the head node if found
     */
    public void deleteHead() {

        // If the head is null return
        if (head == null) {
            return;
        }
        // If the head is the tail, set the tail and head to null
        if (head == tail) {
            head = null;
            tail = null;
        }


        DNode<T> temp = head;
        head = head.getNext();

        if (head != null) {
            head.setPrev(null);
        }
        temp.setNext(null);

        this.size--;
    }

    /**
     * Deletes the tail node if found
     */
    public void deleteTail() {

        if (head == null || head == tail) {
            deleteHead();
            return;
        }
        DNode<T> curr = head;
        while (curr.getNext() != tail) {
            curr = curr.getNext();
        }
        curr.setNext(null);
        tail.setPrev(null);
        tail = curr;
        this.size--;
    }

    /**
     * Deletes the node at the given index if found
     * 
     * @param node
     */
    public void delete(T node) {
        
        if (head.getData().equals(node)) {
            deleteHead();
            return;
        }

        if (tail.getData().equals(node)) {
            deleteTail();
            return;
        }

        DNode<T> curr = head;

        //traverse list
        while (curr != null && !curr.getData().equals(node)) {
            curr = curr.getNext();
        }

        if (curr == null) {
            System.out.println("Node not found");
            return;
        }

        //update the prev pointer of the next node and the next pointer of the previous nod
        curr.getNext().setPrev(curr.getPrev());
        curr.getPrev().setNext(curr.getNext());

        curr.setNext(null);
        curr.setPrev(null);

        this.size--;
    }

    /**
     * Applies insertion sort to the list
     * The insertion part will start from the head unlike the usual insertion sort algorithm
     * Note that the sort method and SortedInsert can use each other to efficiently reduce code redundancy (not mandatory)
     */
    public void sort() {
        
        if (head == null || head.getNext() == null) {
            return;
        }

        DLL<T> sortedList = new DLL<>();
        DNode<T> curr = head;

        while (curr != null) {
            DNode<T> nextNode = curr.getNext();
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

        DNode<T> curr = head;
        while (curr != null) {
            DNode<T> temp = curr;
            curr = curr.getNext();
            temp.setNext(null);
            temp.setPrev(null);
        }

        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Prints the list information on the screen, this includes
     *      - List Length
     *      - Sorted Status
     *      - List Contents
     *      - Make sure to show information with relevant print statements to be readable by the user
     */
    public void print() {
        int index = 0;
        
        DNode<T> curr = head;
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
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Determines if the list is sorted
     *  - If the list is empty, it is considered sorted
     *  - If the list has only one node, it is considered sorted
     *  - If the list has more than one node, it is considered sorted if all nodes are in ascending order
     * @return true if sorted, false otherwise
     */
    public boolean isSorted() {

        if (this.size <= 1) {
            return true;
        }

        DNode<T> curr = head;
        
        // traverse through the list and check if the list is sorted
        while (curr.getNext() != null) {
                
            if (curr.getData().compareTo(curr.getNext().getData()) > 0) {
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
    public DNode<T> getHead() {
        DNode<T> temp = new DNode<T>(head.getData());
        return temp;
    }

    /**
     * Returns the tail of the list
     * 
     * @return
     */
    public DNode<T> getTail() {
        DNode<T> temp = new DNode<T>(tail.getData());
        return temp;
    }

    
    
}
