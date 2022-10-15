package com.java.string;

public class MarsExploration 
{
	public static int marsExploration(String s)
	{
		int count =0;
		char[] ch = s.toCharArray();
		
		for(int i =0;i<s.length();i=i+3)
		{
			if(ch[i] != 'S')
			{
				count++;
				System.out.println(ch[i]+"frs if  "+count);
			}
			if(ch[i+1] != 'O')
			{
				count++;
				System.out.println(ch[i]+"sec if "+count);
			}
			if(ch[i+2] != 'S')
			{
				count++;
				System.out.println(ch[i]+"  trd  if"+count);
			}
			
		}
		System.out.println(count);
		return count;

	}
	public static void main(String[] args) 
	{
		//Scanner input = new Scanner(System.in);
		String s="SOSSPSSQSSOR";
		marsExploration(s);
		System.out.println(s);
	}

}
