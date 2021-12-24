package com.practice.practice.dataStructure.Stack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StackUsingArrayList {

	ArrayList<String> arrayList;

	public StackUsingArrayList() {

		this.arrayList = new ArrayList<>();
	}

	public String peek() {

		if (this.arrayList.size() > 0) {

			return arrayList.get(arrayList.size() - 1);

		} else {
			return null;
		}

	}

	public void push(String value) {

		arrayList.add(value);

	}

	public void pop() {

		if (this.arrayList.size() != 0) {

			arrayList.remove(arrayList.size() - 1);

		} else {
			System.out.println("Value cannot be removed");
		}

	}

	public boolean isEmpty() {

		return arrayList.size() == 0;

	}

	public static void main(String[] args) {

		StackUsingArrayList stackUsingArrayList = new StackUsingArrayList();
		stackUsingArrayList.push("Google");
		stackUsingArrayList.push("Udemy");
		stackUsingArrayList.push("Discord");
		System.out.println(stackUsingArrayList.peek());
		stackUsingArrayList.pop();
		System.out.println(stackUsingArrayList.peek());
		System.out.println(stackUsingArrayList.isEmpty());

	}

}
