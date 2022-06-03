Feature: Velsbusinessclub API automation scripting using Rest Assured

Scenario: Verify user able to login Successfully
Given user should add header with authendication
When user should give username and password
Then user should send post request
And  user should verify status code is 200
Then user should verify response body
Then user print json object
And user should read the message
Then user should check login successfully with assert condition
Then user should print the logtoken

Scenario: Verify user able to AddAddress Successfully
Given user should add headers with authendication
When user should addpayload
Then user should send post request with endpoints
And user should read the message and check the addaddress successfully with assert condition

Scenario: Verify user able to UpdateAddress Successfully
Given user should add headers with authendication in update address
When user should addpayload in update Address
Then user should send put request with endpoints
And user should read the message and check the update address successfully with assert condition

Scenario: Verify user able to GetAddress Successfully
Given user should add headers with authendication in get address
When user should send get request with endpoints
Then user should verify the status code is 200
And user should read the message and check the OK with assert condition

Scenario: Verify user able to DeleteAddress Successfully
Given user should add headers with authendication in delete address
When user should addpayload in delete Address
Then user should send delete request with endpoints 
And user should read the message and check the delete address successfully with assert condition


