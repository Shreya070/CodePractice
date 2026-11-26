Feature: To test the get api feature




Scenario: To get user details

 Given url 'https://gorest.co.in/public/v2/users'
 And path '6850103'
 When method GET # Send the get request 
 Then status 200 # the status code response should be 200
  * print response