package RestAssured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@Test (dataProvider="Empdata")
public class DataProvider {

	public void APIDataProvider(String Name, String Leader) {

		// base URI
		RestAssured.baseURI = "https://reqres.in/api";

		RequestSpecification httprequest = RestAssured.given();

		JSONObject jsonobject = new JSONObject();

		jsonobject.put("name", Name);
		jsonobject.put("leader", Leader);

		httprequest.header("Content-TYpe", "application/json");

		httprequest.body(jsonobject.toJSONString());

		// response object
		Response response = httprequest.request(Method.POST, "/users?page=2");
		
		String responsebody = response.getBody().asString();
		
		System.out.println("The response is " + responsebody);

	}

	@org.testng.annotations.DataProvider(name = "Empdata")
	String[][] GetData() {
			
		String path = "E:\\api automation\\SampleData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colNum = XLutils.getColCount(path,"Sheet1");
		
		
		String SampleData [] [] = new String[rownum][colNum];
		
		
		for (int i =0 ; i<=rownum; i++ ) {
			for (int j=0; j< colNum; j++ ) {
					SampleData[i-1][j] = XLUtils.getCellData(path, "Sheet1" , i , j );
				
			} 
		} 

		String GetData[][] = { { "sahil", "QA" }, { "mariam", "eDev" }, { "Moon", "Analysist" } };
		return GetData;

	}
}
