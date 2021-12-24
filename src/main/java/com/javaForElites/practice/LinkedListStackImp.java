package com.javaForElites.practice;

import javax.xml.soap.Node;

public class LinkedListStackImp {

	Node head;

	LinkedListStackImp() {
		head = null;
	}

	class Node {
		int value;
		Node next;
	}

	public void push(int value) {
		Node extraHead = head;
		head = new Node();
		head.value = value;
		head.next = extraHead;
	}

	public Object pop() {
		Object value;
		if (!(head == null)) {

			value = head.value;
			head = head.next;

		} else {
			System.out.println("Stack is empty");
			value = null;
		}

		return value;
	}

	public static void printList(Node head) {

		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value + " ");
			temp = temp.next;
		}

	}

	public static void main(String[] args) {
		LinkedListStackImp llsi = new LinkedListStackImp();
		System.out.println(llsi.pop());
		llsi.push(10);
		llsi.push(20);
		llsi.push(30);
		llsi.push(40);
		llsi.push(50);
		llsi.push(60);
		llsi.push(70);
		System.out.println(llsi.pop());
		System.out.println(llsi.pop());

		llsi.push(170);
		System.out.println(llsi.pop());

		printList(llsi.head);

	}

}
