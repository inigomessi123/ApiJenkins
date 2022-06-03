package com.api;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SingleUser {
	public static void main(String[] args) throws IOException, ParseException  {
		FileReader reader=new FileReader("C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\src\\test\\resources\\singleUser.json");
		
		JSONParser jsonParser=new JSONParser();
		
		Object object=jsonParser.parse(reader);
		
		JSONObject j=(JSONObject)object;
		
		//Retrive the datas
		
		Object objData = j.get("data");
		System.out.println(objData);
		Object sup = j.get("support");
		System.out.println(sup);
		
	
		JSONObject j1=(JSONObject)objData;
		Object id = j1.get("id");
		System.out.println(id);
		Object email = j1.get("email");
		System.out.println(email);
		Object firstName = j1.get("first_name");
		System.out.println(firstName);
		Object lastName = j1.get("last_name");
		System.out.println(lastName);
		Object avatar = j1.get("avatar");
		System.out.println(avatar);
		
		
		JSONObject j2=(JSONObject)sup;
		Object url = j2.get("url");
		System.out.println(url);
		
		Object text = j2.get("text");
		System.out.println(text);
		
		
	}

}
