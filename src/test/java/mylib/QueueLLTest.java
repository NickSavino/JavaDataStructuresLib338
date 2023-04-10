package mylib;

import org.junit.Test;

import mylib.datastructures.linear.QueueLL;

import static org.junit.Assert.*;

public class QueueLLTest {

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
    public void testPeek() {
        QueueLL<Integer> queue = new QueueLL<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals((Integer) 1, queue.peek());
        assertEquals((Integer) 1, queue.peek());
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

    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedOperationException() {
        QueueLL<Integer> queue = new QueueLL<>();

        queue.insertHead(1);
    }
}
