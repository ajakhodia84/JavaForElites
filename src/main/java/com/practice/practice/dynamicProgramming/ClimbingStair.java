package com.practice.practice.dynamicProgramming;

public class ClimbingStair {

	// Using recursion
	public static int countWays1(int n) {

		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}

		// System.out.println("Hello n for this is: " + n);
		int now1 = countWays1(n - 1);
		int now2 = countWays1(n - 2);
		int now3 = countWays1(n - 3);

		int totalnow = now1 + now2 + now3;

		return totalnow;

	}

	// Using recursion and Dynamamic Programming (memoization)
	public static int countWays2(int n, int[] cow) {

		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}

		if (cow[n] > 0) {
			return cow[n];
		}

		// System.out.println("Hello n for this is: " + n);
		int now1 = countWays2(n - 1, cow);
		int now2 = countWays2(n - 2, cow);
		int now3 = countWays2(n - 3, cow);

		int totalnow = now1 + now2 + now3;

		cow[n] = totalnow;
		return totalnow;

	}

	// Using loop and Dynamamic Programming (tabularization)
	/*
	 * Storage and Meaning Identify Direction Travel and Solve
	 */
	public static int countWays3(int n) {

		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = dp[i - 1];
			} else if (i == 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
		}

		return dp[n];

	}

	/* Using loop and dynamic programming with values on every step */

	public static int countWays4(int n, int[] arr) {

		int[] dp = new int[n + 1];
		dp[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
				dp[i] += dp[i + j];
			}
			// System.out.println(dp[i]);
		}

		return dp[0];
	}

	/*
	 * Climb stair with minimum moves with array provided for jumps available on
	 * every step Solution Approach for tabulation approach: Storage and Meaning
	 * Identify direction Travel and Solve
	 */
	public static int countWays5(int n, int[] arr) {

		Integer[] dp = new Integer[n + 1];
		dp[n] = 0;

		for (int i = n - 1; i >= 0; i--) {

			int min = Integer.MAX_VALUE;
			if (arr[i] > 0) {
				for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
					if (dp[i + j] != null) {
						min = Math.min(min, dp[i + j]);
					}

				}
			}
			if (min != Integer.MAX_VALUE) {
				dp[i] = min + 1;
			}

			// System.out.println(dp[i]);
		}

		return dp[0];

	}

	public static void main(String[] args) {
		ClimbingStair climbingStair = new ClimbingStair();

		System.out.println(climbingStair.countWays1(10));
		System.out.println(climbingStair.countWays2(10, new int[10 + 1]));
		System.out.println(climbingStair.countWays3(10));

		int n = 13;
		int[] arr = { 5, 5, 2, 4, 1, 5, 9, 8, 6, 3, 8, 9, 1 };

		/*
		 * int n = 6; int[] arr = { 3, 3, 0, 2, 2, 3 };
		 */
		System.out.println(climbingStair.countWays4(n, arr));
		System.out.println(climbingStair.countWays5(n, arr));

	}

}
