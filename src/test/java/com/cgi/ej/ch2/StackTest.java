package com.cgi.ej.ch2;

import static org.junit.Assert.*;

import java.text.NumberFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack stack;
    final NumberFormat nf = NumberFormat.getInstance();

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
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

        long usedBefore = getUsedMemory("Before");

        for (int i = 0; i < iterations; i++) {
            stack.push(i);
        }
        assertEquals(iterations, stack.size());

        long usedAfterPush = getUsedMemory("After Push");

        System.out.printf("Increase in memory usage after pushing: %s bytes%n%n", nf.format(usedAfterPush - usedBefore));

        for (int i = 0; i < iterations; i++) {
            stack.pop();
        }
        assertEquals(0, stack.size());

        long usedAfterPop = getUsedMemory("After Pop");

        System.out.printf("Change in memory usage after popping: %s bytes%n", nf.format(usedAfterPop - usedAfterPush));
        System.out.printf("Total change in memory usage: %s bytes%n%n", nf.format(usedAfterPop - usedBefore));
    }

    private long getUsedMemory(String header) {
        Runtime runtime = Runtime.getRuntime();

        Tests.collectAllGarbage();

        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.printf("%s:%n", header);
        System.out.printf("Total: %s bytes%n", nf.format(totalMemory));
        System.out.printf("Used: %s bytes%n", nf.format(usedMemory));
        System.out.printf("Free: %s bytes%n", nf.format(freeMemory));
        System.out.println();

        return usedMemory;
    }
}
