package RestAssured.RestAssured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_GetHeader {

	
		@Test
		public void APIHeaders () {
				
			
			RestAssured.baseURI="https://reqres.in/api";
			
			RequestSpecification httprequest = RestAssured.given();
			
			Response response = httprequest.request(Method.GET, "/id=2");
			
			
			String getBody = response.getBody().toString();
			System.out.println("THe response body is "+ getBody) ;
			
			Headers AllHeaders= response.headers();
			System.out.println("THe headers are " + AllHeaders);
			
			
			String Connection= response.header("Connection");
			System.out.println("Connection tyoe is " + Connection);
			Assert.assertEquals("Connection", "Connection");
			
			String ContentLength= response.header("Content-Length");
			System.out.println("Connection tyoe is " + ContentLength);
			assertEquals("ContentLength", "ContentLength");
			
			String ContentType= response.header("Content-Type");
			System.out.println("Connection tyoe is " + ContentType);
	
			
			String Server= response.header("Server");
			System.out.println("Connection tyoe is " + Server);
			
			assertEquals("Connection", "Connection");
			
		}
		
	}

