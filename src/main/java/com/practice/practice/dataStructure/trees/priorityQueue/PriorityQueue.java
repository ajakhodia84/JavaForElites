package com.practice.practice.dataStructure.trees.priorityQueue;

import java.util.ArrayList;
import java.util.Arrays;

public class PriorityQueue {
	private final ArrayList<Node> queueArray = new ArrayList<>();
	private int length=0;

	// Node: the smaller number means higher priority
	public void enqueu(String value, int priority) {
		Node newNode = new Node(value, priority);
		boolean contain = false;

		for (int i = 0; i < queueArray.size(); i++) {
			if (queueArray.get(i).priority > newNode.priority) {
				queueArray.add(i, newNode);
				contain = true;
				length++;
				break;
			}
		}
		if (!contain) {
			queueArray.add(newNode);
			length++;
		}
	}
	
	public String dequeue(){
		
		if(queueArray.isEmpty()){
			return "empty array";
		} else {
			Node toRemove=queueArray.get(0);
			queueArray.remove(0);
			return toRemove.value;
		}
		
	}
	
	public Node front(){
		
		if(!queueArray.isEmpty()){
			return queueArray.get(0);
		}
		return null;
	}
	
	public Node rear(){
		if(!queueArray.isEmpty()){
			return queueArray.get(queueArray.size()-1);
		}
		return null;
	}
	
	public boolean isEmpty(){
		return queueArray.isEmpty();
	}
	
	public boolean isFull(){
		return (length==queueArray.size());
	}

	public String[] printQueue() {
		String[] array = new String[queueArray.size()];
		for (int i = 0; i < queueArray.size(); i++) {
			array[i] = queueArray.get(i).value;
		}
		return array;
	}

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue();
		queue.enqueu("anupam", 0);
		queue.enqueu("kavita", 2);
		queue.enqueu("dhaanvi", 4);
		queue.enqueu("yoga", 6);
		queue.enqueu("pawan", 8);
		queue.enqueu("kartik", 10);
		queue.enqueu("pulkit", 2);
		System.out.println(Arrays.toString(queue.printQueue()));
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.printQueue()));
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.printQueue()));
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.printQueue()));
        System.out.println(queue.front().value);
        System.out.println(queue.rear().value);
        System.out.println(queue.isEmpty());
	}

}
