package com.api;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SampleApi {
	public static void main(String[] args) throws FileNotFoundException {
		//mention the path of json file  
		FileReader reader=new FileReader("C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\src\\test\\resources\\sample.json");
		
		//create object for jsonparse class
		JsonParser jasonParser=new JsonParser();
		
		//parse the json file to fetch the values from json 
		Object object=JsonParser.parseReader(reader);
		
		//convert to json object-->class casst
		JsonObject j=(JsonObject)object;
		
		//Retrive the datas
		JsonElement objName = j.get("name");
		System.out.println(objName);
		
		JsonElement objEmail = j.get("email");
		System.out.println(objEmail );
	}

}
