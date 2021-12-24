package com.practice.practice.dataStructure.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSums {

	static int[] arr = { 2, 7, 0, 9 };
	static int target = 9;

	// Solution 1: nested for loop
	public void solution1(int[] arr, int target) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] + arr[j] == target) {
					System.out.println("Output: [" + i + "," + j + "]");
				}
			}
		}

	}

	// Solution 2: Using hashmap
	public int[] solution2(int[] arr, int target) {

		Map<Integer, Integer> mapOfArr = new HashMap<Integer, Integer>();

		int[] loc = new int[2];

		for (int i = 0; i < arr.length; i++) {

			mapOfArr.put(arr[i], i);

		}

		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];
			if (mapOfArr.containsKey(complement)) {
				// return new int[] { mapOfArr.get(complement), i };
				loc[0] = i;
				loc[1] = mapOfArr.get(complement);
				System.out.println(Arrays.toString(loc));
			} else {
				mapOfArr.put(arr[i], i);
			}
		}

		return new int[] {};

	}
	
	//Solution 3: Using Slider window approach
	public int[] solution3(int[] arr, int target){
		
		Arrays.sort(arr);
		
		int left=0;
		int right=arr.length-1;
		
		while(left<right){
			
			if(arr[left]+arr[right]==target){
				System.out.println("Output: [" + left + "," + right + "]");
				return new int[] {left++, right--};
			}else if(arr[left]+arr[right]<target){
				left++;
			}else{
				right++;
			}			
		}
		return new int[] {};
	}

	public static void main(String[] args) {

		TwoSums twoSums = new TwoSums();
		twoSums.solution1(arr, target);
		System.out.println();
		twoSums.solution2(arr, target);
		System.out.println();
		twoSums.solution3(arr, target);

	}

}
