package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;

public class AVL<T extends Comparable<T>> extends BST<T> {

    public AVL() {
        super();
    }

    public AVL(T data) {
        super(data);
    }

    public AVL(TNode<T> obj) {
        // TODO: Implement this constructor
    }

    @Override
    public void setRoot(TNode<T> root) {
        // TODO: Implement this method
    }

    @Override
    public void insert(T data) {
        // TODO: Implement this method
    }

    @Override
    public void insert(TNode<T> node) {
        // TODO: Implement this method
    }

    public void delete(T data) {
        // TODO: Implement this method (Bonus)
    }

    // Helper methods for balancing the AVL tree
    private TNode<T> rotateLeft(TNode<T> node) {
        // TODO: Implement this method
        return null;
    }

    private TNode<T> rotateRight(TNode<T> node) {
        // TODO: Implement this method
        return null;
    }

    private int getHeight(TNode<T> node) {
        // TODO: Implement this method
        return 0;
    }

    private int getBalanceFactor(TNode<T> node) {
        // TODO: Implement this method
        return 0;
    }

    private TNode<T> balance(TNode<T> node) {
        // TODO: Implement this method
        return null;
    }
}
