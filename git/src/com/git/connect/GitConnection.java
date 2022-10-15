package com.git.connect;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class GitConnection 
{
	public static void main(String[] args) throws IOException 
	{
		String link = "https://raw.githubusercontent.com/gowtham2509/Git-Connection/main/src/BasicProgram/ReverseString.java";
		URL url = new URL(link);
		System.out.println(url);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		System.out.println(http);
		Map<String, List<String>> head = http.getHeaderFields();
		System.out.println(head);
		for (String header : head.get(null)) 
		{
			if (header.contains(" 302 ") || header.contains(" 301 "))
			{
				link = head.get("Location").get(0);
				System.out.println(link);
				url = new URL(link);
				System.out.println(url);
				http = (HttpURLConnection) url.openConnection();
				System.out.println(http);
				head = http.getHeaderFields();
				System.out.println(head);
			}
		}
		InputStream stream = http.getInputStream();
		System.out.println(stream);
		String response = getStringFromStream(stream);
		System.out.println(response);
	}
	private static String getStringFromStream(InputStream Stream) throws IOException 
	{
		if (Stream != null)
		{
			Writer writer = new StringWriter();
			System.out.println(writer);
			char[] buffer = new char[2048];
			System.out.println(buffer);
			try {
				Reader reader = new BufferedReader(new InputStreamReader(Stream, "UTF-8"));
				System.out.println(reader);
				int counter;
				
				while ((counter = reader.read(buffer)) != -1) 
				{
					System.out.println(counter);
					writer.write(buffer, 0, counter);
				}
			} finally 
			{
				Stream.close();
			}
			return writer.toString();
		} 
		else 
		{
			return "No Contents";
		}
	}

}
