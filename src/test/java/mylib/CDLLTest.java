package mylib;

import mylib.datastructures.linear.CDLL;
import org.junit.Test;

import static org.junit.Assert.*;



public class CDLLTest {



    @Test
    public void testInsertHead() {
        CDLL<Integer> list = new CDLL<>();
        list.insertHead(5);
        list.insertHead(3);
        list.insertHead(7);
        assertEquals(3, list.getSize());
        assertEquals(Integer.valueOf(7), list.getHead().getData());
        assertEquals(Integer.valueOf(5), list.getTail().getData());
    }

    @Test
    public void testInsertTail() {
        CDLL<Integer> list = new CDLL<>();
        list.insertTail(5);
        list.insertTail(3);
        list.insertTail(7);
        assertEquals(3, list.getSize());
        assertEquals(Integer.valueOf(5), list.getHead().getData());
        assertEquals(Integer.valueOf(3), list.getHead().getNext().getData());
        assertEquals(Integer.valueOf(7), list.getTail().getData());
    }

    @Test
    public void testDeleteHead() {
        CDLL<Integer> list = new CDLL<>();
        list.insert(5, 0);
        list.insert(3, 1);
        list.insert(7, 2);
        list.deleteHead();
        assertEquals(2, list.getSize());
        assertEquals(Integer.valueOf(3), list.getHead().getData());
        assertEquals(Integer.valueOf(7), list.getTail().getData());
    }

    @Test
    public void testDeleteTail() {
        CDLL<Integer> list = new CDLL<>();
        list.insert(5, 0);
        list.insert(3, 1);
        list.insert(7, 2);
        list.deleteTail();
        assertEquals(2, list.getSize());
        assertEquals(Integer.valueOf(5), list.getHead().getData());
        assertEquals(Integer.valueOf(3), list.getTail().getData());
    }

    @Test
    public void testDelete() {
        CDLL<Integer> list = new CDLL<>();
        list.insert(5, 0);
        list.insert(3, 1);
        list.insert(7, 2);
        list.delete(3);
        assertEquals(2, list.getSize());
        assertEquals(Integer.valueOf(5), list.getHead().getData());
        assertEquals(Integer.valueOf(7), list.getTail().getData());
    }

    @Test
    public void testIsSorted() {
        CDLL<Integer> sortedList = new CDLL<>();
        sortedList.insert(1, 0);
        sortedList.insert(2, 1);
        sortedList.insert(3, 2);
        assertTrue(sortedList.isSorted());

        CDLL<Integer> unsortedList = new CDLL<>();
        unsortedList.insert(2, 0);
        unsortedList.insert(1, 1);
        unsortedList.insert(3, 2);
        assertFalse(unsortedList.isSorted());
    }


    @Test
    public void testInsert() {
        CDLL<Integer> list = new CDLL<>();
        list.insert(5, 0);
        list.insert(3, 1);
        list.insert(7, 2);
        assertEquals(3, list.getSize());
        assertEquals(Integer.valueOf(5), list.getHead().getData());
        assertEquals(Integer.valueOf(3), list.getHead().getNext().getData());
        assertEquals(Integer.valueOf(7), list.getTail().getData());
    }


}


