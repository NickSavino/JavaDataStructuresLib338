package mylib;

import mylib.datastructures.linear.CDLL;
import org.junit.Test;

import static org.junit.Assert.*;



public class CDLLTest {

    @Test
    public void testInsert() {
        CDLL<Integer> list = new CDLL<>();
        list.insert(5, 0);
        list.insert(3, 1);
        list.insert(7, 2);
        assertEquals(3, list.getSize());
        assertEquals(Integer.valueOf(5), list.getHead());
        assertEquals(Integer.valueOf(3), list.getHead().getNext());
        assertEquals(Integer.valueOf(7), list.getTail());
    }

    @Test
    public void testDelete() {
        CDLL<Integer> list = new CDLL<>();
        list.insert(5, 0);
        list.insert(3, 1);
        list.insert(7, 2);
        list.delete(1);
        assertEquals(2, list.getSize());
        assertEquals(Integer.valueOf(5), list.search(5));
        assertEquals(Integer.valueOf(7), list.search(7));
    }

    @Test
    public void testIsSorted() {
        CDLL<Integer> list = new CDLL<>();
        list.insert(5, 0);
        list.insert(3, 1);
        list.insert(7, 2);
        assertEquals(false, list.isSorted());

        list.delete(2);
        assertEquals(true, list.isSorted());

        list.insert(9, 1);
        assertEquals(false, list.isSorted());
    }
}


