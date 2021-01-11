Feature: Validating Place API's
@AddPlaceAPI @Regression
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
Given AddplaceAPI "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "post" http request
Then the API call got success with status code 200
Then "status code" in the response is "200"
And verify place_Id created maps to "<name>" using "getPlaceAPI"

Examples:
|name|language|address|
|abcd|spanish|123,drive|
|efgch|fenglish|345,drive|
@Regression
Scenario:
Given DeleteplaceAPI
When user calls "DeletePlaceAPI" with "post" http request
Then the API call got success with status code 200
Then "status code" in the response is "200"
