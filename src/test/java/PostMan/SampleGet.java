package PostMan;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SampleGet {
	static RequestSpecification reqSpec;
	public static void main(String[] args) {
		//1.Initialize RestAssured
		reqSpec=RestAssured.given();
		//2.Mention the Header
		reqSpec = reqSpec.header("Content-Type", "application/json");
		//3.Mention the param-->Q
		 reqSpec = reqSpec.pathParam("page", "2");
		//4.Mention the method type
		Response response = reqSpec.get("https://reqres.in/api/users/{page}");
		//5.Get the Status code
		int statusCode = response.getStatusCode();
		//6.Get the responce body
		ResponseBody body = response.getBody();
		
		//Get String
		String asString = body.asString();
		System.out.println(asString);
		
		//Get the string as prettyformat
		String asPrettyString = body.asPrettyString();
		System.out.println(asPrettyString);
		
		
		
		
	}

}
