package com.practice.practice.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ReverseString {

	static String str = "My name is Anupam";

	// Solution 1: By Reverse Iteration
	public static String solution1(String str) {

		char ch[] = str.toCharArray();
		String rev = "";

		for (int i = ch.length - 1; i >= 0; i--) {

			rev += ch[i];
		}

		return rev;
	}

	// Solution 2: Using Reverse() function in String Builder
	public static String solution2(String str) {

		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String rev = sb.toString();
		return rev;
	}

	// Solution 3: Reverse string using byte array
	public static String solution3(String str) {

		byte[] strAsByte = str.getBytes();
		byte[] rev = new byte[strAsByte.length];

		for (int i = 0; i < strAsByte.length; i++) {

			rev[i] = strAsByte[strAsByte.length - i - 1];
		}

		return new String(rev);
	}

	// Solution 4: Using String buffer

	public static String solution4(String str) {
		StringBuffer sf = new StringBuffer(str);
		sf.reverse();
		return sf.toString();

	}

	public static void main(String[] args) {

		ReverseString reverseString = new ReverseString();

		System.out.println(reverseString.solution1(str));
		System.out.println(reverseString.solution2(str));
		System.out.println(reverseString.solution3(str));
		System.out.println(reverseString.solution4(str));

	}

}
