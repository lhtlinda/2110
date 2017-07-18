package edu.cornell.sneha;

public class MyStack<T> {
	private Node<T> top;
	private int length;

	public void push(T i) {
		top = new Node<T>(i, top);
		length++;
	}

	public T pop() {
		if (!isEmpty()) {
			T temp = top.getData();
			top = top.getNext();
			length--;
			return temp;
		} else {
			System.out.println("Stack is empty!");
			return null;
		}
	}
	
	public T peek(){
		if(!isEmpty())
			return top.getData();
		else{
			System.out.println("Stack is empty!");
			return null;
		}
	}

	public int getLength() {
		return this.length;
	}

	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public MyStack(int n) {
		length = 0;
	}

	public MyStack() {
		this(0);
	}

}
