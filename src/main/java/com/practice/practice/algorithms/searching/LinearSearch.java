package com.practice.practice.algorithms.searching;

import java.util.Arrays;

public class LinearSearch {

	public int linearSearch(int[] arr, int key) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == key) {
				System.out.println("The given key "+key+" is found at position: "+ i);
				return i;
			}
		}
		
		System.out.println("The given key "+key+" is not found");
		return -1;

	}

	public static void main(String[] args) {
		int[] arr = { 60, 219, 5, 3, 65, 76, 34, 60, 66, 1, 0 };
		
		System.out.println(Arrays.toString(arr));
		LinearSearch linearSearch= new LinearSearch();
		linearSearch.linearSearch(arr, 65);
		
		

	}

}
