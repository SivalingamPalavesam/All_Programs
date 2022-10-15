package com.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindChar {

	public static void main(String[] args) //aabcbccddddeed
	{
		String s = "aabcbccddddeed";
		char[] ch = s.toCharArray();;

		Map<Character , Integer>  map = new HashMap<>();

		for(int i = 0 ; i < ch.length ; i++)
		{
			if(map.containsKey(ch[i]))
			{
				int count=map.get(ch[i]);
				map.put(ch[i], count+1);
			}
			else
			{
				map.put(ch[i], 1);
			}
		}
		System.out.println("All Values  "+map);
		int maxValueInMap=(Collections.max(map.values()));  
		for (Entry<Character, Integer> entry : map.entrySet())
		{  
			if(entry.getValue()==maxValueInMap) 
			{
				System.out.println("The High value is  :"+entry.getKey() +" "+entry.getValue());    
			}
		}
	}
}