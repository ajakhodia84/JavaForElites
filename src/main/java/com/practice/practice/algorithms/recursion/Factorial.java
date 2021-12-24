package com.practice.practice.algorithms.recursion;

import java.util.Scanner;

public class Factorial {

	// Solution 1: Using recursion
	public int factorial1(int number) {

		int factorial;

		if (number == 0) {
			return 1;
		} else if(number > 0){
			factorial = number * factorial1(number - 1);
		} else {
			factorial = number * factorial1(number + 1);
		}
		return factorial;

	}

	//Solution 2: Using loops
	public int factorial2(int number) {

		int factorial=1;

		if (number == 0) {
			return 1;
		} else if(number >  0){
			for(int i=0; i< number; i++){
				factorial=factorial*(number-i);
			}
		} else {
			for(int i=number; i< 0; i++){
				factorial=factorial*(i);
			}
		}
		return factorial;

	}
	// Solution 3: Using recursion but one liner
		public int factorial3(int number) {

			int factorial;

			if (number == 0) {
				return 1;
			} else if(number > 0){
				factorial = (number == 1 || number == 0) ? 1 : number*factorial3(number-1);
			} else {
				factorial = (number == 1 || number == 0) ? 1 : number*factorial3(number+1);
			}
			return factorial;

		}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find factorial: ");
		int number = sc.nextInt();

		Factorial factorial = new Factorial();
		System.out.println(factorial.factorial1(number));
		System.out.println(factorial.factorial2(number));
		System.out.println(factorial.factorial3(number));

	}

}
