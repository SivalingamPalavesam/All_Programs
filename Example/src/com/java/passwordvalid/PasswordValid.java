	package com.java.passwordvalid;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValid 
{
	public static  boolean validCheck(String password )
	{
		 String regexCheck = "^(?=.*[0-9])"
				 			+ "(?=.*[a-z])(?=.*[A-Z])"
				 			+ "(?=.*[@#$%^&+=])"
				 			+ "(?=\\S+$).{6,20}$";

		Pattern pattern = Pattern.compile(regexCheck);
		if(password == null)
		{
			System.out.println("Enter Password");
		}
		Matcher m = pattern.matcher(password);
		return m.matches();	
	}

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter UserName  :");
		String userName = input.nextLine();
		System.out.println("Enter Password  :");
		String password = input.nextLine();
		System.out.println( validCheck(password));
	}
	}
