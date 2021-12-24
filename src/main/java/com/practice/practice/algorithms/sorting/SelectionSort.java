package com.practice.practice.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

	public int[] selectionSort1(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			int smallest = i;

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] < arr[smallest]) {
					smallest = j;
				}

			}

			int temp1 = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp1;
		}

		return arr;

	}

	public static void main(String[] args) {

		int[] arr = { 328, 219, 5, 3, 65, 76, 34, 54, 66, 1, 0 };
		SelectionSort selectionSort = new SelectionSort();
		System.out.println(Arrays.toString(selectionSort.selectionSort1(arr)));

	}

}
