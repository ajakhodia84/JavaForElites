package com.practice.practice.algorithms.recursion;

import java.util.Scanner;

public class ReverseAString {

	public String solution1(String string) {

		char[] stringArray = string.toCharArray();
		String rev = "";

		for (int i = 0; i < string.length(); i++) {
			rev += stringArray[string.length() - 1 - i];

		}
		return rev;

	}

	public String solution2(String string) {

		StringBuilder sb = new StringBuilder(string);
		sb.reverse();
		String rev = sb.toString();
		return rev;

	}

	public String solution3(String string) {

		StringBuffer sb = new StringBuffer(string);
		sb.reverse();
		String rev = sb.toString();
		return rev;

	}

	public String solution4(String string) {

		byte[] str = string.getBytes();
		byte[] revArr = new byte[string.length()];

		for (int i = 0; i < string.length(); i++) {
			revArr[i] = str[string.length() - i - 1];
		}
		return new String(revArr);

	}

	public void solution5(String string) {
		if(string.length()<=1){
			System.out.println(string);
		} else {
		System.out.print(string.charAt(string.length()-1));
		solution5(string.substring(0, string.length()-1));
		}
		

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String to be reversed: ");
		String string = sc.nextLine();

		ReverseAString reverseAString = new ReverseAString();
		System.out.println(reverseAString.solution1(string));
		System.out.println(reverseAString.solution2(string));
		System.out.println(reverseAString.solution3(string));
		System.out.println(reverseAString.solution4(string));
		reverseAString.solution5(string);

	}

}
