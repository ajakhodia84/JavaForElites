package com.practice.practice.algorithms.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSequences {

	// bc --> [--, -c, b-, bc]
	// abc --> [---,--c,-b-,-bc, a--, a-c, ab-, abc]
	public static ArrayList<String> gss(String str) {

		if (str.length() == 0) {
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}

		char ch = str.charAt(0); // a
		String ros = str.substring(1); // bc
		ArrayList<String> rres = gss(ros);

		ArrayList<String> mres = new ArrayList<>();
		for (String rstr : rres) {
			mres.add("" + rstr);
		}

		for (String rstr : rres) {
			mres.add(ch + rstr);
		}

		return mres;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		SubSequences subSequences = new SubSequences();
		ArrayList<String> res = SubSequences.gss(str);
		System.out.println(res);

	}

}
