package com.java;

import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) 
	{
		HashMap<String , Integer> map = new HashMap<>();
		
		map.put("siva", 100);
		map.put("sri", 101);
		map.put("king", 102);
		System.out.println(map);
		
		map.putIfAbsent("kavi", 104);
		System.out.println(map);
		
		map.put("sri", 105);
		System.out.println("Updated  :"+map);
	}

}
