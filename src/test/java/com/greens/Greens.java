package com.greens;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.endpoints.EndPoints;

import io.restassured.response.Response;


public class Greens extends BaseClass{
	Response response;
	public void login() throws IOException {
		addHeader("Conten-Type", "application/json");
		basicAuth(getPropertyValue("userName"), getPropertyValue("passWord"));
		Response response=requestType("POST",EndPoints.LOGIN);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		
		String bodyAsString = getBodyAsString(response);
		System.out.println(bodyAsString);
		
	}
	public static void main(String[] args) throws IOException {
		Greens g=new Greens();
		g.login();
	}

}
