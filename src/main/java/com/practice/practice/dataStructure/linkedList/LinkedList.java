package com.practice.practice.dataStructure.linkedList;

import java.util.Arrays;

//importing node class created seperately
import com.practice.practice.dataStructure.linkedList.Node;

public class LinkedList {

	private Node head;
	private Node tail;
	private int length;

	public LinkedList(int value) {

		head = new Node(value);
		tail = head;
		length = 1;

	}

	// append(value) method to add new node at the end in linked list
	public void append(int value) {

		Node newNode = new Node(value);
		tail.next = newNode;
		tail = newNode;
		length++;

	}

	// prepend(value) method to add new node at the begining in linked list
	public void prepend(int value) {

		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		length++;
	}

	// printList method will return all linkedList values in array to print
	public int[] printList() {

		int[] array = new int[length];
		int i = 0;
		Node head = this.head;
		while (head != null) {

			array[i] = head.value;
			head = head.next;
			i++;

		}

		return array;
	}

	// length() method to return number of element in linked list
	public int getLength() {

		return length;
	}

	/*
	 * insert(index, value) method to insert element with value at particular
	 * index. Considering index increases from 0 to length-1
	 */
	public void insert(int index, int value) {

		if (index < 0 || index > length) {

			System.out.println("Index out of bound for Lenght: " + index + ". No value added to LinkedList");

		} else if (index == 0) {

			prepend(value);

		} else if (index == length) {

			append(value);
		} else {

			Node currentNode = head;

			for (int i = 0; i < index - 1; i++) {

				currentNode = currentNode.next;

			}
			Node newNode = new Node(value);
			newNode.next = currentNode.next;
			currentNode.next = newNode;
			length++;

		}

	}

	// remove(index) function to remove any value at given index
	public void remove(int index) {

		if (index < 0 || index > length - 1) {

			System.out.println("Index out of bound for Lenght: " + index + ". No value removed to LinkedList");

		} else if (index == 0) {

			head = this.head.next;
			length--;

		} else {

			Node currentNode = head;
			int i;
			for (i = 0; i < index - 1; i++) {

				currentNode = currentNode.next;

			}

			currentNode.next = currentNode.next.next;
			length--;

			if (i == length - 1) {
				tail = currentNode;
			}

		}

	}

	// reverse(LinkedList) function will return the linkedList in reversed
	// format
	public static LinkedList reverse(LinkedList linkedList) {

		LinkedList newList = new LinkedList(linkedList.head.value);
		Node current = linkedList.head;

		/*System.out.println("length: " + newList.length);
		System.out.println("Reversed list: " + Arrays.toString(newList.printList()));*/

		while (current.next != null) {

			current = current.next;
			Node newNode = new Node(current.value);
			newNode.next = newList.head;
			newList.head = newNode;
			newList.length++;

			/*System.out.println("length: " + newList.length);
			System.out.println("Reversed list: " + Arrays.toString(newList.printList()));*/
		}

		return newList;

	}

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList(10);

		// append
		linkedList.append(20);
		linkedList.append(30);
		linkedList.append(40);

		// print
		System.out.println("length: " + linkedList.getLength());
		System.out.println("list: " + Arrays.toString(linkedList.printList()));

		// prepend
		linkedList.prepend(100);
		linkedList.prepend(200);
		System.out.println("length: " + linkedList.getLength());
		System.out.println("list: " + Arrays.toString(linkedList.printList()));

		linkedList.insert(2, 25);
		System.out.println("length: " + linkedList.getLength());
		System.out.println("list: " + Arrays.toString(linkedList.printList()));

		linkedList.remove(2);
		System.out.println("length: " + linkedList.getLength());
		System.out.println("list: " + Arrays.toString(linkedList.printList()));

		linkedList.insert(2, 25);
		System.out.println("length: " + linkedList.getLength());
		System.out.println("list: " + Arrays.toString(linkedList.printList()));

		linkedList.reverse(linkedList);
		System.out.println("length: " + reverse(linkedList).length);
		System.out.println("Reversed list: " + Arrays.toString(reverse(linkedList).printList()));
	}

}
