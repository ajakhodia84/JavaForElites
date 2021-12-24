package com.practice.practice.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

	public static int[] quickSort(int[] arr, int low, int high) {
		if (arr.length <= 1) {
			return arr;
		}

		if (low > high)
			return arr;

		int mid = low+(high-low)/2;
		int pivot = arr[mid];
		int i = low;
		int j = high-1;
		while (i < j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			i++;
			j--;

			if (low < j) {
				quickSort(arr, low, j);
			}
			if (high > i) {
				quickSort(arr, i, high);
			}
		}
		return arr;

	}

	public static void main(String[] args) {
		int[] arr = { 60, 219, 5, 3, 65, 76, 34, 60, 66, 1, 0 };
		QuickSort quickSort=new QuickSort();
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(quickSort.quickSort(arr, 0, arr.length)));
		

	}

}
