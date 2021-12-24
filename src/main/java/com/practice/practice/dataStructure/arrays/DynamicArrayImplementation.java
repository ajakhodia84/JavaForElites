package com.practice.practice.dataStructure.arrays;

import java.util.Arrays;

/*Implementation of our own Dynamic Array Data Structure*/

public class DynamicArrayImplementation {

	// We will store our elements in this array
	private String[] array;

	// capacity is number of elements that our array can hold
	private int capacity;

	// currentLenght is the number of elements currently present in our array
	private int currentLenght;

	public DynamicArrayImplementation() {
		array = new String[1];
		capacity = 1;
		currentLenght = 0;
	}

	// get(index) method returns the element of array at the given index
	public String get(int index) {

		if (index > -1 && index < currentLenght)
			return this.array[index];
		else
			return "Index out of Bound Exception";

	}

	// push(element) add given element at the end of array
	public void push(String element) {

		// if currentLenght becomes equal to capacity we need to increase the
		// capacity to add more elements
		if (currentLenght == capacity) {
			// create a new array with double capacity
			String[] tempArray = new String[2 * capacity];

			// copy elements of old array to new array
			for (int i = 0; i < array.length; i++) {

				tempArray[i] = array[i];

			}

			// set the newly created array as out real array
			array = tempArray;

			// update the value of capacity
			capacity *= 2;
		}

		// inserting the new element at the end
		array[currentLenght] = element;

		// updating the value of currentLenght by 1
		currentLenght++;

	}

	// replace(index, value) replaces the value of array at given index with the
	// newly entered value
	public void replace(int index, String value) {

		if (index > -1 && index < currentLenght) {
			array[index] = value;
		} else
			System.out.println("Index out of bound exception");

	}

	// pop() removes last element from the given array
	public void pop() {

		if (currentLenght > 0) {
			currentLenght--;
		}

	}

	// delete element at the given index
	public void delete(int index) {

		if (index > -1 && index < currentLenght) {
			if (index == currentLenght - 1) {
				pop();
			} else {
				for (int i = index; i < currentLenght; i++) {
					array[i] = array[i + 1];
				}
				currentLenght--;
			}
		} else {
			System.out.println("Index out of bound");
		}

	}

	// getArray, returns the given array
	public String[] getArray() {

		String[] tempArr = new String[currentLenght];
		for (int i = 0; i < currentLenght; i++) {
			tempArr[i] = array[i];
		}
		return tempArr;

	}

	// lenght(), returns the lenght of array {Number of elements stored in the
	// array}
	public int length() {

		return currentLenght;

	}

	public static void main(String[] args) {
		
		DynamicArrayImplementation dynamicArray = new DynamicArrayImplementation();
		dynamicArray.push("apple");
		dynamicArray.push("banana");
		dynamicArray.push("Mango");
		dynamicArray.push("Grapes");
		dynamicArray.push("papaya");
		System.out.println("Array-Length: " + dynamicArray.length());
        System.out.println("array: " + Arrays.toString(dynamicArray.getArray()));
        System.out.println("item at index 2: " + dynamicArray.get(2));
        dynamicArray.replace(1, "world");
        System.out.println("array: " + Arrays.toString(dynamicArray.getArray()));
        dynamicArray.pop();
        System.out.println("array: " + Arrays.toString(dynamicArray.getArray()));
        dynamicArray.delete(1);
        System.out.println("array: " + Arrays.toString(dynamicArray.getArray()));
        System.out.println("Array-Length: " + dynamicArray.length());

	}

}
