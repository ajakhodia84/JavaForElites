package com.practice.practice.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobberProblem {

	/*
	 * There are n houses build in a line, each of which contains some value in
	 * it. A thief is going to steal the maximal value of these houses, but he
	 * can’t steal in two adjacent houses because the owner of the stolen houses
	 * will tell his two neighbors left and right side. What is the maximum
	 * stolen value?
	 */

	// Actual Problem
	/*
	 * Find the maximum sum of elements from an array such that no two array
	 * elements are adjacent
	 */

	// Solution 1: Using Recursion
	public int maxLoot1(int[] arr) {

		if (arr.length == 0)
			return 0;

		if (arr.length == 1)
			return arr[1];

		if (arr.length == 2)
			return Math.max(arr[0], arr[1]);

		ArrayList<Integer> maxLootTillNow = new ArrayList<Integer>();
		maxLootTillNow.add(arr[0]);
		maxLootTillNow.add(arr[1]);
		for (int i = 2; i < arr.length; i++) {

			maxLootTillNow.add(Math.max(arr[i] + maxLootTillNow.get(i - 2), maxLootTillNow.get(i - 1)));

		}

		return maxLootTillNow.get(arr.length - 1);

	}

	// Solution 2: Using for loop
	public int maxLoot2(int[] arr) {

		if (arr.length == 0)
			return 0;

		int even = 0;
		int odd = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				even += arr[i];
				even = even > odd ? even : odd;
			} else {
				odd += arr[i];
				odd = even > odd ? even : odd;
			}
		}

		return even > odd ? even : odd;

	}

	public static void main(String[] args) {

		// int[] arr = { 328, 219, 5, 3, 65, 76, 34, 54, 66, 1, 0 };
		int[] arr = { 6, 7, 1, 3, 8, 2, 4 };

		HouseRobberProblem hrb = new HouseRobberProblem();
		System.out.println("Maximum amount a robber can rob from Solution1 is: " + hrb.maxLoot1(arr));
		System.out.println("Maximum amount a robber can rob from Solution2 is: " + hrb.maxLoot2(arr));

	}

}
