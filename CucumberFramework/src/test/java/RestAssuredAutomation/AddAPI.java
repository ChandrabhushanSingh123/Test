package RestAssuredAutomation;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; //responsible for validating body in given response

import com.github.fge.jsonschema.main.cli.Main;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import File.PayLoad;
import File.ReusableMethod;
public class AddAPI {

	public static void main(String[] args) {
		//Given() it is used to provide the input data
		//When() used to perform action
		//Then() used to verify the response
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response =given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(PayLoad.addPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String PlaceID=js.getString("place_id");
		System.out.println(PlaceID);
		String upDatedAdd="70 Summer walk, USA";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body("{\r\n" + 
				"\"place_id\":\""+PlaceID+"\",\r\n" + 
				"\"address\":\"70 Summer walk, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//Get Place
		String getPlaceResponse;
		getPlaceResponse=given().log().all().queryParam("key","qaclick123").queryParam("place_id",PlaceID)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		JsonPath Js1=ReusableMethod.rawToJson(getPlaceResponse);
		String newAddress=Js1.getString("address");
		System.out.println(newAddress);
	//	Assert.assertEquals(upDatedAdd, newAddress);
		
	}

}
