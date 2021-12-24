package com.practice.practice.dataStructure.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {

		List<String> string = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

		for (String str : string) {
			System.out.print(str+" ");
		}

		System.out.println(" ");
		string.stream().filter(s -> !s.isEmpty()).limit(2).forEach(s -> System.out.print(s+" "));
		
		System.out.println(" ");
		String Mergedstring =string.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
		
		System.out.println(Mergedstring);
				
		System.out.println(" ");
		List<Integer> numbers= Arrays.asList(3,2,2,3,7,3,5);
		
		List<Integer> squareList= numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
		squareList.forEach(s -> System.out.print(s+" "));
		
		IntSummaryStatistics stats=numbers.stream().mapToInt((x) -> x).summaryStatistics();
		
		System.out.println(" ");
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Total number in List : " + stats.getCount());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		System.out.println("Class : " + stats.getClass().toString());

	}

}
