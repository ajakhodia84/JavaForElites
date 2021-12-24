package com.practice.practice.dynamicProgramming;

import java.util.Scanner;

public class MinCostPathFor2DArr {

	public static int findMinCostPath(int[][] arr) {

		// no of rows in given 2D arr
		int n = arr.length;

		// no of columns in given 2D arr
		int m = arr[0].length;

		int[][] dp = new int[n][m];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {

				if (i == n - 1 && j == m - 1) { // Case 1: For arr[n-1][m-1]
												// element

					dp[i][j] = arr[i][j];

				} else if (i == n - 1) { // Case 2: For last row

					dp[i][j] = arr[i][j] + dp[i][j + 1];

				} else if (j == m - 1) { // Case 3: For last column

					dp[i][j] = arr[i][j] + dp[i + 1][j];

				} else { // Case 4: For rest of elements

					dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + arr[i][j];

				}

			}
		}

		return dp[0][0];
	}

	/* Gold mine Problem: Path with maximum gold */
	public static int findMaxGainInGoldMine(int[][] arr) {

		// no of rows in given 2D arr
		int n = arr.length;

		// no of columns in given 2D arr
		int m = arr[0].length;

		int[][] dp = new int[n][m];

		for (int j = m - 1; j >= 0; j--) {
			for (int i = n - 1; i >= 0; i--) {

				if (j == m - 1) {// Case 1: For last column

					dp[i][j] = arr[i][j];

				} else if (i == 0) { // Case 2: For first row

					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);

				} else if (i == n - 1) { // Case 3: For last row

					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);

				} else { // Case 4: For rest of matrix

					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));

				}
			}
		}

		int max = dp[0][0];
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, dp[i][0]);
		}
		
		return max;
	}

	public static void main(String[] args) {

		/*
		 * Scanner sc = new Scanner(System.in); int n = sc.nextInt(); int m =
		 * sc.nextInt();
		 * 
		 * int[][] arr = new int[n][m]; for (int i = 0; i < n; i++) { for (int j
		 * = 0; j < m; j++) { arr[i][j] = sc.nextInt(); } }
		 */

		int[][] arr = { { 5, 3, 6, 7, 1 }, { 2, 3, 5, 1, 2 }, { 3, 2, 1, 4, 1 }, { 4, 1, 6, 2, 5 }, { 2, 4, 1, 3, 2 } };

		MinCostPathFor2DArr minCostPathFor2DArr = new MinCostPathFor2DArr();
		System.out.println(minCostPathFor2DArr.findMinCostPath(arr));
		System.out.println(minCostPathFor2DArr.findMaxGainInGoldMine(arr));

	}

}
