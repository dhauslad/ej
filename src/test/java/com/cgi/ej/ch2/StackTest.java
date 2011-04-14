package com.cgi.ej.ch2;

import static org.junit.Assert.*;

import java.text.NumberFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private ArrayStack<String> stack;
    final NumberFormat nf = NumberFormat.getInstance();

    @Before
    public void setUp() throws Exception {
        stack = new ArrayStack<String>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public final void testStack() {
        assertNotNull(stack);
    }

    @Test
    public final void testPush() {
        assertEquals(0, stack.size());
        stack.push("A");
        assertEquals(1, stack.size());
        stack.push("B");
        assertEquals(2, stack.size());
    }

    @Test
    public final void testPop() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals(3, stack.size());

        Object c = stack.pop();
        assertEquals("C", c);
        assertEquals(2, stack.size());

        Object b = stack.pop();
        assertEquals("B", b);
        assertEquals(1, stack.size());

        Object a = stack.pop();
        assertEquals("A", a);
        assertEquals(0, stack.size());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, stack.size());
    }

    @Test
    public void testMemoryUsage() throws Exception {
        final int iterations = 1000000;

        for (int i = 0; i < iterations; i++) {
            stack.push(String.valueOf(i));
        }
        assertEquals(iterations, stack.size());

        for (int i = 0; i < iterations; i++) {
            stack.pop();
        }
        assertEquals(0, stack.size());

        int leakedReferences = 0;
        for (String item : stack.getIdleCapacity()) {
        	if (item != null) {
        		leakedReferences++;
        	}
        }
        
        assertEquals("Oops! You've leaked references in the stack.  ", 0, leakedReferences);
    }
}
