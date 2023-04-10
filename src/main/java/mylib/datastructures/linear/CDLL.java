package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class CDLL<T extends Comparable<T>> extends DLL<T> {
    
    /**
     * Constructor to initialize an empty list
     */
    public CDLL() {
        // TODO: Implement constructor
    }

    /**
     * Constructor overload with one node initializes the list with head and tail pointing
     * to the same node and self referencing
     * @param node the node to initialize the list with
     */
    public CDLL(DNode<T> node) {
        // TODO: Implement constructor overload
    }

    /**
     * Inserts a node at the head of the list
     * @param node the node to be inserted
     */
    @Override
    public void insertHead(T node) {
        // TODO: Implement insertHead
    }

    /**
     * Inserts a node at the tail of the list
     * @param node the node to be inserted
     */
    @Override
    public void insertTail(T node) {
        // TODO: Implement insertTail
    }

    /**
     * Inserts a node at the given index
     * @param node the node to be inserted
     * @param index the index where the node is to be inserted
     */
    @Override
    public void insert(T node, int index) {
        // TODO: Implement insert
    }

    /**
     * Deletes the head node if found
     */
    @Override
    public void deleteHead() {
        // TODO: Implement deleteHead
    }

    /**
     * Deletes the tail node if found
     */
    @Override
    public void deleteTail() {
        // TODO: Implement deleteTail
    }

    /**
     * Deletes the node if found
     * @param node the node to be deleted
     */
    @Override
    public void delete(T node) {
        // TODO: Implement delete
    }

    /**
     * Sorts the list in ascending order
     */
    @Override
    public void sort() {
        // TODO: Implement sortAscending
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

}