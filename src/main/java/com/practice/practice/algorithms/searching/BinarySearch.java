package com.practice.practice.algorithms.searching;

import java.util.Arrays;

public class BinarySearch {
	// In binary-search the elements must be sorted. If they are unsorted, first
	// sort them.
	// In this case we assume that array is sorted so we directly apply binary
	// search.
	// you can sort array using "Arrays.sort(array)" method
	public int binarySearch(int[] arr, int key) {
		int first = 0;
		int last = arr.length - 1;
		int mid = (first + last) / 2;

		while (first <= last) {
			if (arr[mid] < key) {
				first = mid + 1;
			} else if (arr[mid] == key) {
				System.out.println("The given key " + key + " is found at position: " + mid);
				return mid;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 60, 219, 5, 3, 65, 76, 34, 60, 66, 1, 0 };

		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		BinarySearch binarySearch=new BinarySearch();
		binarySearch.binarySearch(arr, 76);

	}

}
