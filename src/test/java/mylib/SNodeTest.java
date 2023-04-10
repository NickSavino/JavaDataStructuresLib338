package mylib;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

import mylib.datastructures.nodes.SNode;

public class SNodeTest {
    
    @Test
    public void testConstructorTypes() {

        SNode<Integer> node = new SNode<Integer>();
        SNode<String> node2 = new SNode<String>();
        SNode<Boolean> node3 = new SNode<Boolean>();

    }


    @Test
    public void testConstructorWithArgument() {
        SNode<Integer> node = new SNode<Integer>(1);
        SNode<String> node2 = new SNode<String>("hello");
        SNode<Boolean> node3 = new SNode<Boolean>();

        assertEquals(1, node.getData().intValue());
        assertEquals("hello", node2.getData());
    }

    @Test
    public void testSet() {
        SNode<Integer> node = new SNode<Integer>(1);
        SNode<String> node2 = new SNode<String>("hello");

        node.setData(2);
        node2.setData("world");

        assertEquals(2, node.getData().intValue());
        assertEquals("world", node2.getData());
    }

    @Test
    public void testGet() {
        SNode<Integer> node = new SNode<Integer>(1);
        SNode<String> node2 = new SNode<String>("hello");

        assertEquals(1, node.getData().intValue());
        assertEquals("hello", node2.getData());
    }

    @Test
    public void testSetNextAndGetNext() {
        SNode<Integer> node1 = new SNode<Integer>(1);
        SNode<Integer> node2 = new SNode<Integer>(2);
        SNode<Integer> node3 = new SNode<Integer>(3);

        node1.setNext(node2);
        node2.setNext(node3);

        assertEquals(node2, node1.getNext());
        assertEquals(node3, node2.getNext());
    }

    @Test
    public void testCompareTo() {
        SNode<Integer> node1 = new SNode<Integer>(1);
        SNode<Integer> node2 = new SNode<Integer>(2);
        SNode<Integer> node3 = new SNode<Integer>(3);

        assertEquals(-1, node1.compareTo(node2));
        assertEquals(0, node2.compareTo(node2));
        assertEquals(1, node3.compareTo(node2));
    }

    @Test
    public void testCompareToWithNullData() {
        SNode<Integer> node1 = new SNode<Integer>(1);
        SNode<Integer> node2 = new SNode<Integer>();
        SNode<Integer> node3 = new SNode<Integer>();

        assertEquals(1, node1.compareTo(node2));
        assertEquals(-1, node2.compareTo(node1));
        assertEquals(0, node2.compareTo(node3));
    }
}
