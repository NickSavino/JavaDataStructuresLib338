package mylib;

import mylib.datastructures.linear.CSLL;
import mylib.datastructures.nodes.DNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CSLLTest {

    @Test
    public void testInsertAtTail() {
        CSLL<Integer> list = new CSLL<>();

        list.insertTail(5);
        list.insertTail(10);
        list.insertTail(15);

        assertEquals(3, list.getSize());
        assertEquals(5, (int) list.getHead().get());
        assertEquals(15, (int) list.getTail().get());
    }

    @Test
    public void testInsertAtHead() {
        CSLL<String> list = new CSLL<>();

        list.insertHead("apple");
        list.insertHead("banana");
        list.insertHead("cherry");

        assertEquals(3, list.getSize());
        assertEquals("cherry", list.getHead().get());
        assertEquals("apple", list.getTail().get());
    }

    @Test
    public void testInsertAt() {
        CSLL<Integer> list = new CSLL<>();

        list.insert(0, 5);
        list.insert(1, 10);
        list.insert(1, 7);

        assertEquals(3, list.getSize());
        assertEquals(5, (int) list.getHead().get());
        assertEquals(10, (int) list.getTail().get());
    }

    @Test
    public void testDeleteHead() {
        CSLL<String> list = new CSLL<>();
        list.insertTail("apple");
        list.insertTail("banana");
        list.insertTail("cherry");

        list.deleteHead();

        assertEquals(2, list.getSize());
        assertEquals("banana", list.getHead().get());
        assertEquals("cherry", list.getTail().get());
    }

    @Test
    public void testDeleteTail() {
        CSLL<Integer> list = new CSLL<>();
        list.insertTail(5);
        list.insertTail(10);
        list.insertTail(15);

        list.deleteTail();

        assertEquals(2, list.getSize());
        assertEquals(5, (int) list.getHead().get());
        assertEquals(10, (int) list.getTail().get());
    }

    @Test
    public void testDeleteAt() {
        CSLL<Integer> list = new CSLL<>();
        list.insertTail(5);
        list.insertTail(10);
        list.insertTail(15);

        list.delete(1);

        assertEquals(2, list.getSize());
        assertEquals(5, (int) list.getHead().get());
        assertEquals(15, (int) list.getTail().get());
    }

    @Test
    public void testSearch() {
        CSLL<Integer> list = new CSLL<>();
        list.insertTail(5);
        list.insertTail(10);
        list.insertTail(15);

        Integer node = list.search(10);

        assertEquals(10, (int) node);
    }

    @Test
    public void testIsSorted() {
        CSLL<Integer> list = new CSLL<>();
        list.insertTail(5);
        list.insertTail(10);
        list.insertTail(15);

        assertTrue(list.isSorted());

        list.insertTail(3);

        assertFalse(list.isSorted());
    }
}
