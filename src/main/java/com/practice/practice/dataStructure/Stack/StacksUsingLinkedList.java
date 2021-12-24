package com.practice.practice.dataStructure.Stack;

public class StacksUsingLinkedList {

	private Node top;
	private Node bottom;
	private int length;

	public StacksUsingLinkedList() {

		this.top = null;
		this.bottom = null;
		length = 0;

	}

	public String peek() {
		if (length > 0) {

			return top.value;
		} else {

			return null;
		}
	}

	public void push(String value) {

		Node newNode = new Node(value);

		if (length == 0) {
			top = newNode;
			bottom = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		length++;

	}

	public void pop() {

		if (length > 0) {
			top = top.next;

			if (length == 1) {
				bottom = null;
			}

			length--;
		} else if (length == 0) {
			System.out.println("Stack is empty");
		}

	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public String getLastElement() {

		if (length > 0) {
			return bottom.value;
		} else {
			return null;
		}

	}

	public static void main(String[] args) {

		StacksUsingLinkedList myStack = new StacksUsingLinkedList();
		myStack.push("Google");
		myStack.push("Udemy");
		myStack.push("Discord");
		System.out.println(myStack.peek());
		myStack.pop();
		System.out.println(myStack.isEmpty());
		System.out.println(myStack.getLastElement());
		myStack.pop();
		myStack.pop();
		System.out.println(myStack.peek());
		System.out.println(myStack.isEmpty());
		System.out.println(myStack.getLastElement());

	}

}
