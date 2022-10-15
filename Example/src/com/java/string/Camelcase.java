package com.java.string;

import java.util.Arrays;
import java.util.Scanner;

public class Camelcase {


	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int result =Camelcase.camelcase(s);
		System.out.println(result);
	}
	public static int camelcase(String s)
	{
		//String s = "thisIsMyString";

		String[] r = s.split("(?=\\p{Upper})");
		int count =0;
		String[] words=Arrays.toString(r).split("\\s", count) ;    
		for(String str:words)
		{   
			count++;
		}  
		return count;

	}
}
