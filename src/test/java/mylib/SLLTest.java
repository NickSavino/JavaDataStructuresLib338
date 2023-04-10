package mylib;

import mylib.datastructures.linear.SLL;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SLLTest {


    private SLL<Integer> list;

    @Before
    public void setUp() {
        list = new SLL<Integer>();
        assertNotNull("Constructor did not instantiate Object", list);
    }


    @Test
    public void insertHeadTest() {

        list.insertHead(1);
        assertEquals(1, list.getSize());
        list.insertHead(2);
        assertEquals(2, list.getSize());
        String errorString = "Value at head Does not match expected value";
        int head = list.getHead().getData();
        assertEquals(errorString, 2, head);
    }


    /**
     * Tests the sort method
     */
    @Test
    public void sortTest() {


    }

    @Test
    public void insertTailTest() {
        list.insertTail(1);
        assertEquals(1, list.getSize());
        list.insertTail(2);
        assertEquals(2, list.getSize());
        int tail = list.getTail().getData();
        assertEquals("Value at tail does not match expected value", 2, tail);
    }

    @Test
    public void insertTest() {
        list.clear();
        assertEquals("List is not empty", 0, list.getSize());
        list.insert(1, 0);
        list.print();
        list.insert(3, 1);
        list.print();
        list.insert(2, 1);
        list.print();
        System.out.println(list.getHead().getNext());
        assertEquals("Value at index 1 does not match expected value", (Integer) 2, list.getHead().getNext().getData());
    }

    @Test
    public void sortedInsertTest() {
        list.clear();
        list.sortedInsert(5);
        list.sortedInsert(3);
        list.sortedInsert(1);
        list.sortedInsert(4);
        list.sortedInsert(2);
        assertTrue("List is not sorted after sorted insert", list.isSorted());
    }

    @Test
    public void searchTest() {
        list.clear();
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);
        assertNotNull("Search did not find existing element", list.search(2));
        assertNull("Search found non-existent element", list.search(4));
    }

    @Test
    public void deleteHeadTest() {
        list.clear();
        list.insertHead(1);
        list.insertHead(2);
        list.deleteHead();
        assertEquals("Head not deleted", 1, list.getSize());
        assertEquals("Value at head does not match expected value", (Integer) 1, list.getHead().getData());
    }

    @Test
    public void deleteTailTest() {
        list.clear();
        list.insertTail(1);
        list.insertTail(2);
        list.deleteTail();
        assertEquals("Tail not deleted", 1, list.getSize());
        assertNull("Tail node not updated", list.getTail().getNext());
    }

    @Test
    public void deleteTest() {
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);
        list.delete(2);
        assertEquals("Node not deleted", 2, list.getSize());
        assertNull("Node not properly deleted", list.search(2));
        
    }

    @Test
    public void clearTest() {
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);
        list.clear();
        assertEquals("List not cleared", 0, list.getSize());
    }

    // Note: It's difficult to test the printTest() method since it involves standard output
    // and doesn't return a value. You can visually inspect the output to verify if it's correct.

    @Test
    public void getSizeTest() {
        list.clear();
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);
        assertEquals("Node size does not match expected value", 3, list.getSize());
    }

}
