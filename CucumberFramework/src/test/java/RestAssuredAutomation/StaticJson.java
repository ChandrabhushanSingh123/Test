package RestAssuredAutomation;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.xml.fastinfoset.sax.Properties;

import File.PayLoad;
import File.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {
	/*
	 * public static void main(String[] args) { prop=new Properties();
	 * FileInputStream fis=null; try { fis=new FileInputStream(
	 * "//RESTAssuredTest//src//main//java//TestFramework//env.properties"); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); }
	 * 
	 * System.out.println(); }
	 */
	
	  String response;
	  
	  @Test public void addBook() {
	  
	  RestAssured.baseURI="http://216.10.245.166";
	  
	  try { response = given().header("Content-Type","application/json").body(
	  GenerateStringFromResource("C:\\Users\\CHA\\Addbookdetails.Json"))
	  .when().post("Library/Addbook.php")
	  .then().log().all().assertThat().statusCode(200).extract().response().
	  asString(); } catch (IOException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); }
	  
	  JsonPath Js1=ReusableMethod.rawToJson(response); String id=Js1.get("ID");
	  System.out.println(id);
	  
	  }
	  //As an input parameter we need to paas the path of the Json file store in the hard disk
	  @Test public static String GenerateStringFromResource(String path) throws
	  IOException {
	  
	  return new String(Files.readAllBytes(Paths.get(path))); }
	 
}
