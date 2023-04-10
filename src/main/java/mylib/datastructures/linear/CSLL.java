package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class CSLL<T extends Comparable<T>> extends SLL<T> {
    
    public CSLL() {
        super();
    }

    public CSLL(T head) {
        super(head);
        this.tail.setNext(this.head);
    }

    @Override
    public void insertHead(T node) {
        super.insertHead(node);
        this.tail.setNext(this.head);
    }

    @Override
    public void insertTail(T node) {
        super.insertTail(node);
        this.tail.setNext(this.head);
    }

    @Override
    public void deleteHead() {
        if (this.getSize() > 1) {
            this.tail.setNext(this.head.getNext());
        }
        super.deleteHead();
    }

    @Override
    public void deleteTail() {
        super.deleteTail();
        if (getSize() > 0) {
            this.tail.setNext(this.head);
        }
    }

    @Override
    public void insert(T data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    
        SNode<T> newNode = new SNode<>(data);
        SNode<T> current = head;
        SNode<T> previous = null;
    
        if (index == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.setNext(newNode);
            } else {
                newNode.setNext(head);
                head = newNode;
                tail.setNext(head);
            }
        } else {
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
    
            newNode.setNext(current);
            previous.setNext(newNode);
    
            if (index == size) {
                tail = newNode;
                tail.setNext(head);
            }
        }
    
        size++;

    }
    @Override 
    public void delete(T data) {
        if (this.getSize() == 0) {
            return;
        }
    
        SNode<T> curr = this.head;
        SNode<T> prev = null;
    
        // Traverse the list until the data is found or we reach the starting point again
        do {
            if (curr.getData().equals(data)) {
                if (prev == null) { // Deleting the head node
                    if (head == tail) { // Only one node in the list
                        head = null;
                        tail = null;
                    } else {
                        head = head.getNext();
                        tail.setNext(head);
                    }
                } else {
                    prev.setNext(curr.getNext());
                    if (curr == tail) {
                        tail = prev;
                    }
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.getNext();
        } while (curr != head);
    }
    
}
