package com.java.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort { 

	public static void insertionSort(int[] arr) 
	{
		for(int i = 1; i < arr.length; i++)
		{
			int value = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > value)
			{
				arr[j+1] = arr[j];
				j=j-1;
				//System.out.println(Arrays.toString(arr));
			}
			arr[j+1] = value;
		}
		System.out.println(Arrays.toString(arr));

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

}
