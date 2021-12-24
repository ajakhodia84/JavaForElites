package com.practice.practice.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

	// Solution 1

	public int[] bubbleSortIni(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {

				int temp;

				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}

		return arr;
	}

	public static void main(String[] args) {

		int[] arr = { 328, 219, 5, 3, 65, 76, 34, 54, 66, 1, 0 };

		BubbleSort bubbleSort = new BubbleSort();
		System.out.println(Arrays.toString(bubbleSort.bubbleSortIni(arr)));

	}

}
