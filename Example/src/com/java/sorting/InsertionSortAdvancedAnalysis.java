package com.java.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortAdvancedAnalysis 
{
	public static int insertionSort(int[] arr)
	{
		int count=0,i ,j = 0;
		for( i  =1 ;i < arr.length;i++) //2 1 3 1 2
		{
			for(j = i ; j > 0 ; j--)
			{
				if(arr[j] < arr[j-1])
				{					
					int temp = arr[j];
					arr[j]   = arr[j-1];
					arr[j-1] = temp;
					count++;	
				}else
				{
					break;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("The Count Value is  :"+count);
		//printArray( arr);
		return count;
	}

	public static void main(String[] args)
	{
		int[] arr = new int[5];
		Scanner input = new Scanner(System.in);
		for(int i = 0 ;i<5;i++)
		{
			arr[i] = input.nextInt();
		}
		insertionSort(arr);
	}
//	 private static void printArray(int[] arr) {
//	      for(int n: arr){
//	         System.out.print(n+" ");
//	      }
//	        System.out.println("");
//	   }

}
