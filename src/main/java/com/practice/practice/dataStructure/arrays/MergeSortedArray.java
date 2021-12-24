package com.practice.practice.dataStructure.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MergeSortedArray {

	static int[] arr1 = { 1, 3, 5, 7, 9 };
	static int[] arr2 = { 2, 4, 6, 8, 9 };

	// Solution 1: Using HashSet
	// 1. Add all element of arr1 to a set
	// 2. Traverse through arr2 and add its elements to set if they does not
	// exist
	public static Integer[] solution1(int[] arr1, int[] arr2) {

		Set<Integer> setOfArr1 = new HashSet<Integer>();

		// Verify if both arrays has elements

		if (arr1.length == 0) {

		}
		for (int i : arr1) {
			setOfArr1.add(i);
		}

		for (int i : arr2) {

			if (!setOfArr1.contains(i)) {
				setOfArr1.add(i);
			}
		}

		Integer[] mergedArr = new Integer[setOfArr1.size()];
		setOfArr1.toArray(mergedArr);

		return mergedArr;

	}

	// Solution 2:
	public static int[] solution2(int[] arr1, int[] arr2) {

		
		/*static int[] arr1 = { 1, 3, 5, 7, 9 };
		static int[] arr2 = { 2, 4, 6, 8, 9 };*/
		
		int i=0, j=0, k=j;
		int[] arr3= new int[arr1.length+arr2.length];
		
		while(i<arr1.length && j< arr2.length){
			
			if(arr1[i]< arr2[j])
				arr3[k++]=arr1[i++];
			else
				arr3[k++]=arr2[j++];
		}
		
		while(i<arr1.length){
			arr3[k++]=arr1[i++];
		}
		
		while(i<arr2.length){
			arr3[k++]=arr1[j++];
		}
		
		return arr3;
	}
	
	//Solution 3: Using Maps
	public static Object[] solution3(int[] arr1, int[] arr2){
		
		Map<Integer, Boolean> mp=new HashMap<Integer, Boolean>();
		for(int i: arr1){
			mp.put(i, true);
		}
		
		for(int i: arr2){
			mp.put(i, true);
		}
		
		/*for(Map.Entry<Integer, Boolean> me : mp.entrySet()){
			System.out.print(me.getKey() + " ");
		}*/
		
		Object[] merged=mp.keySet().toArray();
		return merged;
	}

	public static void main(String[] args) {

		MergeSortedArray mergeSortedArray = new MergeSortedArray();
		System.out.println(Arrays.toString(mergeSortedArray.solution1(arr1, arr2)));
		System.out.println(Arrays.toString(mergeSortedArray.solution2(arr1, arr2)));
		System.out.println((Arrays.toString(mergeSortedArray.solution3(arr1, arr2))));

	}

}
