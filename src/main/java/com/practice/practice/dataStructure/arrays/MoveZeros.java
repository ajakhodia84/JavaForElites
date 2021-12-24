package com.practice.practice.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MoveZeros {

	static int[] arr = { 0, 0, 0, 0, 1, 1, 2, 9 };

	// Solution 1: Using nested for loop

	public void solution1(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {
				for (int j = i; j < arr.length - 1; j++) {
					int extra;
					extra = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = extra;

				}
			}

		}

		System.out.println(Arrays.toString(arr));
	}

	// Solution 2: Personal
	public void solution2(int[] arr) {

		// `k` stores the index of the next available position
		int k = 0;

		// do for each element
		for (int i = 0; i < arr.length; i++) {
			// if the current element is non-zero, put the element at the
			// next free position in the array
			if (arr[i] != 0) {
				arr[k++] = arr[i];
			}
		}

		// move all 0's to the end of the array (remaining indices)
		for (int i = k; i < arr.length; i++) {
			arr[i] = 0;
		}

		System.out.println(Arrays.toString(arr));
	}

	// Solution 3: persoanl

	public void solution3(int[] arr) {

		ArrayList<Integer> resultwithoutZero = new ArrayList<Integer>();
		ArrayList<Integer> resultwithZero = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {
				resultwithZero.add(arr[i]);
			} else {
				resultwithoutZero.add(arr[i]);
			}

		}

		resultwithoutZero.addAll(resultwithZero);

		System.out.println(resultwithoutZero);
	}

	// Solution 4: Using partitioning logic of Quicksort

	public void solution4(int[] arr) {

		int j = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != 0) {
				swap(arr, i, j);
				j++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void swap(int[] A, int i, int j) {

		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;

	}

	public static void main(String[] args) {
		MoveZeros moveZeros = new MoveZeros();
		moveZeros.solution1(arr);
		moveZeros.solution2(arr);
		moveZeros.solution3(arr);
		moveZeros.solution4(arr);

	}

}
