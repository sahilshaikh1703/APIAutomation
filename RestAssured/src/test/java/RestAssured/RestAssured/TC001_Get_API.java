package RestAssured.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_Get_API {

	
		/**
		 * 
		 */
		@Test
	void checkWaether (){
			
			//base URI
			RestAssured.baseURI="https://reqres.in/api";
			
			//rest object 
			RequestSpecification httprequest= RestAssured.given();
			
			//response object 
			Response response= httprequest.request(	Method.GET, "/users?page=2");
			
			//Print response in console 
				String responseBody= response.getBody().asString();
				//System.out.println("The response body is : " + responseBody);
				
				int StatusCode=response.getStatusCode();
				System.out.println("THe status code is " + StatusCode) ;
				
				String StatusLine= response.getStatusLine();
				System.out.println("The status line is " + StatusLine);
				httprequest.log().all();
				
				Assert.assertEquals(StatusCode, 200);
				Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");
	}
			
}
