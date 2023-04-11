package mylib;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.BST;

public class BSTTest {
    

    @Test
    public void testDefaultConstructor() {
        BST<Integer> tree = new BST<>();
        assertEquals(0, tree.getSize());
        assertNotNull(tree);
        assertNull(tree.getRoot());
    }

    @Test
    public void testConstructorWithRoot() {
        BST<Integer> tree = new BST<>(5);
        assertEquals(1, tree.getSize());
        assertNotNull(tree);
        assertNotNull(tree.getRoot());
        assertEquals(5, tree.getRoot().getData().intValue());
    }

    @Test
    public void testConstructorWithNode() {
        BST<Integer> tree = new BST<>(new TNode<Integer>(5));
        assertEquals(1, tree.getSize());
        assertNotNull(tree);
        assertNotNull(tree.getRoot());
        assertEquals(5, tree.getRoot().getData().intValue());
    }

    /**
     * Test of getRoot method, of class BST.
     *  - Test that the root is not null
     *  - Test that the root is not the same object as the root of the tree (Deep Copy)
     */
    @Test
    public void testGetRoot() {
        int data = 5;
        BST<Integer> tree = new BST<>(data);
        TNode<Integer> root = tree.getRoot();
        assertNotNull(root);
        assertNotEquals(data, tree);
        assertEquals(5, root.getData().intValue());
    }

    /**
     * Test of insert method, of class BST.
     *  - Test that the size of the tree increases by 1
     *  - Test that the root is not null
     */
    @Test
    public void testInsert() {
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        assertEquals(1, tree.getSize());
        assertNotNull(tree.getRoot());
    }

    @Test
    public void testInsertionMany() {
        BST<Integer> tree = new BST<>();
        for (int i = 0; i < 25; i++) {
            tree.insert(i);
        }
        assertEquals(25, tree.getSize());
        assertNotNull(tree.getRoot());        
        tree.printInOrder();

        
    }

    @Test
    public void testDelete() { 
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        

        tree.delete(3);
        tree.printInOrder();
        assertEquals(7, tree.getSize());
        assertNull(tree.search(3));
        assertNotNull(tree.getRoot());
    }

    @Test
    public void testDeleteNonExistentNode() {
        BST<Integer> tree = new BST<>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);

        tree.delete(8); // trying to delete a non-existent node
        assertEquals("Size should remain unchanged", 3, tree.getSize());
        
    }

    
    @Test
    public void testPrintBF() {
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.printBF();

        String expectedOutput = "5\n3 7\n2 4 6 8";
        assertEquals(expectedOutput, outContent.toString());
    }
}
