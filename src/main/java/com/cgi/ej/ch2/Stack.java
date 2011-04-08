package com.cgi.ej.ch2;

import java.util.Arrays;
import java.util.EmptyStackException;

// Can you spot the "memory leak"?
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
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
        Object result = this.elements[--this.size];
        this.elements[this.size] = null; // Eliminate obsolete reference
        return result;
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
