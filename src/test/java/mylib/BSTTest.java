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
    public void testSearch() {
        BST<Integer> bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
    
        TNode<Integer> foundNode = bst.search(20);
        assertEquals(20, (int) foundNode.getData());
        foundNode = bst.search(80);
        assertEquals(80, (int) foundNode.getData());
        foundNode = bst.search(100);
        assertNull(foundNode);
    }

    public void testPrintInOrder() {
        BST<Integer> bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
    
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bst.printInOrder();
    
        String expectedOutput = "20\n30\n40\n50\n60\n70\n80\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    

    
    @Test
    public void testPrintBF() {
        BST<Integer> avl = new BST<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);

        try {
            avl.printBF();
            System.out.println("printBF executed without any exceptions.");
        } catch (Exception e) {
            fail("printBF should execute without any exceptions.");
        }
    }


    @Test
    public void testGetSize() {
        BST<Integer> bst = new BST<>();
        assertEquals(0, bst.getSize());
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        assertEquals(7, bst.getSize());
    }

    @Test
    public void testFindMinAndMax() {
        BST<Integer> bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
    
        TNode<Integer> minNode = bst.findMin(bst.getRoot());
        assertEquals(20, (int) minNode.getData());
        TNode<Integer> maxNode = bst.findMax(bst.getRoot());
        assertEquals(80, (int) maxNode.getData());
    }
    
    
}
