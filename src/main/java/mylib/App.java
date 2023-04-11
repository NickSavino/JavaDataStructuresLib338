package mylib;

import mylib.datastructures.trees.BST;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        BST<Integer> tree = new BST<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        tree.delete(3);
        tree.printInOrder();

        

    }

}
