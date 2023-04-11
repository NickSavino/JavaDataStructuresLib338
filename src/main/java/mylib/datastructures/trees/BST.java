package mylib.datastructures.trees;

import mylib.datastructures.linear.QueueLL;
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
        return this.root == null ? null : this.root;
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

    /**
     * Helper method for deleting a node from the tree
     *  - if root is null, return null
     *  - 
     * @param root
     * @param data
     * @return
     */
    private TNode<T> deleteHelper(TNode<T> root, T data) {
        if (root == null) {
            return root;
            // if data <= root.data, go left
        } 
        
        if(data.compareTo(root.getData()) < 0) {
            root.setLeft(deleteHelper(root.getLeft(), data));
            //if data < root.data, go go left
        } 
        else if (data.compareTo(root.getData()) > 0) {
            root.setRight(deleteHelper(root.getRight(), data));
        } 
        else { //root is the node to be deleted
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            root.setData(findMin(root.getRight()).getData());

            root.setRight(deleteHelper(root.getRight(), root.getData()));
        }
        return root;
    }


    /**
     * Searches for a node in the tree
     * uses depth first search
     * @param data
     * @return
     */
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

    /**
     * Finds the minimum value in the tree
     * 
     * @param root
     * @return the minimum value in the tree
     */
    private TNode<T> findMin(TNode<T> root) {
        while(root.getLeft() != null) {
            root = root.getRight();
        }
        return root;
    }

    /**
     * Finds the maximum value in the tree
     * @param root
     * @return the maximum value in the tree
     */
    private TNode<T> findMax(TNode<T> root) {
        root = root.getLeft();
        while(root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    // Traversal methods

    public int getSize() {
        return this.size;
    }


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


    public void printBFQueue() {
        if (root == null) {
            return;
        }
    
        QueueLL<TNode<T>> queue = new QueueLL<TNode<T>>();
        queue.enqueue(root);
    
        while (!queue.isEmpty()) {
            int nodeCount = queue.getSize();
            while (nodeCount > 0) {
                TNode<T> curr = queue.dequeue();
                System.out.print(curr.getData() + " ");
                if (curr.getLeft() != null) {
                    queue.enqueue(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    queue.enqueue(curr.getRight());
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    public void printBF() {
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printLevel(root, i);
        }
    }

    /*
     * Prints a level of the tree
     */
    private void printLevel(TNode<T> root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.getData());
        } else if (level > 1) {
            printLevel(root.getLeft(), level - 1);
            printLevel(root.getRight(), level - 1);
        }
    }

    private int getHeight(TNode<T> root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftHeight = getHeight(root.getLeft());
            int rightHeight = getHeight(root.getRight());

            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }
    

    /**
     * Breadth first search
     *  - uses a queue to keep track of the nodes
     * @param root
     * @return
     */
    public TNode<T> breadthFirstSearch(TNode<T> root) {
        return null;
    }

}
