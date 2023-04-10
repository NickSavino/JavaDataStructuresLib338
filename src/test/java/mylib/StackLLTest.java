package mylib;

import org.junit.Test;

import mylib.datastructures.linear.StackLL;

import static org.junit.Assert.*;

import org.junit.Before;



public class StackLLTest {
    
    private StackLL<Integer> stack;

    @Before
    public void setUp() {
        stack = new StackLL<>();
    }

    @Test
    public void testPush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.getSize());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test(expected = IllegalAccessError.class)
    public void testPopOnEmptyStack() {
        stack.pop();
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(3, stack.getSize());
    }

    @Test(expected = IllegalAccessError.class)
    public void testPeekOnEmptyStack() {
        stack.peek();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);

        assertFalse(stack.isEmpty());
    }
}
