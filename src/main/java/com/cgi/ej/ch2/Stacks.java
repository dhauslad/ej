package com.cgi.ej.ch2;

public final class Stacks {

	private Stacks() {
		; // prevent extension and similarly calling of constructor.
	}

	public <T> Stack<T> newLinkedStack() {
		return new LinkedStack<T>();
	}

	public <T> Stack<T> newArrayStack() {
		return new ArrayStack<T>();
	}
	
	public <T> Stack<T> newBrokenStack() {
		return new BrokenStack<T>();
	}
	
}
