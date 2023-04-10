package mylib.datastructures.linear;

public class CSLL<T> extends SLL<T> {
    
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
    
}
