package com.cgi.ej.ch2;

import java.util.Arrays;
import java.util.EmptyStackException;

// Can you spot the "memory leak"?
public class BrokenStack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public BrokenStack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        this.elements[this.size++] = e;
    }

    public Object pop() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        return this.elements[--this.size];
    }
    
    public int size() {
        return this.size;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (this.elements.length == this.size) {
            this.elements = Arrays.copyOf(this.elements, 2 * this.size + 1);
        }
    }
}
