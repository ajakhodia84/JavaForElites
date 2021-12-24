package com.practice.practice.dynamicProgramming;

import java.util.HashMap;

public class Memoization {
	
	public int addTo80(int n){
		System.out.println("Long time");
		return n+80;
	}
	
	static HashMap<Integer, Integer> cache = new HashMap<>();
	
	public int memoizedAddTo80(int n){
		//once cached it want add everytime the funcation has to be called
		if(!cache.containsKey(n)){
			System.out.println("Long Time memoized");
			cache.put(n, n+80);
		}
		return cache.get(n);
	}

	public static void main(String[] args) {
		Memoization memo = new Memoization();
        System.out.println("addTo80: " + memo.addTo80(5));
        System.out.println("addTo80: " + memo.addTo80(5));

        System.out.println("memoizeAddTo80: " + memo.memoizedAddTo80(5));
        System.out.println("memoizeAddTo80: " + memo.memoizedAddTo80(5));
        System.out.println("memoizeAddTo80: " + memo.memoizedAddTo80(5));

	}

}
