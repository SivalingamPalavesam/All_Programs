package com.java;

import java.util.HashMap;
import java.util.Map;

class HasmapExample
{
	private int id ;

	private String browser;

	private String Speed;

	private int year;

	public HasmapExample(String browser, String Speed, int year) {

		this.browser = browser;
		this.Speed = Speed;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getSpeed() {
		return Speed;
	}

	public void setSpeed(String speed) {
		Speed = speed;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
public class ConsHashMap
{
	public static void main(String[] args) 
	{
		Map<Integer ,HasmapExample> map = new HashMap<>();

		HasmapExample frs = new HasmapExample("google","5.2",2007);
		HasmapExample sec = new HasmapExample("Internet Explore","3.0",1995);
		HasmapExample trd = new HasmapExample("Duck duck go","5",2015);

		map.put(1, frs);
		map.put(2, sec);
		map.put(3, trd);

		for(Map.Entry<Integer ,HasmapExample>  obj :map.entrySet())
		{
			int key  = obj.getKey();
			HasmapExample val = obj.getValue();
			System.out.print(key+" Details:"); 
			System.out.printf(val.getBrowser(),val.getSpeed(),val.getSpeed() );
		}
	}
}
