package com.java;

import java.util.LinkedHashMap;

public class LinkedHashMapExample
{
	public static void main(String args[])
	{
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>(); 
		map.put(1,"siva");
		map.put(2, null);
		map.put(3, "sri");
		map.put(4, "kavi");
		map.put(1, "Mani");
		System.out.println("Key   :"+map.keySet());
		
		System.out.println("Value  :"+map.values());
		
		System.out.println("key -pair value  :"+map.entrySet());
	}
}
