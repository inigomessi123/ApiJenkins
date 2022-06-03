package com.greens;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.restassured.path.json.JsonPath;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response;
	public void addHeader(String key,String value) {
		 reqSpec = RestAssured.given().header(key,value);
	}
	public void pathParam(String key,String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}
	public void basicAuth(String userName,String passWord) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, passWord);
		
	}
	public void addPayLoad(String body) {
		reqSpec = reqSpec.body(body);
		
	}
	public void addPayLoad(Object body) {
		reqSpec = reqSpec.body(body);
		
	}

	public  Response requestType(String type,String endPoint) {
		
	switch (type) {
	
	case "GET":
		response = reqSpec.log().all().get(endPoint);
		
		break;
		
	case "POST":
		response = reqSpec.log().all().post(endPoint);
		break;
	case "PUT":
		response = reqSpec.log().all().put(endPoint);
		break;
	case "DELETE":
		response = reqSpec.log().all().delete(endPoint);
		break;

	default:
		break;
	}
	return response;
	}
	public int  getResponseCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	public ResponseBody getReqBody(Response response) {
		ResponseBody body = response.getBody();
		return body;
		
	}
	public String getBodyAsString(Response response) {
		String asString=getReqBody(response).asPrettyString();
		return asString;

	}
public String getPropertyValue(String key) throws IOException {
	FileInputStream stream=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\greens.properties");
	Properties properties=new Properties();
	properties.load(stream);
	Object object=properties.get(key);
	String s=(String)object;
	return s;
	
	}
public String JPath(String key,Response response) {
	 JsonPath jsonPath = getReqBody(response).jsonPath();
	String value = jsonPath.get(key).toString();
	
	System.out.println(value);
	return value;
	
	}
public int JPathNum(String key,Response response) {
	 JsonPath jsonPath = getReqBody(response).jsonPath();
	Object object = jsonPath.get(key);
	Integer value=(Integer)object;
	
	System.out.println(value);
	return value;
	
}
public void addHeaders(Headers headers) {
	reqSpec=RestAssured.given().headers(headers);
	
}
}