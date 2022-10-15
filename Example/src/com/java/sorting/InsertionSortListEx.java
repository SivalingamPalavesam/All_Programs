package com.java.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertionSortListEx {
	
	public static int insertionSort(List<Integer> list)
	{
		int count = 0;
		
		for(int i = 0; i<list.size();i++)
		{
			int temp =list.get(i);
			int j = i;
			while(j > 0 && temp <(list.get(j-1)) )
			{
				count++;
				list.set(j, list.get(j-1));
				j --;
			}
			list.set(i, temp);
		}
		
		System.out.println(list);
		System.out.println(count);
		return count;
		
	}
	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Value  :");
		for(int i = 0 ;i<6;i++)
		{
			list.add(input.nextInt());//1 4 3 5 6 2
		}
		
		insertionSort(list);
	}
}
