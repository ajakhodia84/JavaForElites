package com.practice.practice.dataStructure.arrays;

public class LongestWord {

	static String sentence = "I am an intern at geeksforgeeks";

	// Solution 1:
	public int solution1(String sen) {

		int currentWordLenght = 0, LongestWordTillNow = 0;

		// char[] senToChar=sen.toCharArray();
		for (int i = 0; i < sen.length(); i++) {

			if (sen.charAt(i) != ' ') {
				currentWordLenght++;
			} else {
				LongestWordTillNow = Math.max(LongestWordTillNow, currentWordLenght);
				currentWordLenght = 0;
			}

		}

		return LongestWordTillNow = Math.max(LongestWordTillNow, currentWordLenght);

	}

	// Solution 2:
	public int solution2(String sen) {

		int LongestWordTillNow = 0;
		String[] words = sen.split(" ");

		for (String word : words) {

			if (LongestWordTillNow < word.length()) {

				LongestWordTillNow = word.length();

			}

		}

		return LongestWordTillNow;

	}

	public static void main(String[] args) {

		LongestWord longestWord = new LongestWord();
		System.out.println(longestWord.solution1(sentence));
		System.out.println(longestWord.solution2(sentence));

	}

}
