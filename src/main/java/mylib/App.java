package mylib;

import mylib.datastructures.trees.BST;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<Integer>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
    
        System.out.println("Breadth First Traversal (Level Order Traversal):");
        bst.printBFQueue();
    }

}
