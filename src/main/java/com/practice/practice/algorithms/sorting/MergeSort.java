package com.practice.practice.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static int[] mergeSort(int[] arr) {

		if (arr.length <= 1) {
			return arr;
		} else {

			int midPoint = arr.length / 2;
			int[] left = new int[midPoint];
			int[] right = new int[arr.length - midPoint];

			for (int i = 0; i < left.length; i++) {
				left[i] = arr[i];
			}

			for (int j = 0; j < right.length; j++) {
				right[j] = arr[midPoint + j];
			}

			int[] result = new int[arr.length];
			/*
			 * left = mergeSort(left); right = mergeSort(right);
			 */

			result = merge(mergeSort(left), mergeSort(right));
			return result;
		}

	}

	public static int[] merge(int[] left, int[] right) {

		int[] result = new int[left.length + right.length];
		int leftPointer = 0, rightPoiter = 0, resultPointer = 0;

		while (leftPointer < left.length || rightPoiter < right.length) {
			if (leftPointer < left.length && rightPoiter < right.length) {
				if (left[leftPointer] <= right[rightPoiter]) {
					result[resultPointer++] = left[leftPointer++];
				} else {
					result[resultPointer++] = right[rightPoiter++];
				}
			} else if (leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			} else if (rightPoiter < right.length) {
				result[resultPointer++] = right[rightPoiter++];
			}
		}

		return result;

	}

	public List<Integer> mergeSort2(List<Integer> arr) {

		if (arr.size() <= 1) {
			return arr;
		}

		List<Integer> left = arr.subList(0, arr.size() / 2);
		List<Integer> right = arr.subList(arr.size() / 2, arr.size());

		return merge2(mergeSort2(left), mergeSort2(right));

	}

	public List<Integer> merge2(List<Integer> left, List<Integer> right) {

		List<Integer> result = new ArrayList<Integer>();
		int leftPointer = 0;
		int rightPointer = 0;

		while (leftPointer < left.size() || rightPointer < right.size()) {

			if (leftPointer < left.size() && rightPointer < right.size()) {
				if (left.get(leftPointer) <= right.get(rightPointer)) {
					result.add(left.get(leftPointer++));
				} else {
					result.add(right.get(rightPointer++));
				}
			} else if (leftPointer < left.size()) {
				result.add(left.get(leftPointer++));
			} else if (rightPointer < right.size()) {
				result.add(right.get(rightPointer++));
			}

		}
		
		return result;

	}

	public static void main(String[] args) {
		int[] arr = { 60, 219, 5, 3, 65, 76, 34, 60, 66, 1, 0 };
		MergeSort mergeSort = new MergeSort();
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(mergeSort.mergeSort(arr)));
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			arrList.add(arr[i]);
		}
		System.out.println(mergeSort.mergeSort2(arrList));

	}

}
