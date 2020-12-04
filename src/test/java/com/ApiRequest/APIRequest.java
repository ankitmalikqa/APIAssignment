package com.ApiRequest;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.util.Scanner;
import com.utils.*;
//import io.restassured.specification.RequestSpecification;


public class GetRequest {
	
	utility utils = new utility();
	
	@BeforeClass
	public void initialize() throws FileNotFoundException {
		
		String url = utils.getURL();
		System.out.println("yes I'm in");
		
	   RestAssured.baseURI=url;
	}
	
	@Test
	  public void getRequestPlanName() throws FileNotFoundException
	 {
	  
	
	  //Request object
	  Response response=RestAssured.given().request(Method.GET,"/api/v1/{planName}");
	  
	  //print response in console window
	  
	  String responsebody=response.getBody().asString();
	  System.out.println("Response Body is:" +responsebody);
	  
	  //status code validation
	  
	  int statuscode =  response.getStatusCode();
	  System.out.println("Status code is: "+statuscode);
	  Assert.assertEquals(statuscode,200);

	  // status line validation
	  
	  String statusline = response.getStatusLine();
	  System.out.println("Status line is: "+statusline);
	  Assert.assertEquals(statusline,"HTTP/1.1 200 ");
	  
	  
	 }
	
	@Test
	public void postRequest()
	{
			
				// request object
				RequestSpecification httprequest = RestAssured.given();
				
				// response object 
			    JSONObject requestParams = new JSONObject(); // create object for jsonobject class
			     
			    // request payload sending via post 
			    requestParams.put("planName","Tours");
			    requestParams.put("city","Delhi");  
			    
			    httprequest.header("Content-Type","application/json"); // attach header (content type) to the request 
			  
			    httprequest.body(requestParams.toJSONString());    // attach data to the request
			    
			    // send request
			    Response response = httprequest.request(Method.POST,"/api/v1/create");
			    
			    
			    // store the response body 
			    
			    String responsebody = response.getBody().asString();
			    System.out.println("Response body is: "+responsebody);
			    
			    // validate status code
			     int statuscode = response.getStatusCode();
			     System.out.println("Status code is: "+statuscode);
		         Assert.assertEquals(statuscode,201);
		         
		       // validate status line 
		         String statusline = response.getStatusLine();
		         System.out.println("Status line is: "+statusline);
		         Assert.assertEquals(statusline,"HTTP/1.1 201 Created");
		          
		        // validate response body (json format)
		        
		        String name =  response.jsonPath().get("planName");
		        Assert.assertEquals(name,"Tours");
			    	
			}
	  
}

