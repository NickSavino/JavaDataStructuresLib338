package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;

public class BST<T extends Comparable<T>> {
    
    private TNode<T> root;

    public BST() {
        this.root = null;
    }

    public BST(T data) {
        this.root = new TNode<>(data);
    }

    public BST(TNode<T> obj) {
        this.root = obj;
    }

    public TNode<T> getRoot() {
        TNode<T> tmp = new TNode<T>(this.root.getData());
        return tmp;
    }

    public void setRoot(TNode<T> root) {
        this.root = root;
    }

    public void insert(T data) {
        // TODO: Implement this method
    }

    public void insert(TNode<T> node) {
        // TODO: Implement this method
    }

    public void delete(T data) {
        // TODO: Implement this method
    }

    public TNode<T> search(T data) {
        // TODO: Implement this method
        return new TNode<T>();
    }

    public void printInOrder() {
        // TODO: Implement this method
    }

    public void printBF() {
        
    }

}
