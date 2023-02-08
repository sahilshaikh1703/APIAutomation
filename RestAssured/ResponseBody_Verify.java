package RestAssured.RestAssured;

import org.junit.Assert;
import org.junit.runner.Request;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseBody_Verify {
	
		@Test
		public void VerifyResponse () {
			
			//base URI
			RestAssured.baseURI="https://reqres.in/api";
			
			//rest object 
			RequestSpecification httprequest= RestAssured.given();
			
			//response object 
			Response response= httprequest.request(	Method.GET, "/users?page=3");
			
			//Print response in console 
				String responseBody= response.getBody().asString();
				System.out.println("The response body is : " + responseBody);
				
				Assert.assertEquals(responseBody.contains("emma"), true);
				System.err.println("The resule us true ");
				
				// To verify body contain of the response 
				JsonPath jsonpath = response.jsonPath();
					
				System.out.println("First name is : /n" + jsonpath.get("first_name"));
				System.out.println(jsonpath.get("email"));
				System.out.println(jsonpath.get("last_name"));
				System.out.println(jsonpath.get("avatar"));
				
				Assert.assertEquals(jsonpath.get("first_name"), "fuchsia");
				
				
				
		
		}

}
