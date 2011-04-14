package com.cgi.ej.ch2;

import java.util.EmptyStackException;

class LinkedStack <T> implements Stack<T> {
    private StackElement head = null;
    private int size = 0;
    
	LinkedStack() {
        ;
    }
		
    public void push(T t) {
        size++;
        head = new StackElement(head, t);
    }
		
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        T value = head.get();
        head = head.next();
        return value;
    }
    
	public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.get();
    }
    
	public boolean isEmpty() {
        return (head == null);
    }
    
	public int size() {
        return size;
    }
    
	public String toString() {
        StringBuilder sb = new StringBuilder("Stack(");
        sb.append(size).append("):[");
        StackElement temp = head;
        while (temp != null) {
            sb.append(temp.get());
            if (temp.next() != null) {
                sb.append(", ");
            }
            temp = temp.next();
        }
        sb.append("]");
        return sb.toString();
    }
    
	private class StackElement {
        private StackElement next = null;
        private T value = null;
        StackElement(StackElement next, T value) {
            this.next = next;
            this.value = value;
        }
        T get() {
            return value;
        }
        StackElement next() {
            return next;
        }
    }
}
