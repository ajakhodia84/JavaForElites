package com.practice.practice.dataStructure.linkedList.DoubliLinkedList;

import java.util.Arrays;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int length;

	public DoublyLinkedList(int value) {

		head = new Node(value);
		tail = head;
		length = 1;

	}

	public void append(int value) {

		Node newNode = new Node(value);
		newNode.previous = tail;
		tail.next = newNode;
		tail = newNode;
		length++;

	}

	public void prepend(int value) {

		Node newNode = new Node(value);
		head.previous = newNode;
		newNode.next = head;
		head = newNode;
		length++;

	}

	public int getLength() {

		return length;
	}

	public void insert(int index, int value) {

		if (index < 0 || index > length) {

			System.out.println("Index Out Of Bounds For Length " + length);

		} else if (index == 0) {

			prepend(value);

		} else if (index == length) {

			append(value);

		} else {

			Node current = head;
			for (int i = 0; i < index - 1; i++) {

				current = current.next;

			}

			Node newNode = new Node(value);
			newNode.next = current.next;
			current.next = newNode;
			newNode.previous=current;
			newNode.next.previous=newNode;
			length++;

		}

	}

	public void remove(int index) {

		if (index < 0 || index > length) {

			System.out.println("Index Out Of Bounds For Length " + length);

		} else if (index == 0) {

			head=this.head.next;
			this.head.previous=null;
			length--;

		} else {

			Node current = head;
			int i;
			for  (i = 0; i < index - 1; i++) {

				current = current.next;

			}

			current.next=current.next.next;
			length--;
			
			if(i==length-1){
				
				tail=current;
				
			} else {
				
				current.next.previous=current;
				
			}
			

		}

	}

	public int[] printList() {

		int[] array = new int[length];
		Node current = this.head;
		int i = 0;
		while (current != null) {

			array[i] = current.value;
			current = current.next;
			i++;

		}
		System.out.println(Arrays.toString(array));
		return array;
	}

	public static void main(String[] args) {

		DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList(5);
		myDoublyLinkedList.append(30);
		myDoublyLinkedList.append(40);
		System.out.println("length: " + myDoublyLinkedList.getLength());
		System.out.print("Linked list: ");
		myDoublyLinkedList.printList();

		myDoublyLinkedList.prepend(100);
		myDoublyLinkedList.prepend(200);
		System.out.println("length: " + myDoublyLinkedList.getLength());
		System.out.print("Linked list: ");
		myDoublyLinkedList.printList();

		myDoublyLinkedList.insert(2, 25);
		System.out.println("length: " + myDoublyLinkedList.getLength());
		System.out.print("Linked list: ");
		myDoublyLinkedList.printList();

		myDoublyLinkedList.insert(0, 35);
		System.out.println("length: " + myDoublyLinkedList.getLength());
		System.out.print("Linked list: ");
		myDoublyLinkedList.printList();

		myDoublyLinkedList.insert(7, 45);
		System.out.println("length: " + myDoublyLinkedList.getLength());
		System.out.print("Linked list: ");
		myDoublyLinkedList.printList();
		
		myDoublyLinkedList.remove(1);
		System.out.println("length: " + myDoublyLinkedList.getLength());
		System.out.print("Linked list: ");
		myDoublyLinkedList.printList();

	}

}
