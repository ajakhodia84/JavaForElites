package com.javaForElites.practice;

public class QueueArrayImp {

	int capacity;
	int queueArr[];
	int front;
	int rear;
	int currentSize;

	public QueueArrayImp(int sizeofQueue) {

		this.capacity = sizeofQueue;
		front = 0;
		rear = -1;
		queueArr = new int[this.capacity];
		currentSize = 0;
	}

	public void enQueue(int value) {
		if (isFull()) {
			System.out.println("hey, the queue is full, cannot insert any value to it");
		} else {
			rear++;
			if (rear == capacity - 1) {
				System.out.println(" The queue size is 1");
				//rear = 0;
			}
			queueArr[rear] = value;
			currentSize++;
			System.out.println(queueArr[rear] + " is inserted in queue");
		}
	}

	public void deQueue() {
		if (isEmpty()) {
			System.out.println("Hey, the queue is empty, cannot delete any element");
		} else {
			front++;
			if (front == capacity - 1) {
				System.out.println(queueArr[front - 1] + " is removed from the queue and queue size is 1");
				//front = 0;
			} else {
				System.out.println(queueArr[front - 1] + " is removed from the queue");
			}
			currentSize--;
		}
	}

	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (currentSize == capacity) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String arg[]){
		QueueArrayImp qAI=new QueueArrayImp(10);
		qAI.enQueue(10);
		//qAI.deQueue();
		qAI.enQueue(20);
		//qAI.deQueue();
		qAI.enQueue(30);
		qAI.enQueue(40);
		qAI.enQueue(50);
		qAI.deQueue();
		qAI.deQueue();
		qAI.deQueue();
		qAI.deQueue();
		qAI.deQueue();
		
	}

}
