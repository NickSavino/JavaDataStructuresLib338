package mylib;



import org.junit.Test;

import mylib.datastructures.linear.DLL;
import mylib.datastructures.nodes.DNode;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.Before;

public class DLLTest {

    Random random;

    DLL<Integer> list;
    @Before
    public void setUp() {
        list = new DLL<Integer>();
        random = new Random();
        assertNotNull("Constructor did not instantiate Object", list);
    }

    @Test
    public void clearWhileEmptyTest() {
        list.clear();
        assertEquals("list is not expected size", 0, list.getSize());
    }



    @Test
    public void clearTest() {
        list.clear();
        for (int i = 0; i < 100; i++) {
            list.insertHead(i);
        }
        assertEquals("list is not expected size", 100, list.getSize());

        list.clear();
        assertEquals("list is not expected size", 0, list.getSize());
    }

    /**
     * Tests the insertHead method
     * Node size after test should be 2
     */
    @Test
    public void insertHeadTest() {
        list.clear();
        list.insertHead(1);
        list.insertHead(2);
        assertEquals("list is not expected size", 2, list.getSize());
        assertEquals("head is not expected value", 2, list.getHead().getData().intValue());
    }

    /**
     * Tests the insertTail method
     * Node size after test should be 4
     */
    @Test
    public void insertTailTest() {

        list.clear();
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);
        list.insertTail(4);
        assertEquals("list is not expected size", 4, list.getSize());
        assertEquals("tail is not expected value", 4, list.getTail().getData().intValue());
        assertEquals("head is not expected value", 1, list.getHead().getData().intValue());
    }

    /**
     * Tests the insert method
     * 
     */
    @Test
    public void insertTest() {
        list.clear();

        list.insert(1, 0);
        assertEquals("list is not expected size", 1, list.getSize());
        assertEquals("head is not expected value", 1, list.getHead().getData().intValue());
        assertEquals("tail is not expected value", 1, list.getTail().getData().intValue());

        list.insert(2, 0);
        assertEquals("list is not expected size", 2, list.getSize());
        assertEquals("head is not expected value", 2, list.getHead().getData().intValue());
        assertEquals("tail is not expected value", 1, list.getTail().getData().intValue());

        list.insert(3, 2);
        list.insert(50, 1);
        list.insert(134, 4);
        assertEquals("list is not expected size", 5, list.getSize());
        assertEquals("head is not expected value", 2, list.getHead().getData().intValue());
        assertEquals("tail is not expected value", 134, list.getTail().getData().intValue());
        assertEquals("value at index 1 is not expected value", 50, list.search(50).intValue());
    }

    /**
     * Tests the isSorted method
     * 
     * 
     */
    @Test
    public void isSortedTest() {
        list.clear();
        
        for (int i = 0; i < 10; i++) {
            list.insertTail(i);
        }
        assertEquals("list is not expected size", 10, list.getSize());
        assertTrue("list is not sorted", list.isSorted());
    }

    /**
     * Tests the isSorted method
     * 
     * Ensures the method returns false when the list is not sorted
     */
    @Test
    public void isNotSortedTest() {
        list.clear();
        
        int randInt;
        for (int i = 0; i < 100; i++) {
            randInt = random.nextInt();
            list.insertHead(randInt);
        }

        assertFalse(list.isSorted());
    }

    /**
     * Tests the sort method
     * 
     * 
     */
    @Test
    public void testSort() {
        list.clear();
        list.insertTail(3);
        list.insertTail(1);
        list.insertTail(4);
        list.insertTail(2);
        list.sort();
        DNode<Integer> curr = list.getHead();
        while (curr.getNext() != null) {
            assertTrue(curr.getData() <= curr.getNext().getData());
            curr = curr.getNext();
        }
    }

    @Test
    public void testSortRandomValues() {
        list.clear();
        int randInt;
        for (int i = 0; i < 25; i++) {
            randInt = random.nextInt();
            list.insertHead(randInt);
        }

        list.sort();
        DNode<Integer> curr = list.getHead();
        while (curr.getNext() != null) {
            assertTrue(curr.getData() <= curr.getNext().getData());
            curr = curr.getNext();
        }

        assertTrue(list.isSorted());
        
    }
    

    /**
     * Tests the sortedInsert method
     * 
     */
    @Test
    public void sortedInsertTest() {
        list.clear();
        assertTrue(list.isSorted());
        for (int i = 0; i < 25; i++) {
            int value = random.nextInt(1000);
            list.sortedInsert(value);
        }

        assertTrue(list.isSorted());

    }

    /**
     * Tests the search method
     * 
     */
    @Test
    public void searchTest() {
        list.clear();

        for (int i = 0; i < 100; i++) {
            list.insertTail(i);
        }

        int node = list.search(50);
        assertEquals("node is not expected value", 50, node);
        node = list.search(0);
        assertEquals("node is not expected value", 0, node);
        node = list.search(99);
        assertEquals("node is not expected value", 99, node);

    }

    /**
     * Tests the deleteHead method
     * 
     */
    @Test
    public void deleteHeadTest() {
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);

        list.deleteHead();
        assertEquals(2, (int) list.getHead().getData());

        list.deleteHead();
        assertEquals(1, (int) list.getHead().getData());

        list.deleteHead();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
    }

    /**
     * Tests the deleteTail method
     */
    @Test
    public void deleteTailTest() {
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);

        list.deleteTail();
        assertEquals(2, (int) list.getTail().getData());

        list.deleteTail();
        assertEquals(1, (int) list.getTail().getData());

        list.deleteTail();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
    }

/**
 * Tests the delete method
 * 
 */
@Test
public void deleteTest() {
    DLL<Integer> list = new DLL<Integer>();
    list.insertHead(1);
    list.insertTail(2);
    list.insertTail(3);
    list.insertTail(4);

    // Test deleting a node in the middle of the list
    list.delete(3);
    assertNull(list.search(3));

    // Test deleting the head node
    list.delete(1);
    assertNull(list.search(1));

    // Test deleting the tail node
    list.delete(4);
    assertNull(list.search(4));
}

    /**
     * Tests the print method
     * 
     */
    @Test
    public void printTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.insertTail(50);
        list.insertTail(33);
        list.insertTail(158);

        // Test printing the list

        list.print();
    }

    /**
     * Tests the getSize method
     * 
     */
    @Test
    public void getSizeTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.insertHead(1);
        list.insertTail(2);
        list.insertTail(3);
        list.insertTail(4);

        // Test getting the size of the list
        assertEquals(4, list.getSize());
    }


}
