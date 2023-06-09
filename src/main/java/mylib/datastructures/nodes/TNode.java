package mylib.datastructures.nodes;


public class TNode<T extends Comparable<T>> implements Comparable<TNode<T>> {

    private T data;

    private TNode<T> parent;

    private TNode<T> left;
    private TNode<T> right;

    private int balance;
    private int height = 1;

    public TNode() {
        this.data = null;
        this.parent = null;

        this.left = null;
        this.right = null;
    }

    public TNode(T data) {
        this(data, null, null, null);
    }

    public TNode(T data, TNode<T> P, TNode<T> L, TNode<T> R) {
        this.data = data;
        this.parent = P;
        this.left = L;
        this.right = R;
    }

    // Constructor with node as argument
    public TNode(TNode<T> node) {
        this.data = node.data;
        this.parent = node.parent;
        this.left = node.left != null ? new TNode<T>(node.left) : null;
        this.right = node.right != null ? new TNode<T>(node.right) : null;
        this.balance = node.balance != 0 ? node.balance : 0;
        this.height = node.height != 0 ? node.height : 0;
    }


    public T getData() {
        T tmp = this.data == null ? null : this.data;
        return tmp;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TNode<T> getLeft() {
        TNode<T> tmp = this.left;
        return tmp;
    }

    public void setLeft(TNode<T> left) {
        this.left = left;
    }

    public TNode<T> getRight() {
        TNode<T> tmp = this.right;
        return tmp;
    }

    public void setRight(TNode<T> right) {
        this.right = right;
    }

    public TNode<T> getParent() {
        TNode<T> tmp = this.parent;
        return tmp;
    }

    public void setParent(TNode<T> parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isLeftChild() {
        return this.parent != null && this.parent.getLeft() == this;
    }

    public boolean isRightChild() {
        return this.parent != null && this.parent.getRight() == this;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public void print() {
        System.out.println("Data: " + this.data);
        System.out.println("Parent: " + (this.parent != null ? this.parent.getData() : "null"));        
        System.out.println("Left: " + this.left);
        System.out.println("Right: " + this.right);
        System.out.println("Balance: " + this.balance);
    }

    public String toString() {
        return this.data.toString();
    }

        /**
     * Compares this node to another node
     * 
     * @param o
     * @return 0 if the data is equal, 1 if this node is greater than the argument node, -1 if this node is less than the argument node
     */
    public int compareTo(TNode<T> o) {
        
        if (data == null && o.data == null) {
            return 0;
        } else if (data == null) {
            return -1;
        } else if (o.data == null) {
            return 1;
        }

        try {
            return data.compareTo(o.data);

        } catch (ClassCastException e) {
            throw new UnsupportedOperationException("Data of type " + data.getClass().getName() + " does not implement Comparable");
        }
    
    }
}
