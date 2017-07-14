package edu.cornell.sneha;

public class MyStack<T> {
	private Node<Person> top;
	private int length;

	public void push(Person p) {
		top = new Node<Person>(p, top);
		length++;
	}

	public Person pop() {
		if (!isEmpty()) {
			Person temp = top.getData();
			top = top.getNext();
			length--;
			return temp;
		} else {
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
