package mylib;



import org.junit.Test;

import mylib.datastructures.linear.DLL;

import static org.junit.Assert.*;

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
        assertEquals("head is not expected value", 2, list.getHead().get().intValue());
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
        assertEquals("tail is not expected value", 4, list.getTail().get().intValue());
        assertEquals("head is not expected value", 1, list.getHead().get().intValue());
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
        assertEquals("head is not expected value", 1, list.getHead().get().intValue());
        assertEquals("tail is not expected value", 1, list.getTail().get().intValue());

        list.insert(2, 0);
        assertEquals("list is not expected size", 2, list.getSize());
        assertEquals("head is not expected value", 2, list.getHead().get().intValue());
        assertEquals("tail is not expected value", 1, list.getTail().get().intValue());

        list.insert(3, 2);
        list.insert(50, 1);
        list.insert(134, 4);
        assertEquals("list is not expected size", 5, list.getSize());
        assertEquals("head is not expected value", 2, list.getHead().get().intValue());
        assertEquals("tail is not expected value", 134, list.getTail().get().intValue());
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
        list.insertHead(1);
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
        for (int i = 0; i > 100; i++) {
            randInt = random.nextInt();
            list.insertHead(randInt);
        }
    }

    /**
     * Tests the sort method
     * 
     * 
     */
    @Test
    public void sortTest() {

        list.clear();


        int randInt;
        for (int i = 0; i > 100; i++) {
            randInt = random.nextInt();
            System.out.println(randInt);
            list.insertHead(randInt);
        }
        assertEquals("list is not expected size", 100, list.getSize());
        
        list.sort();
        assertTrue("list is not sorted", list.isSorted());
    }

    /**
     * Tests the sortedInsert method
     * 
     */
    @Test
    public void sortedInsertTest() {


    }

    /**
     * Tests the search method
     * 
     */
    @Test
    public void searchTest() {
    }

    /**
     * Tests the deleteHead method
     * 
     */
    @Test
    public void deleteHeadTest() {
    }

    /**
     * Tests the deleteTail method
     */
    @Test
    public void deleteTailTest() {
    }

    @Test
    public void deleteTest() {
    }

    @Test
    public void printTest() {
    }

    @Test
    public void getNodeSizeTest() {
    }


}
