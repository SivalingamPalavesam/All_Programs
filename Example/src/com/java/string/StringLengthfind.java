package com.java.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringLengthfind {

	public static void main(String[] args) {

		String str = "Sivalingam";

		int count = 0;
		for (String s : str.split("")) {
			count++;
		}
		System.out.println(count);

		Long value = Arrays.stream(str.split("")).collect(Collectors.counting());

		System.out.println(value);

		Map<String, List<String>> map = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity()));

		System.out.println(map);
		
		

	}

}
