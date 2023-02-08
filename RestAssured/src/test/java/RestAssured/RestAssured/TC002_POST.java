package RestAssured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST {
	
	@SuppressWarnings("unchecked")
	@Test
	public void APIHeader() {
		
		//URI 
		RestAssured.baseURI="https://reqres.in/api";
		
		//Rest object 
		RequestSpecification httprequest = RestAssured.given();
		
		// Response Object 

		//Defining parameters 
		JSONObject requestparam = new JSONObject();
		
		requestparam.put("name", "Sahil");
		requestparam.put("last_name", "Shaikh");
		requestparam.put("email", "Shaikh@gmail.com");
		
		//Defining Header type
		httprequest.header("Content-Type", "application/json");
		
		//COnverting String to JSON
		httprequest.body(requestparam.toJSONString());
		

		Response response = httprequest.request(Method.POST, "/users");
		
		
		String GetBody= response.getBody().asString();
		System.out.println("The response is " + GetBody);
		
		int StatusCode=response.getStatusCode();
		System.out.println("THe status code is " + StatusCode);
	}  
}
