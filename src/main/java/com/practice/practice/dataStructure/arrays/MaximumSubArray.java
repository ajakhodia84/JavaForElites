package com.practice.practice.dataStructure.arrays;

import java.util.ArrayList;

public class MaximumSubArray {

	static int[] arr = { -2, -5, 6, -2, -3, 1, 5, -6 };

	// Solution 1: Nested for loop
	public static int solution1(int[] arr) {

		int maxSoFar = 0, maxEndingHere = 0;
		ArrayList<Integer> MaxSubArray = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			maxEndingHere = maxEndingHere + arr[i];
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;

			}
			if (maxEndingHere < 0)
				maxEndingHere = 0;

		}

		// System.out.println(MaxSubArray);
		return maxSoFar;
	}

	// Solution2
	public static int solution2(int[] arr) {

		int maxSoFar = 0, maxEndingHere = 0;
		ArrayList<Integer> MaxSubArray = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			maxEndingHere = maxEndingHere + arr[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;

			} else if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}

		}

		// System.out.println(MaxSubArray);
		return maxSoFar;
	}

	// Solution3 2, 2, 3, 4, -1, 22, -1, -5, 14
	public static int solution3(int[] arr) {

		ArrayList<Integer> MaxSubArray = new ArrayList<Integer>();
		int max_so_far = 0;
		int curr_max = 0;

		for (int i = 0; i < arr.length; i++) {
			curr_max = Math.max(arr[i], curr_max + arr[i]);
			max_so_far = Math.max(max_so_far, curr_max);

		}

		// System.out.println(MaxSubArray);
		return max_so_far;
	}

	// Solution3 -2, 1, -3, 4, -1, 2, 1, -5, 4
	public static void solution4(int[] arr) {

		int msf = Integer.MIN_VALUE, meh = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < arr.length; i++) {

			meh += arr[i];
			if (msf < meh) {

				msf = meh;
				start = s;
				end = i;
			}

			if (meh < 0) {

				meh = 0;
				s = i + 1;
			}
		}

		System.out.println("Maximum contiguous sum is " + msf);
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + end);

	}
	
	//Solution 5: Device and Conquer
	

	public static void main(String[] args) {
		MaximumSubArray maximumSubArray = new MaximumSubArray();

		System.out.println(maximumSubArray.solution1(arr));
		System.out.println(maximumSubArray.solution2(arr));
		System.out.println(maximumSubArray.solution3(arr));
		maximumSubArray.solution4(arr);

	}

}
