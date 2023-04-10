package mylib;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import static org.junit.Assert.*;

import mylib.datastructures.nodes.DNode;

public class DNodeTest {
    
    @Test
    public void testConstructorTypes() {
        DNode<Integer> node = new DNode<Integer>();
        DNode<String> node2 = new DNode<String>();
        DNode<ArrayList<Boolean>> node3 = new DNode<ArrayList<Boolean>>();
        DNode<HashMap<String, Integer>> node4 = new DNode<HashMap<String, Integer>>();
    }

    @Test
    public void testConstructorWithArgument() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<String> node2 = new DNode<String>("hello");

        assertEquals(1, node.get().intValue());
        assertEquals("hello", node2.get());
    }

    @Test
    public void testSet() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<String> node2 = new DNode<String>("hello");

        node.set(2);
        node2.set("world");

        assertEquals(2, node.get().intValue());
        assertEquals("world", node2.get());
    }

    @Test
    public void testGet() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<String> node2 = new DNode<String>("hello");

        assertEquals(1, node.get().intValue());
        assertEquals("hello", node2.get());
    }

    @Test
    public void testNextPrev() {
        DNode<Integer> node1 = new DNode<Integer>(1);
        DNode<Integer> node2 = new DNode<Integer>(2);
        DNode<Integer> node3 = new DNode<Integer>(3);

        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);

        assertNull(node1.getPrev());
        assertEquals(node2, node1.getNext());
        assertEquals(node1, node2.getPrev());
        assertEquals(node3, node2.getNext());
        assertEquals(node2, node3.getPrev());
        assertNull(node3.getNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCompareToNonComparable() {
        DNode<ArrayList<Boolean>> node1 = new DNode<ArrayList<Boolean>>(new ArrayList<Boolean>());
        DNode<ArrayList<Boolean>> node2 = new DNode<ArrayList<Boolean>>(new ArrayList<Boolean>());
        node1.compareTo(node2);
    }

    @Test
    public void testCompareToWithNullData() {

        
        DNode<Integer> node1 = new DNode<Integer>(1);
        DNode<Integer> node2 = new DNode<Integer>();
        DNode<Integer> node3 = new DNode<Integer>();

        assertEquals(1, node1.compareTo(node2));
        assertEquals(0, node2.compareTo(node3));
        assertEquals(-1, node2.compareTo(node1));
    }
}
