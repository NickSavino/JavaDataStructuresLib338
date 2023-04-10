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
        DNode<Boolean> node3 = new DNode<Boolean>();
    }

    @Test
    public void testConstructorWithArgument() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<String> node2 = new DNode<String>("hello");

        assertEquals(1, node.getData().intValue());
        assertEquals("hello", node2.getData());
    }

    @Test
    public void testSet() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<String> node2 = new DNode<String>("hello");

        node.setData(2);
        node2.setData("world");

        assertEquals(2, node.getData().intValue());
        assertEquals("world", node2.getData());
    }

    @Test
    public void testGet() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<String> node2 = new DNode<String>("hello");

        assertEquals(1, node.getData().intValue());
        assertEquals("hello", node2.getData());
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

    @Test
    public void testNextGetData() {
        DNode<Integer> node1 = new DNode<Integer>(1);
        DNode<Integer> node2 = new DNode<Integer>(2);
        DNode<Integer> node3 = new DNode<Integer>(3);

        node1.setNext(node2);
        node2.setNext(node3);

        assertEquals(2, node1.getNext().getData().intValue());
        assertEquals(3, node1.getNext().getNext().getData().intValue());
    }

    @Test
    public void testPrevGetData() {
        DNode<Integer> node1 = new DNode<Integer>(1);
        DNode<Integer> node2 = new DNode<Integer>(2);
        DNode<Integer> node3 = new DNode<Integer>(3);

        node1.setNext(node2);
        node2.setNext(node3);

        // Set previous nodes
        node2.setPrev(node1);
        node3.setPrev(node2);

        assertEquals(2, node3.getPrev().getData().intValue());
        assertEquals(1, node3.getPrev().getPrev().getData().intValue());
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
