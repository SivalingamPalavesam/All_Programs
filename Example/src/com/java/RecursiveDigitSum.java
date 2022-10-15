package com.java;

public class RecursiveDigitSum {

	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder();
		String s = "98963";
		int k =100;
		for(int  i = 0;i < k;i++)
		{  
			sb = sb.append(s);
		}
		System.out.println("String value "+sb.toString());
		s = sb.toString();
		sum(s,k);
	}
	public static int sum(String s,int k)
	{
		char[] ch = s.toCharArray();
		int count=0;	
		for(int  i = 0;i < ch.length;i++)
		{  
			count +=Character.getNumericValue(ch[i]); //Convert char to int before add value
		}
		System.out.println(count);
		if(count>10)
		{
			String str=Integer.toString(count);  
			sum(str,k);
		}		
		return count;
	}
}


//maildetails,username,password