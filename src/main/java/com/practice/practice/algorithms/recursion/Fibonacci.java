package com.practice.practice.algorithms.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {

	static int n1 = 0, n2 = 1, n3 = 0;

	// iterative
	public void fibonacciIterative(int n) {

		int n1 = 0, n2 = 1, n3;
		System.out.print("Fibonacci series till index " + n + " is: " + n1 + " " + n2 + " ");

		for (int i = 2; i < n; i++) {
			n3 = n1 + n2;
			System.out.print(n3 + " ");
			n1 = n2;
			n2 = n3;
		}

	}

	// recursive
	int calculations = 0;

	public void fibonacciRecursive(int n) {

		if (n > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(n3 + " ");
			calculations++;
			fibonacciRecursive(n - 1);
		}

	}

	// dynamic programming
	static HashMap<Integer, Integer> cache = new HashMap<>();
	static int operationsCount = 0;

	public int fibonnacciDynamic(int n) {
		if (cache.containsKey(n)) {
			return cache.get(n);

		} else {
			if (n < 2) {
				return n;
			} else {
				operationsCount++;
				cache.put(n, fibonnacciDynamic(n - 1) + fibonnacciDynamic(n - 2));
				return cache.get(n);
			}
		}
	}

	public static void main(String[] args) {

		Fibonacci fibonacci = new Fibonacci();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a index to find the fibonacci series: ");
		int number = sc.nextInt();
		fibonacci.fibonacciIterative(number);
		System.out.println();
		fibonacci.fibonacciRecursive(number);
		System.out.println();
		System.out.println(fibonacci.calculations);
		System.out.println();
		System.out.println(fibonacci.fibonnacciDynamic(number));
		System.out.println(fibonacci.cache.values());
		System.out.println(fibonacci.operationsCount);

	}

}
