package com.cgi.ej.ch2;

public interface Stack<T> {

        public void push(T t) ;

        public T pop();

        public T peek();

        public String toString();

        public boolean isEmpty();

        public int size();

}

