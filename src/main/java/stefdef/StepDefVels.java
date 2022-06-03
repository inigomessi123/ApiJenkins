package stefdef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.endpoints.EndPoints;
import com.greens.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class StepDefVels extends BaseClass{
	static String logtoken;
	static String msg;
	Response response;
	String bodyAsString;
	Object parse;
	JSONObject jsonObject;
	
	@Given("user should add header with authendication")
	public void user_should_add_header_with_authendication() {
		addHeader("Content-Type", "application/json");
}

	@When("user should give username and password")
	public void user_should_give_username_and_password() throws IOException {
		basicAuth(getPropertyValue("userName"), getPropertyValue("passWord"));
}

	@Then("user should send post request")
	public void user_should_send_post_request() {
		 response=requestType("POST",EndPoints.LOGIN);
}

	@Then("user should verify status code is {int}")
	public void user_should_verify_status_code_is(int value) {
		int responseCode = getResponseCode(response);
		Assert.assertEquals(responseCode,value);
		
	}

	@Then("user should verify response body")
	public void user_should_verify_response_body() {
		 bodyAsString = getBodyAsString(response);
		System.out.println(bodyAsString);
}

	@Then("user print json object")
	public void user_print_json_object() throws ParseException {
		JSONParser jsonParser=new JSONParser();
		parse = jsonParser.parse(bodyAsString);
		System.out.println(parse);
}


	@Then("user should read the message")
	public void user_should_read_the_message() {

		//read message
	
	 jsonObject=(JSONObject)parse;
	Object objectMsg = jsonObject.get("message");
	
	System.out.println(objectMsg);
	msg=(String)objectMsg;
	
}

	@Then("user should check login successfully with assert condition")
	public void user_should_check_login_successfully_with_assert_condition() {
		
		
		Assert.assertEquals(msg, "Login successfully", "Verify Successfully Login");
		//last_name

		Object objectData = jsonObject.get("data");
		JSONObject jsonObject2=(JSONObject)objectData;
		Object objectLastName = jsonObject2.get("last_name");
		String lastName=(String)objectLastName;

		Assert.assertEquals(lastName, "RAJA","Verify lastname");

	  }

	@Then("user should print the logtoken")
	public void user_should_print_the_logtoken() {
		logtoken = JPath("data.logtoken", response);

	    
	}

//Add Address
	
@Given("user should add headers with authendication")
public void userShouldAddHeadersWithAuthendication() {
	//1.add Headers
			List <Header>header=new ArrayList<>();
			
			Header h1=new Header("Content-Type", "application/json");
			Header h2=new Header("Authorization", "Bearer "+logtoken);
			
			header.add(h1);
			header.add(h2);
			
			Headers headers=new Headers(header);
			addHeaders(headers);
			

}

@When("user should addpayload")
public void userShouldAddpayload() {
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

}

@Then("user should send post request with endpoints")
public void userShouldSendPostRequestWithEndpoints() {
	 response = requestType("POST", EndPoints.ADD_ADDRESS);
	System.out.println(getResponseCode(response));
	System.out.println(getBodyAsString(response));

}

@Then("user should read the message and check the addaddress successfully with assert condition")
public void userShouldReadTheMessageAndCheckTheAddaddressSuccessfullyWithAssertCondition() {
	 msg = JPath("address_id", response);
		String message = JPath("message", response);
			Assert.assertEquals(message, "Address added successfully","Verify address added successfully");
			
}

//Update Address

@Given("user should add headers with authendication in update address")
public void userShouldAddHeadersWithAuthendicationInUpdateAddress() {
	//1.add Headers
	List <Header>header=new ArrayList<>();
	
	Header h1=new Header("Content-Type", "application/json");
	Header h2=new Header("Authorization", "Bearer "+logtoken);
	
	header.add(h1);
	header.add(h2);
	
	Headers headers=new Headers(header);
	addHeaders(headers);

}

@When("user should addpayload in update Address")
public void userShouldAddpayloadInUpdateAddress() {
	//2.body
	addPayLoad("{\r\n" + 
			"  \"address_id\": \""+msg+"\",\r\n" + 
			"  \"first_name\": \"Inigo\",\r\n" + 
			"  \"last_name\": \"Raja\",\r\n" + 
			"  \"mobile\": \"1234567898\",\r\n" + 
			"  \"apartment\": \"apartment\",\r\n" + 
			"  \"state\": 47,\r\n" + 
			"  \"city\": 3378,\r\n" + 
			"  \"country\": 101,\r\n" + 
			"  \"zipcode\": \"202020\",\r\n" + 
			"  \"address\": \"64/63 partap nagar\",\r\n" + 
			"  \"address_type\": \"home\"\r\n" + 
			"}");
	


}

@Then("user should send put request with endpoints")
public void userShouldSendPutRequestWithEndpoints() {
	//3.Method type
	
	 response = requestType("PUT", EndPoints.UPDATE_ADDRESS);
	System.out.println(getResponseCode(response));
	System.out.println(getBodyAsString(response));
	

}

@Then("user should read the message and check the update address successfully with assert condition")
public void userShouldReadTheMessageAndCheckTheUpdateAddressSuccessfullyWithAssertCondition() {
	String message = JPath("message", response);
	Assert.assertEquals(message, "Address updated successfully","Verify address update sucessfully");

}

//Get Address

@Given("user should add headers with authendication in get address")
public void userShouldAddHeadersWithAuthendicationInGetAddress() {
	//1.add Headers
		List <Header>header=new ArrayList<>();
		
		Header h1=new Header("Content-Type", "application/json");
		Header h2=new Header("Authorization", "Bearer "+logtoken);
		
		header.add(h1);
		header.add(h2);
		
		Headers headers=new Headers(header);
		addHeaders(headers);


}

@When("user should send get request with endpoints")
public void userShouldSendGetRequestWithEndpoints() {
	//3.Method type
	
	 response = requestType("GET", EndPoints.GET_ADDRESS);

}

@Then("user should verify the status code is {int}")
public void userShouldVerifyTheStatusCodeIs(Integer int1) {
	System.out.println(getResponseCode(response));
	System.out.println(getBodyAsString(response));


}

@Then("user should read the message and check the OK with assert condition")
public void userShouldReadTheMessageAndCheckTheOKWithAssertCondition() {
	String message = JPath("message", response);
	Assert.assertEquals(message, "OK","Verify it's ok");


}

//Delete Address

@Given("user should add headers with authendication in delete address")
public void userShouldAddHeadersWithAuthendicationInDeleteAddress() {
	//1.add Headers
			List <Header>header=new ArrayList<>();
			
			Header h1=new Header("Content-Type", "application/json");
			Header h2=new Header("Authorization", "Bearer "+logtoken);
			
			header.add(h1);
			header.add(h2);
			
			Headers headers=new Headers(header);
			addHeaders(headers);

}

@When("user should addpayload in delete Address")
public void userShouldAddpayloadInDeleteAddress() {
	//2.body
			addPayLoad("{\r\n" + 
					"  \"address_id\": \""+msg+"\"\r\n" + 
					"}");
			

}

@Then("user should send delete request with endpoints")
public void userShouldSendDeleteRequestWithEndpoints() {
	
	//3.Method type
				
		 response = requestType("DELETE", EndPoints.DELETE_ADDRESS);
		System.out.println(getResponseCode(response));
	    System.out.println(getBodyAsString(response)); 


}

@Then("user should read the message and check the delete address successfully with assert condition")
public void userShouldReadTheMessageAndCheckTheDeleteAddressSuccessfullyWithAssertCondition() {
	String message = JPath("message", response);
	Assert.assertEquals(message, "Address deleted successfully","Verify Address deleted successfully");
		

}




}
