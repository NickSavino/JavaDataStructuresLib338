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
        SNode<ArrayList<Boolean>> node3 = new SNode<ArrayList<Boolean>>();
        SNode<HashMap<String, Integer>> node4 = new SNode<HashMap<String, Integer>>();

    }


    @Test
    public void testConstructorWithArgument() {
        SNode<Integer> node = new SNode<Integer>(1);
        SNode<String> node2 = new SNode<String>("hello");
        SNode<ArrayList<Boolean>> node3 = new SNode<ArrayList<Boolean>>(new ArrayList<Boolean>());
        SNode<HashMap<String, Integer>> node4 = new SNode<HashMap<String, Integer>>(new HashMap<String, Integer>());

        assertEquals(1, node.get().intValue());
        assertEquals("hello", node2.get());
    }

    @Test
    public void testSet() {
        SNode<Integer> node = new SNode<Integer>(1);
        SNode<String> node2 = new SNode<String>("hello");

        node.set(2);
        node2.set("world");

        assertEquals(2, node.get().intValue());
        assertEquals("world", node2.get());
    }

    @Test
    public void testGet() {
        SNode<Integer> node = new SNode<Integer>(1);
        SNode<String> node2 = new SNode<String>("hello");

        assertEquals(1, node.get().intValue());
        assertEquals("hello", node2.get());
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

    @Test(expected = UnsupportedOperationException.class)
    public void testCompareToUnsupportedOperation() {
        SNode<Object> node1 = new SNode<Object>(new Object());
        SNode<Object> node2 = new SNode<Object>(new Object());

        node1.compareTo(node2);
    }

    @Test
    public void testCompareToWithNullData() {
        SNode<Integer> node1 = new SNode<Integer>(1);
        SNode<Integer> node2 = new SNode<Integer>(null);
        SNode<Integer> node3 = new SNode<Integer>(null);

        assertEquals(1, node1.compareTo(node2));
        assertEquals(-1, node2.compareTo(node1));
        assertEquals(0, node2.compareTo(node3));
    }
}
