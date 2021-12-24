package com.practice.practice.dataStructure.arrays;

import java.util.HashSet;

public class ContainsDuplicate {

	/*
	 * Java program to Check if a given array contains duplicate elements within
	 * k distance from each other
	 */

	static int[] arr = { 1, 2, 4, 3, 1, 6, 7, 4 };
	
	static int k = 3;

	// Solution 1: Naive approach- nested for loop

	public boolean solution1(int[] arr) {

		int k = 3;

		for (int i = 0; i < k; i++) {

			for (int j = i + 1; j < k; j++) {

				if (arr[i] == arr[j]) {

					System.out.println("Location of Duplicate element: " + i + ", " + j);

					return true;
				}

			}

		}

		return false;
	}

	// Solution 2: Using HashSet
	public boolean solution2(int[] arr, int k) {

		// Create an empty hashset
		HashSet<Integer> arraySet = new HashSet<Integer>();

		// Traverse the input array
		for (int i = 0; i < arr.length; i++) {

			if (arraySet.contains(arr[i]))
				return true;

			arraySet.add(arr[i]);

			if (i >= k)
				arraySet.remove(arr[i - k]);

		}
		return false;

	}

	public static void main(String[] args) {

		ContainsDuplicate containsDuplicate = new ContainsDuplicate();
		System.out.println(containsDuplicate.solution1(arr));
		System.out.println(containsDuplicate.solution2(arr, k));

	}

}
