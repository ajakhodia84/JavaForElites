package com.practice.practice.dynamicProgramming;

import java.util.HashMap;

public class Fibonacci {

	static HashMap<Integer, Integer> cache = new HashMap<>();
	static int operationsCount = 0;

	public int fibonacciDP(int n) {

		if (cache.containsKey(n)) {
			return cache.get(n);
		} else {
			if (n < 2) {
				return n;
			} else {
				operationsCount++;
				cache.put(n, fibonacciDP(n - 1) + fibonacciDP(n - 2));
				return cache.get(n);
			}
		}

	}

	public static void main(String[] args) {

		Fibonacci fib = new Fibonacci();
		System.out.println(fib.fibonacciDP(30));
		System.out.println(operationsCount);
		System.out.println(cache.values());
	}

}
