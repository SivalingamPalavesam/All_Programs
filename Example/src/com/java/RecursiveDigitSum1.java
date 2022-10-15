package com.java;

public class RecursiveDigitSum1 {
	public static int superDigit(String n, int k)
	{
		if (n.length() > 1)
		{
			int sum = 0;
			for (int i = 0; i < n.length(); i++)
			{
				sum += Character.getNumericValue(n.charAt(i));//Convert char to int before add value
				System.out.println(sum);
			}
			//System.out.printf(Integer.toString(sum * k),1);
			
			return superDigit(Integer.toString(sum * k),1);
		}
		else
			return Character.getNumericValue(n.charAt(0));

	}
	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder();
		String n = "123";
		int k =3;
		for(int  i = 0;i < k;i++)
		{  
			 sb = sb.append(n);
		}
		System.out.println("String value "+sb.toString());
		n = sb.toString();
		superDigit(n,k);
		//System.out.println(n);
	}
}
