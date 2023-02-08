package RestAssured.RestAssured;

import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
import org.junit.runner.Request;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Save_Headers {

	@Test
	public void GetHeaders() {

		// base URI
		RestAssured.baseURI = "https://reqres.in/api";

		// rest object
		RequestSpecification httprequest = RestAssured.given();

		// response object
		Response response = httprequest.request(Method.GET, "/users?page=2");

		String BodyResponse = response.getBody().asString();
		System.out.println("The response is " + response);

		Headers AllHeaders = response.getHeaders();

		for (Header header : AllHeaders) {

			System.out.println("All  Heasders details are " + header.getName() + "    " + header.getValue());

		}

	}

}
