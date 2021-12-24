package com.practice.practice.dataStructure.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class FindCommEleInArray {

	// create Array 1
	static String[] arr1 = { "Article", "in", "Geeks", "for", "Geeks" };

	// create Array 2
	static String[] arr2 = { "Geeks", "for", "Geeks" };

	// Solution 1: Using nested for loop

	public static void solution1(String[] arr1, String[] arr2) {

		Set<String> set = new HashSet<String>();

		for (String itemFromArr1 : arr1) {

			for (String itemFromArr2 : arr2) {

				if (itemFromArr1 == itemFromArr2) {
					// add common element to set
					set.add(itemFromArr1);
					break;
				}
			}

		}

		String[] commElement = new String[set.size()];
		set.toArray(commElement);
		System.out.println(Arrays.toString(commElement));
	}

	// Solution 2: Using Hash Table
	public static void solution2(String[] arr1, String[] arr2) {

		Hashtable<String, Boolean> htOfArr1 = new Hashtable<String, Boolean>();
		Set<String> commElement = new HashSet<String>();

		// Mapping keys to arr1
		for (String arr1Elements : arr1) {

			htOfArr1.put(arr1Elements, true);
		}

		// Checking if arr2 elements keys exist in set created for arr1
		for (String arr2Elements : arr2) {
			try {
				if (htOfArr1.get(arr2Elements) == true) {
					commElement.add(arr2Elements);
				}
			} catch (Exception e) {

			}
		}

		for (String i : commElement) {
			System.out.print(i + " ");
		}

	}

	// Solution 3: Using removeall() function from Java set

	public static void solution3(String[] arr1, String[] arr2) {

		Set<String> arr1Elements = new HashSet<String>();
		Set<String> arr2Elements = new HashSet<String>();

		for (String i : arr1) {

			arr1Elements.add(i);
		}

		for (String i : arr2) {

			arr2Elements.add(i);
		}

		arr1Elements.retainAll(arr2Elements);

		System.out.println("Common elements are: " + arr1Elements);
	}

	// Solution 4: Using contains() funcion from set
	public static void solution4(String[] arr1, String[] arr2) {

		Set<String> arr1Elements = new HashSet<String>();

		for (String i : arr1) {

			arr1Elements.add(i);
		}

		for (String j : arr2) {

			if (arr1Elements.contains(j)) {

				System.out.print(j + " ");

			}

		}

	}

	public static void main(String[] args) {

		FindCommEleInArray findCommEleInArray = new FindCommEleInArray();
		findCommEleInArray.solution1(arr1, arr2);
		System.out.println();
		findCommEleInArray.solution2(arr1, arr2);
		System.out.println();
		findCommEleInArray.solution3(arr1, arr2);
		System.out.println();
		findCommEleInArray.solution4(arr1, arr2);

	}

}
