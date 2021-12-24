package com.practice.practice.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {

	// Solution 1: using array list
	public ArrayList<Integer> insertionSort1(ArrayList<Integer> arr) {

		int shortest = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {

			if (arr.get(i) <= shortest) {
				arr.add(0, arr.remove(i));
			} else {
				for (int j = 1; j <= i; j++) {
					if (arr.get(j - 1) > arr.get(i)) {
						arr.add(j - 1, arr.remove(i));
					}
				}
			}

			shortest = arr.get(0);
		}
		return arr;

	}

	public int[] insertionSort2(int[] arr) {

		int i, j, key;
		for (i = 0; i < arr.length; i++) {

			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key) {

				arr[j + 1] = arr[j];
				j--;

			}
			arr[j + 1] = key;

		}
		return arr;

	}

	public static void main(String[] args) {
		int[] arr = { 60, 219, 5, 3, 65, 76, 34, 60, 66, 1, 0 };
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			arrList.add(arr[i]);
		}

		InsertionSort insertionSort = new InsertionSort();
		System.out.println(insertionSort.insertionSort1(arrList));
		System.out.println(Arrays.toString(insertionSort.insertionSort2(arr)));
	}

}
