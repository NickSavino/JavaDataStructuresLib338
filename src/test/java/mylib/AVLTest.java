package mylib;


import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.AVL;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AVLTest {
    private AVL<Integer> avl;

    @Before
    public void setUp() {
        avl = new AVL<>();
    }

    @Test
    public void testInsert() {
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(1);
        avl.insert(4);

        assertEquals(Integer.valueOf(5), avl.getRoot().getData());
        assertEquals(Integer.valueOf(3), avl.getRoot().getLeft().getData());
        assertEquals(Integer.valueOf(7), avl.getRoot().getRight().getData());
        assertEquals(Integer.valueOf(1), avl.getRoot().getLeft().getLeft().getData());
        assertEquals(Integer.valueOf(4), avl.getRoot().getLeft().getRight().getData());
    }

    @Test
    public void testRightRotation() {
        avl = new AVL<>();

        avl.insert(3);
        avl.insert(2);
        avl.insert(1);
    
        assertEquals(Integer.valueOf(2), avl.getRoot().getData());
        assertEquals(Integer.valueOf(1), avl.getRoot().getLeft().getData());
        assertEquals(Integer.valueOf(3), avl.getRoot().getRight().getData());
    }
    
    @Test
    public void testLeftRotation() {
        avl = new AVL<>();

        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
    
        assertEquals(Integer.valueOf(2), avl.getRoot().getData());
        assertEquals(Integer.valueOf(1), avl.getRoot().getLeft().getData());
        assertEquals(Integer.valueOf(3), avl.getRoot().getRight().getData());
    }
    
    @Test
    public void testLeftRightRotation() {
        avl = new AVL<>();

        avl.insert(3);
        avl.insert(1);
        avl.insert(2);
    
        assertEquals(Integer.valueOf(2), avl.getRoot().getData());
        assertEquals(Integer.valueOf(1), avl.getRoot().getLeft().getData());
        assertEquals(Integer.valueOf(3), avl.getRoot().getRight().getData());
    }
    
    @Test
    public void testRightLeftRotation() {
        avl = new AVL<>();

        avl.insert(1);
        avl.insert(3);
        avl.insert(2);
    
        assertEquals(Integer.valueOf(2), avl.getRoot().getData());
        assertEquals(Integer.valueOf(1), avl.getRoot().getLeft().getData());
        assertEquals(Integer.valueOf(3), avl.getRoot().getRight().getData());
    }

    @Test
    public void testDelete() {
        avl = new AVL<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(1);
        avl.insert(4);
        avl.insert(6);
        avl.insert(9);

        avl.delete(1);
        assertNull(avl.getRoot().getLeft().getLeft());

        avl.delete(5);
        assertEquals(Integer.valueOf(4), avl.getRoot().getData());
        assertEquals(Integer.valueOf(3), avl.getRoot().getLeft().getData());
    }

    @Test
    public void testDeleteBalancing() {
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);

        avl.delete(2);

        assertEquals(Integer.valueOf(4), avl.getRoot().getData());
        assertEquals(Integer.valueOf(1), avl.getRoot().getLeft().getData());
        assertEquals(Integer.valueOf(6), avl.getRoot().getRight().getData());
        assertEquals(Integer.valueOf(5), avl.getRoot().getRight().getLeft().getData());
    }

    
    @Test
    public void testPrintBF() {
        AVL<Integer> avl = new AVL<>();

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
    public void testPrintInOrder() {
        AVL<Integer> avl = new AVL<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);

        try {
            avl.printInOrder();
            System.out.println("printInOrder executed without any exceptions.");
        } catch (Exception e) {
            fail("printInOrder should execute without any exceptions.");
        }
    }

    @Test
    public void testSearch() {
        avl = new AVL<>();

        for (int i = 0; i < 100; i++) {
            avl.insert(i);
        }

        TNode<Integer> node = avl.search(50);
        assertEquals(Integer.valueOf(50), node.getData());

        node = avl.search(101);
        assertNull(node);
        
        node = avl.search(-1);
        assertNull(node);

        node = avl.search(0);
        assertEquals(Integer.valueOf(0), node.getData());

        node = avl.search(99);
        assertEquals(Integer.valueOf(99), node.getData());

        node = avl.search(100);
        assertNull(node);

    }
}
