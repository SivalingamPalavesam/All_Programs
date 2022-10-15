package com.java.string;

import java.util.Scanner;

public class CaesarCipherRotation {

	public static String Caesar(int n,String s,int k)
	{
		 StringBuilder obj = new StringBuilder();
         
	        if(k>=26)
	        {
	            k =k%26;
	        }
	        for(int i =0 ; i<n;i++)
	        {
	            int ascii =s.charAt(i);
	            
	            if(ascii>=65 & ascii<=90-k || ascii>=97 & ascii<=122-k)
	            {
	               obj.append(((char)(ascii+k))); 
	            }
	            else if(ascii >122-k & ascii<=122)
	            {
	               obj.append((char)(96+(k-(122-ascii))));
	            }
	            else if(ascii >90-k & ascii<=90)
	            {
	                obj.append((char)(64+(k-(90-ascii))));
	            }
	            else
	            {
	               obj.append(s.charAt(i));
	            }
	            
	        }
	        System.out.println(obj);
	        return  obj.toString();

	     }
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String s ="middle-Outz";
		int k =2;
		Caesar(s.length(),s, k);
		
	}

}
