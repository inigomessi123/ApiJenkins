package com.greens;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.endpoints.EndPoints;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class JsonPath extends BaseClass {
	static String logtoken;
	static String msg;
	
	@Test(priority=1)
	public void Login() throws IOException, ParseException {
		addHeader("Content-Type", "application/json");
		basicAuth(getPropertyValue("userName"), getPropertyValue("passWord"));
		Response response=requestType("POST",EndPoints.LOGIN);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		
		String bodyAsString = getBodyAsString(response);
		System.out.println(bodyAsString);
		
		JSONParser jsonParser=new JSONParser();
		Object parse = jsonParser.parse(bodyAsString);
		System.out.println(parse);
		
		//read message
		
		JSONObject jsonObject=(JSONObject)parse;
		Object objectMsg = jsonObject.get("message");
		String msg=(String)objectMsg;
		
	Assert.assertEquals(msg, "Login successfully", "Verify Successfully Login");
	
	//last_name
	
	Object objectData = jsonObject.get("data");
	JSONObject jsonObject2=(JSONObject)objectData;
	Object objectLastName = jsonObject2.get("last_name");
	String lastName=(String)objectLastName;
	
	Assert.assertEquals(lastName, "RAJA","Verify lastname");
	 logtoken = JPath("data.logtoken", response);
	
		
	}
	@Test(priority=2)
	public void addAddress() {
		System.out.println(logtoken);
		//1.add Headers
		List <Header>header=new ArrayList<>();
		
		Header h1=new Header("Content-Type", "application/json");
		Header h2=new Header("Authorization", "Bearer "+logtoken);
		
		header.add(h1);
		header.add(h2);
		
		Headers headers=new Headers(header);
		addHeaders(headers);
		
		//2.body
		addPayLoad("{\r\n" + 
				"  \"first_name\": \"INIGO\",\r\n" + 
				"  \"last_name\": \"RAJA\",\r\n" + 
				"  \"mobile\": \"9585040707\",\r\n" + 
				"  \"apartment\": \"apartment\",\r\n" + 
				"  \"state\": 33,\r\n" + 
				"  \"city\": 3378,\r\n" + 
				"  \"country\": 101,\r\n" + 
				"  \"zipcode\": \"202020\",\r\n" + 
				"  \"address\": \"8/144,East Street,H.R>kottai\",\r\n" + 
				"  \"address_type\": \"home\"\r\n" + 
				"}");
		
		//3.Method type
		
		Response method1 = requestType("POST", EndPoints.ADD_ADDRESS);
		System.out.println(getResponseCode(method1));
		System.out.println(getBodyAsString(method1));
		
		 msg = JPath("address_id", response);
	String message = JPath("message", response);
		Assert.assertEquals(message, "Address added successfully","Verify address added successfully");
		
		}
	@Test(priority=3)
	public void updateAddress() {
		System.out.println(msg);
		//1.add Headers
				List <Header>header=new ArrayList<>();
				
				Header h1=new Header("Content-Type", "application/json");
				Header h2=new Header("Authorization", "Bearer "+logtoken);
				
				header.add(h1);
				header.add(h2);
				
				Headers headers=new Headers(header);
				addHeaders(headers);

		//2.body
				addPayLoad("{\r\n" + 
						"  \"address_id\": \""+msg+"\",\r\n" + 
						"  \"first_name\": \"Raj\",\r\n" + 
						"  \"last_name\": \"Khundra\",\r\n" + 
						"  \"mobile\": \"1234567898\",\r\n" + 
						"  \"apartment\": \"apartment\",\r\n" + 
						"  \"state\": 33,\r\n" + 
						"  \"city\": 3378,\r\n" + 
						"  \"country\": 101,\r\n" + 
						"  \"zipcode\": \"202020\",\r\n" + 
						"  \"address\": \"64/63 partap nagar\",\r\n" + 
						"  \"address_type\": \"home\"\r\n" + 
						"}");
				
				//3.Method type
				
				Response method2 = requestType("PUT", EndPoints.UPDATE_ADDRESS);
				System.out.println(getResponseCode(method2));
				System.out.println(getBodyAsString(method2));
				
				String message = JPath("message", response);
				Assert.assertEquals(message, "Address updated successfully","Verify address update sucessfully");
		
	}
	@Test(priority=4)
	public void getAddress() {
	//1.add Headers
		List <Header>header=new ArrayList<>();
		
		Header h1=new Header("Content-Type", "application/json");
		Header h2=new Header("Authorization", "Bearer "+logtoken);
		
		header.add(h1);
		header.add(h2);
		
		Headers headers=new Headers(header);
		addHeaders(headers);

			
						//3.Method type
				
				Response method1 = requestType("GET", EndPoints.GET_ADDRESS);
				System.out.println(getResponseCode(method1));
				System.out.println(getBodyAsString(method1));
				
				String message = JPath("message", response);
				Assert.assertEquals(message, "OK","Verify it's ok");
		
	}

	@Test(priority=5)
	public void deleteAddress() {
	//1.add Headers
		List <Header>header=new ArrayList<>();
		
		Header h1=new Header("Content-Type", "application/json");
		Header h2=new Header("Authorization", "Bearer "+logtoken);
		
		header.add(h1);
		header.add(h2);
		
		Headers headers=new Headers(header);
		addHeaders(headers);

	//2.body
		addPayLoad("{\r\n" + 
				"  \"address_id\": \""+msg+"\"\r\n" + 
				"}");
		
		
	//3.Method type
				
		Response method1 = requestType("DELETE", EndPoints.DELETE_ADDRESS);
		System.out.println(getResponseCode(method1));
	    System.out.println(getBodyAsString(method1)); 
				
	String message = JPath("message", response);
	Assert.assertEquals(message, "Address deleted successfully","Verify Address deleted successfully");
		
	}	

}
