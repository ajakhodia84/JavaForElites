package com.javaForElites.practice;

public class StackImp {

	int size;
	int array[];
	int top;

	StackImp(int size) {
		this.size = size;
		this.array = new int[size];
		this.top = -1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == size - 1);
	}

	public void push(int element) {

		if (!this.isFull()) {
			top++;
			array[top] = element;
			System.out.println("Pushes element: " + element);
		} else {
			System.out.println("Stack is full");
		}

	}

	public int pop() {

		if (!this.isEmpty()) {
			int returnTop = top;
			top--;
			System.out.println("poped element: " + array[returnTop]);
			return array[returnTop];
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public int peek() {

		if (!this.isEmpty()) {
			System.out.println("peeked element: "+array[top]);
			return array[top];
		} else {
			System.out.println("Stack is empty");
			return -1;
		}

	}

	public static void main(String[] args) {

		StackImp stackImp=new StackImp(6);
		stackImp.pop();
		
		stackImp.push(100);
		stackImp.push(200);
		stackImp.push(300);
		stackImp.push(400);
		stackImp.push(500);
		stackImp.push(600);
		stackImp.push(700);
		
		System.out.println("---------------------");
		
		stackImp.peek();
		stackImp.peek();
		stackImp.pop();
		stackImp.peek();
		stackImp.pop();
		stackImp.pop();
		stackImp.pop();
		stackImp.pop();
		stackImp.pop();
		stackImp.pop();
		
	}

}
