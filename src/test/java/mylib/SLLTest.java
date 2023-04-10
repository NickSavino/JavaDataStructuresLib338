package mylib;

import mylib.datastructures.linear.SLL;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SLLTest {


    private SLL<Integer> list;

    @Before
    public void setUp() {
        SLL<Integer> list = new SLL<Integer>();
        assertNotNull("Constructor did not instantiate Object", list);
    }


    @Test
    public void insertHeadTest() {
        System.out.println("insertHeadTest " + this.list);
        list = new SLL<Integer>();

        list.insertHead(1);
        assertEquals(1, list.getSize());
        list.insertHead(2);
        assertEquals(2, list.getSize());
        String errorString = "Value at head Does not match expected value";
        int head = list.getHead().get();
        assertEquals(errorString, 2, head);
    }

    @Test
    public void insertTailTest() {
    }

    @Test
    public void insertTest() {
    }

    @Test
    public void sortedInsertTest() {
    }

    @Test
    public void searchTest() {
    }

    @Test
    public void deleteHeadTest() {
    }

    @Test
    public void deleteTailTest() {
    }

    @Test
    public void deleteTest() {
    }

    @Test
    public void sortTest() {
    }

    @Test
    public void clearTest() {
    }

    @Test
    public void printTest() {
    }

    @Test
    public void getNodeSizeTest() {
    }

    @Test
    public void isSortedTest() {
    }

}
