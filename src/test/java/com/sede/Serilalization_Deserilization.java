package com.sede;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.endpoints.EndPoints;
import com.greens.BaseClass;
import com.pojo.AddAddress_output_pojo;
import com.pojo.AddAddress_pojo;
import com.pojo.Delete_output_pojo;
import com.pojo.Delete_pojo;
import com.pojo.Login_output_pojo;
import com.pojo.Update1_pojo;
import com.pojo.UpdateAddress_pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Serilalization_Deserilization extends BaseClass {
	 String logtoken;
	static String msg;
	static String address_id;
	
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
		
	//	JsonPath a = response.getBody().jsonPath();
	//	logtoken = a.get("data.logtoken").toString();
		
		Login_output_pojo as=response.as(Login_output_pojo.class);
		String mes = as.getMessage();
		System.out.println(mes);

	
	Assert.assertEquals(as.getMessage(), "Login successfully", "Verify Successfully Login");
	
	logtoken = as.getData().getLogtoken();
	 System.out.println(logtoken);
	
		
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
		
		
		
		AddAddress_pojo p2=new AddAddress_pojo("MESSI", "RONEY", "958504070707", "Apartment", 7, 77, 777, "624002", "HR KOTTAI", "HOME");
		
		//2.body
		addPayLoad(p2);
		
		//3.Method type
		
		Response response = requestType("POST", EndPoints.ADD_ADDRESS);
		System.out.println(getResponseCode(response));
		
		
		AddAddress_output_pojo p3 = response.as(AddAddress_output_pojo.class);
		
		System.out.println(getBodyAsString(response));
	    int ad = p3.getAddress_id();
	     address_id = String.valueOf(ad);
	 
	   System.out.println(address_id);
		
		Assert.assertEquals(p3.getMessage(), "Address added successfully","Verify address added successfully");
		
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
				
				UpdateAddress_pojo p4=new UpdateAddress_pojo("77", "RAM", "GOVIND", "987654321", "888", 8, 66, 55, "624002", "OMR", "HOSTEL");

		//2.body
				addPayLoad(p4);
				
				//3.Method type
				
				Response method2 = requestType("PUT", EndPoints.UPDATE_ADDRESS);
				
				System.out.println(getResponseCode(method2));
				System.out.println(getBodyAsString(method2));
				
				Update1_pojo p5 = method2.as(Update1_pojo.class);
				
				Assert.assertEquals(p5.getMessage(), "Address updated successfully","Verify address update sucessfully");
		
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
		
				
		Delete_pojo p6 = new Delete_pojo(address_id);

	//2.body
		addPayLoad(p6);
		
		
	//3.Method type
				
		Response method1 = requestType("DELETE", EndPoints.DELETE_ADDRESS);

		System.out.println(getResponseCode(method1));
	    System.out.println(getBodyAsString(method1)); 
				
	Delete_output_pojo a = method1.as(Delete_output_pojo.class);
	Assert.assertEquals(a.getMessage(), "Address deleted successfully","Verify Address deleted successfully");
		
	}	


}  
