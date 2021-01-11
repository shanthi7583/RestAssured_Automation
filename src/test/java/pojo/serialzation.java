package pojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class serialzation {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		pojo po=new pojo();
		po.setAccuracy(50);
		po.setAddress("29, side layout, cohen 09");
		po.setName("Frontline house");
		po.setphone_number("+91) 983 893 3937");
		po.setWebsite("http://google.com");
		po.setLanguage("French-IN");
		
		List<String> mylist=new ArrayList<String>();
		mylist.add("shoepark");
		mylist.add("shop");
		po.setTypes(mylist);
		
		
	/*	loc lo=new loc();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		po.setLocat(lo);*/
		RequestSpecification resp=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123").build();
		ResponseSpecification response=new ResponseSpecBuilder().expectStatusCode(200).build();
		RequestSpecification res=given().spec(resp);
		Response re=res.body(po).when().post("/maps/api/place/add/json").
		then().spec(response).extract().response();
		String r=re.asString();
	System.out.println(r);

	
	}
	
	

	}


