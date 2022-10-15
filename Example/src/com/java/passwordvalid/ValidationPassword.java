package com.java.passwordvalid;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidationPassword
{
	public static int minimumNumber(int n, String password) 
	{
		boolean lowercase = false;
		boolean uppercase = false;
		boolean number = false;
		boolean special = false;

		char[] ch = "!@#$%^&*()-+".toCharArray();
		
		Set<Character> set = new HashSet<>();

		for (char c : ch) 
		{
			set.add(c);
		}
		for (int i = 0; i < n; i++)
		{
			char c = password.charAt(i);

			if (c >= '0' && c <= '9')
			{
				number = true;
			}
			if (c >= 'a' && c <= 'z')
			{
				lowercase = true;
			}
			if (c >= 'A' && c <= 'Z')
			{
				uppercase = true;
			}
			if (set.contains(c)) 
			{
				special = true;
			}

		}
		
		int count = 0;
		if(!number) count++;
		if(!lowercase) count++;
		if(!uppercase) count++;
		if(!special) count++;

		return (count+n < 6) ? 6-n : count;
	}

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Password  :");
		int n = input.nextInt();
		String password = input.next();
		int answer = minimumNumber(n, password);
		System.out.println(answer);
		input.close();
		
		

	}

}
