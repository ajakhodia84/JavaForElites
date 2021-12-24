package com.practice.practice.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RotateArray {

	/*
	 * Given an array, rotate the array to the right by k steps, where k is
	 * non-negative. Input: nums = [1,2,3,4,5,6,7], k = 3 Output:
	 * [5,6,7,1,2,3,4]
	 */

	// Solution 1: Using two array list

	static int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
	static int k = 3;

	// Solution 1: Saving the elements in tow different arraylist and then
	// joining them back based on rotation direction
	public int[] solution1(int[] arr, int k) {

		ArrayList<Integer> iniArr = new ArrayList<Integer>();
		ArrayList<Integer> laterArr = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (i < k)
				iniArr.add(arr[i]);

			if (i >= k)
				laterArr.add(arr[i]);

		}
		laterArr.addAll(iniArr);
		arr = laterArr.stream().mapToInt(i -> i).toArray();
		return arr;
	}

	// Solution 2: Using temp array and swaping the elements
	public int[] solution2(int[] arr, int k) {

		int[] temp = new int[k];

		for (int i = 0; i < k; i++) {

			temp[i] = arr[i];

		}

		for (int i = k, j = 0; i < arr.length; i++, j++) {

			arr[j] = arr[i];

		}

		for (int i = (arr.length-k), j = 0; i < arr.length; i++, j++) {

			arr[i] = temp[j];

		}

		return arr;

	}
	
	// Solution 3: Using aslist and rotate function
	public int[] solution3(int[] arr, int k) {
		
		Collections.rotate(Arrays.asList(arr), k);
		
		System.out.println("Modified Array : " +
                Arrays.toString(arr));
		return arr;
	}

	public static void main(String[] args) {

		RotateArray rotateArray = new RotateArray();
		System.out.println(Arrays.toString(rotateArray.solution1(arr, k)));
		System.out.println(Arrays.toString(rotateArray.solution2(arr, k)));
		System.out.println(Arrays.toString(rotateArray.solution3(arr, k)));

	}

}
