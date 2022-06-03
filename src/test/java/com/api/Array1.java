package com.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Array1 {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader reader=new FileReader("C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\src\\test\\resources\\Array.json");
		JSONParser parser=new JSONParser();
		Object object=parser.parse(reader);
		JSONObject j=(JSONObject)object;
		
		Object course = j.get("course");
		System.out.println(course);
		// json Array
		JSONArray a=(JSONArray)course;
		System.out.println(a);
		
		int size=a.size();
		System.out.println(size);
		Object o=a.get(1);
		System.out.println(o);
		
		for (int i = 0; i < size; i++) {
			System.out.println(a.get(i));
			
		}
		
	}

}
