package stepdefinition;

import static io.restassured.RestAssured.given;

import Resources.APIResources;
import Resources.Utils;
import Resources.testdata;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.types.selectors.SymlinkSelector;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.loc;
import pojo.pojo;


public class AddPlaceAPI extends Utils {	
	 RequestSpecification reqs;
	 io.restassured.specification.RequestSpecification res;
	 Response re;
	 String check;
	 String r;
	 testdata data=new testdata(); 	
	 static String place_id;
	 
 @Given("AddplaceAPI {string} {string} {string}")
 
public void AddplaceAPI(String name,String language,String address) throws FileNotFoundException {
	
	pojo po=new pojo();
	po.setAccuracy(50);
	po.setAddress(address);
	po.setName(name);
	po.setphone_number("+91) 983 893 3937");
	po.setWebsite("http://google.com");
	po.setLanguage(language);
	List<String> mylist=new ArrayList<String>();
	mylist.add("shoepark");
	mylist.add("shop");
	po.setTypes(mylist);
	
    loc lo=new loc();
	lo.setLat(-38.383494);
	lo.setLng(33.427362);
	po.setLocat(lo);

	response=new ResponseSpecBuilder().expectStatusCode(200).build();
	reqs=given().spec(RequestSpecification()).body(po);	
	
 }

@When("user calls {string} with {string} http request")
public void user_calls_with_post_http_request(String resource,String method) {
	
	APIResources resourceAPI=APIResources.valueOf("DeletePlaceAPI");
	System.out.println(resourceAPI.getresource());
	
	if(method.equalsIgnoreCase("POST"))
		re=reqs.when().post(resourceAPI.getresource());
	else if(method.equalsIgnoreCase("GET"))
		re=reqs.when().get(resourceAPI.getresource());

}

@Then("the API call got success with status code {int}")
public void the_api_call_got_success_with_status_code(Integer int1) {
	re.then().spec(ResponseSpecification()).extract().response();
		assertEquals(re.getStatusCode(),200);
		System.out.println(re.getStatusCode());
		r=re.asString();
		System.out.println(r);		
		
}

@Then("{string} in the response is {string}")
	public void in_the_response_is(String key1, String expected ) {
		System.out.println(key1);
	   System.out.println(expected);
		String r=re.asString();
	      JsonPath js=new JsonPath(r);
	       System.out.println(js);
	     assertEquals(js.get(key1).toString(),expected);    
	}

@Then("verify place_Id created maps to {string} using {string}")
public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {

   // requestSpec
     place_id=getJsonPath(re,"place_id");
	 res=given().spec(RequestSpecification()).queryParam("place_id",place_id);
	 user_calls_with_post_http_request(resource,"GET");
	  String actualName=getJsonPath(re,"name");
	  assertEquals(actualName,expectedName);
	 
    
}
@Given("DeletePlace Payload")
public void deleteplace_Payload() throws IOException {
    // Write code here that turns the phrase above into concrete actions
   
	res =given().spec(RequestSpecification()).body(data.deletePlacePayload(place_id));
}


	

}

	


