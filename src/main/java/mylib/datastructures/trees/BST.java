package mylib.datastructures.trees;

import mylib.datastructures.linear.QueueLL;
import mylib.datastructures.nodes.DNode;
import mylib.datastructures.nodes.TNode;

public class BST<T extends Comparable<T>> {
    
    protected TNode<T> root;

    protected int size;

    public BST() {
        this.root = null;
    }

    public BST(T data) {
        this.root = new TNode<>(data);
        this.size++;
    }

    public BST(TNode<T> obj) {
        this.root = obj;
        this.size++;
    }

    public TNode<T> getRoot() {
        return this.root == null ? null : new TNode<T>(this.root);
    }

    public void setRoot(T data) {
        this.root = new TNode<T>(data);
        this.size++;
    }
     
    /**
     * Inserts a node into the tree
     * meant for public access
     * @param data
     */
    public void insert (T data) {
        TNode<T> node = new TNode<T>(data);
        insert(node);
    }
    /**
     * Inserts a node into the tree
     * meant for protected access
     * @param node
     */
    protected void insert(TNode<T> node) {
        root = insertHelper(root, node);
        this.size++;
    }

    /**
     * Helper method for inserting a node into the tree
     * @param root
     * @param node
     * @return returns the root of the tree
     */
    protected TNode<T> insertHelper(TNode<T> root, TNode<T> node) {
        T data = node.getData();
        if (root == null) {
            root = node;
            return root;
        }
        else if (data.compareTo(root.getData()) < 0) {
            root.setLeft(insertHelper(root.getLeft(), node));
        }
        else {
            root.setRight(insertHelper(root.getRight(), node));
        }
        return root;
    }

    public void delete(T data) {

        if (search(data) == null) {
            System.out.println("Node not found");
            return;
        } else {
            deleteHelper(root, data);
        }
    }

    private TNode<T> deleteHelper(TNode<T> root, T data) {
        
        if (root == null) {
            return root;
            // if data <= root.data, go left
        } else if(data.compareTo(root.getData()) < 0) {
            root.setLeft(deleteHelper(root.getLeft(), data));
            //if data > root.data, go right
        } else if (data.compareTo(root.getData()) > 0) {
            root.setRight(deleteHelper(root.getRight(), data));
        } else { //root is the node to be deleted
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            } else if (root.getRight() != null) {
                root = findMin(root.getRight());
                root.setRight(deleteHelper(root.getRight(), data));
            } else {
                root = findMax(root.getLeft());
                root.setLeft(deleteHelper(root.getLeft(), data));
            }

        }
        return root;
    }

    public TNode<T> search(T data) {
        return searchHelper(root, data);
    }

    private TNode<T> searchHelper(TNode<T> root, T data) {
        
        if (root == null) {
            return null;
        } 

        if (data.compareTo(root.getData()) == 0) {
            return root;
        }
        else if (data.compareTo(root.getData()) <= 0) {
            return searchHelper(root.getLeft(), data);
        } else {
            return searchHelper(root.getRight(), data);
        }

    }

    
    private TNode<T> findMin(TNode<T> root) {
        root = root.getRight();
        while(root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }

    private TNode<T> findMax(TNode<T> root) {
        root = root.getLeft();
        while(root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    // Traversal methods
    

    public void printInOrder() {
        printHelper(root);
    }

    protected void printHelper(TNode<T> root) {
        if (root != null) {
            printHelper(root.getLeft());
            System.out.println(root.getData());
            printHelper(root.getRight());
        }
    }

    public void printBF() {
        if (this.root == null) {
            return;
        }
    
        QueueLL<TNode<T>> queue = new QueueLL<TNode<T>>();
        queue.enqueue(this.root);
        
    
        while (!queue.isEmpty()) {
            TNode<T> curr = queue.dequeue();
            if (curr == null) {
                continue;
            }
            System.out.println(curr.getData());
            if (curr.getLeft() != null) {
                queue.enqueue(curr.getLeft());
            }
            if (curr.getRight() != null) {
                queue.enqueue(curr.getRight());
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    // Private helper methods
    public TNode<T> breadthFirstSearch(T root) {
        QueueLL<TNode<T>> queue = new QueueLL<TNode<T>>();
        queue.enqueue(this.root);

        TNode<T> curr = null;
        while (queue.getSize() > 0) {
            curr = queue.dequeue();
            System.out.println(curr.getData());
            if (curr.getData().compareTo(root) == 0) {
                return curr;
            }
            if (curr.getLeft() != null) {
                queue.enqueue(curr.getLeft());
            }
            if (curr.getRight() != null) {
                queue.enqueue(curr.getRight());
            }
        }
        return null;
    }
}
