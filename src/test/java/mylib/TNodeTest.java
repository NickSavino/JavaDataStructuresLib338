package mylib;

import mylib.datastructures.nodes.TNode;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TNodeTest {

    private TNode<Integer> node;

    @Before
    public void setUp() {
        node = new TNode<Integer>(10);
        assertNotNull("Constructor did not instantiate object", node);
    }

    @Test
    public void testGetData() {
        assertEquals("Data does not match expected value", (Integer) 10, node.getData());
    }

    @Test
    public void testSetData() {
        node.setData(20);
        assertEquals("Data does not match expected value", (Integer) 20, node.getData());
    }

    @Test
    public void testGetSetLeft() {
        TNode<Integer> leftChild = new TNode<Integer>(5);
        node.setLeft(leftChild);
        assertEquals("Left child does not match expected value", leftChild, node.getLeft());
    }

    @Test
    public void testGetSetRight() {
        TNode<Integer> rightChild = new TNode<Integer>(15);
        node.setRight(rightChild);
        assertEquals("Right child does not match expected value", rightChild, node.getRight());
    }

    @Test
    public void testGetSetParent() {
        TNode<Integer> parent = new TNode<Integer>(7);
        node.setParent(parent);
        assertEquals("Parent does not match expected value", parent, node.getParent());
    }

    @Test
    public void testGetSetBalance() {
        node.setBalance(1);
        assertEquals("Balance does not match expected value", 1, node.getBalance());
    }

    @Test
    public void testIsLeaf() {
        assertTrue("Node should be a leaf", node.isLeaf());
        node.setLeft(new TNode<Integer>(5));
        assertFalse("Node should not be a leaf", node.isLeaf());
    }

    @Test
    public void testIsRoot() {
        assertTrue("Node should be a root", node.isRoot());
        node.setParent(new TNode<Integer>(5));
        assertFalse("Node should not be a root", node.isRoot());
    }

    @Test
    public void testCompareTo() {
        TNode<Integer> smallerNode = new TNode<Integer>(5);
        TNode<Integer> equalNode = new TNode<Integer>(10);
        TNode<Integer> largerNode = new TNode<Integer>(15);

        assertTrue("Node should be greater than smallerNode", node.compareTo(smallerNode) > 0);
        assertEquals("Node should be equal to equalNode", 0, node.compareTo(equalNode));
        assertTrue("Node should be less than largerNode", node.compareTo(largerNode) < 0);
    }

}
