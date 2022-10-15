package com.java.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InsertionSortForIf 
{
	public static int insertionSort(List<Integer> list)
	{
		int count =0;
		for(int i =1;i<list.size();i++)
		{
			int temp = list.get(i);
			int j = i-1;
			while(j!=0)
			{
			if(j>=0 && temp < list.get(j))
			{
				list.set((j+1), list.get(j));
				list.set(j, temp);
				j--;
				//printArray(list);
				
				printArray(list);
			}
			}

			//list.set(list.get(j+1), temp);
			//printArray(list);
		}

		return count;
	}
	private static void printArray(List<Integer> list) 
	{
		for(int n: list){
			System.out.print(n+" ");
		}
		System.out.println("");
	}

	public static void main(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		list.add(2);
		list.add(1);
		list.add(3);
		list.add(1);
		list.add(2);
		insertionSort(list);
	}

}
