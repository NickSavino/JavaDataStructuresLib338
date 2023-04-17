package mylib;

import org.junit.Test;

import mylib.datastructures.linear.QueueLL;

import static org.junit.Assert.*;

public class QueueLLTest {

    @Test
    public void testEnqueueDequeueSingleElement() {
        QueueLL<Integer> queue = new QueueLL<>();

        queue.enqueue(1);
        assertEquals((Integer) 1, queue.dequeue());
        assertTrue(queue.isEmpty());
    }


    @Test
    public void testEnqueueDequeue() {
        QueueLL<Integer> queue = new QueueLL<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals((Integer) 1, queue.dequeue());
        assertFalse(((boolean)queue.isEmpty()));
        assertEquals((Integer) 2, queue.dequeue());
        assertEquals((Integer) 3, queue.dequeue());
    }

    @Test
    public void testEnqueueDequeueNull() {
        QueueLL<Integer> queue = new QueueLL<>();

        queue.enqueue(null);
        assertNull(queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeek() {
        QueueLL<Integer> queue = new QueueLL<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals((Integer) 1, queue.peek());
        assertEquals((Integer) 1, queue.peek());
    }

    @Test
    public void testSize() {
        QueueLL<Integer> queue = new QueueLL<>();

        assertEquals(0, queue.getSize());

        queue.enqueue(1);
        assertEquals(1, queue.getSize());

        queue.enqueue(2);
        assertEquals(2, queue.getSize());

        queue.dequeue();
        assertEquals(1, queue.getSize());
    }


    @Test
    public void testIsEmpty() {
        QueueLL<Integer> queue = new QueueLL<>();

        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testClear() {
        QueueLL<Integer> queue = new QueueLL<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertFalse(queue.isEmpty());
        queue.clear();
        assertTrue(queue.isEmpty());
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedOperationException() {
        QueueLL<Integer> queue = new QueueLL<>();

        queue.insertHead(1);
    }
}
