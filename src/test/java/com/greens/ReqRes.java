package com.greens;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.endpoints.EndPoints;

import io.restassured.response.Response;

public class ReqRes extends BaseClass {
	@Test
	public void tc01() throws ParseException {
		addHeader("Conten-Type", "application/json");
		Response response=requestType("GET",EndPoints.LOGIN1);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		
		String bodyAsString = getBodyAsString(response);
		System.out.println(bodyAsString);
		
		JSONParser jsonParser=new JSONParser();
		Object parse = jsonParser.parse(bodyAsString);
		System.out.println(parse);
		
	//read message
		
		JSONObject jsonObject=(JSONObject)parse;
		//String string = jsonObject.get("total").toString();
		
//method1
		 Object objectTotal = jsonObject.get("total");
		long total=(Long)objectTotal;
//		String valueOf = String.valueOf(total);
		
	Assert.assertEquals(total, 12, "Verify total");
	
	//last_name
	String lastName= JPath("data.last_name", response);
	System.out.println(lastName);
	
	}
	

}
