package com.cgi.ej.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

// Can you spot the "memory leak"?
public class BrokenStack <T> implements Stack<T> {
	private T[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	BrokenStack() {
		elements = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(T e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public T pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		T element = elements[--size];
		return element;
	}
	
	public T peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return elements[--size];
	}
	
	public boolean isEmpty() {
		return (size > 0);
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder("Stack(");
        sb.append(size).append("):[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (1 + i < size) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

	
	/**
	* Ensure space for at least one more element, roughly
	* doubling the capacity each time the array needs to grow.
	*/
	private void ensureCapacity() {
		if (elements.length == size)
		elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	List<T> getIdleCapacity() {
		List<T> capacity = new ArrayList<T>(elements.length - size);
		for(int i = size; i < elements.length; i++) {
			capacity.add(elements[i]);
		}
		return capacity;
	}
}
