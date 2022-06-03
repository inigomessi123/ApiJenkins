package com.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;

public class Array2 {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader reader=new FileReader("C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\src\\test\\resources\\Array1.json");
		JSONParser jsonParser=new JSONParser();
		Object object=jsonParser.parse(reader);
		
		JSONObject j=(JSONObject)object;
		Object stuDetails = j.get("studentDetails");
		System.out.println(stuDetails);
		
		//object convert into Array
		JSONArray a=(JSONArray)stuDetails;
		
		for (int i = 0; i < a.size(); i++) {
			Object eachStudentDetails=a.get(i);
			
			JSONObject j2=(JSONObject)eachStudentDetails;
			System.out.println(j2.get("firstName"));
			System.out.println(j2.get("course"));
			System.out.println(j2.get("address"));
			
		}
		
	}

}
