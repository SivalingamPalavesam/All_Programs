package com.java.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSortReverse 
{

	public static void insertionSort(List<Integer> arr) 
	{
		int n = arr.size();
		int temp = arr.get(n-1);
        for(int i =arr.size()-2; i >=0; i--)
        {
            if(temp >= arr.get(i))
            {
                arr.set(i+1, temp);
                printArray(arr);
                break;
            }
            arr.set(i+1, arr.get(i));
            printArray(arr);
        }
        if(temp < arr.get(0))
        {
        	arr.set(0,temp)  ;
        	 printArray(arr);
	    }
	}
	public static void main(String[] args) 
	{
		List<Integer> arr = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		//System.out.println("Enter the Value  :");
	//for(int i = 0 ;i<5;i++)
	//	{
			arr.add(2);
			arr.add(3);
			arr.add(4);
			arr.add(5);
			arr.add(6);
			arr.add(7);
			arr.add(8);
			arr.add(9);
			arr.add(10);
			arr.add(1);
		//}
		 //System.out.println(arr);
		insertionSort(arr);
	}
	
	private static void printArray(List<Integer> arr) {
	      for(int n: arr){
	         System.out.print(n+" ");
	      }
	        System.out.println("");
	   }
}
