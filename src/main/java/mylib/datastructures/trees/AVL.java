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
    public void setRoot(T root) {
        throw new UnsupportedOperationException("AVL does not support setRoot");
    }

    @Override
    public void insert(T data) {
        this.root = insert(data, this.root);
    }

    @Override
    public void insert(TNode<T> node) {
        this.root = insert(node.getData(), node);
    }
 
    public TNode<T> insert(T data, TNode<T> node) {
        if (node == null) {
            return new TNode<T>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert(data, node.getRight()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    // @Override
    // private void insert(TNode<T> node) {
    //     // TODO: Implement this method
    // }

    @Override
    public void delete(T data) {
        this.root = delete(data, this.root);
    }

    public TNode<T> delete(T data, TNode<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));
        }
        else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(data, node.getRight()));
        }
        else {
            if (node.getLeft() == null) {
                return node.getRight();
            }
            else if (node.getRight() == null) {
                return node.getLeft();
            }
            TNode<T> temp = findMax(node.getLeft());

            node.setData(temp.getData());
            node.setLeft(delete(temp.getData(), node.getLeft()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    // Helper methods for balancing the AVL tree
    private TNode<T> rotateLeft(TNode<T> node) {
        TNode<T> rightNode = node.getRight();
        TNode<T> centerNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private TNode<T> rotateRight(TNode<T> node) {
        TNode<T> leftNode = node.getLeft();
        TNode<T> centerNode = leftNode.getRight();
        leftNode.setRight(node);
        node.setLeft(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private TNode<T> applyRotation(TNode<T> node) {
        int balance = balance(node);
        if (balance > 1) { //left heavy
            if (balance(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (balance < -1) { //right heavy
            if (balance(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }


    private void updateHeight(TNode<T> node) {
        int maxHeight = Math.max(height(node.getLeft()), height(node.getRight()));

        node.setHeight(maxHeight + 1);
    }

    private int height(TNode<T> node) {
        return node != null ? node.getHeight() : 0;
    }

    private int balance(TNode<T> node) {
        return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
    }
}
