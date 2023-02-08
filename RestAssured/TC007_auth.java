package RestAssured.RestAssured;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_auth {

	
	public void authentication() {
		
			

		//base URI
		RestAssured.baseURI="https://reqres.in/api";
		
		PreemptiveBasicAuthScheme authsch = new PreemptiveBasicAuthScheme();
		
		authsch.setUserName("eve.holt@reqres.in");
		authsch.setPassword("cityslicka");
		RestAssured.authentication=authsch;
		
		//rest object 
		RequestSpecification httprequest= RestAssured.given();
		
		//response object 
		Response response= httprequest.request(	Method.POST, "/login");
		
		response.getBody().asString();
		
		System.out.println("THe response is " + response);
		int responseCode= response.getStatusCode();
		
		Assert.assertEquals(responseCode, 200);
		
		
		
		
		
		
	}
}


