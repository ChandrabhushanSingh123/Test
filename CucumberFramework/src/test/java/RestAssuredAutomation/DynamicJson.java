package RestAssuredAutomation;

import static io.restassured.RestAssured.given;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import File.PayLoad;
import File.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider="BookData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json").body(PayLoad.addBook(isbn,aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath Js1=ReusableMethod.rawToJson(response);
		String id=Js1.get("ID");
		System.out.println(id);
		
	}
	
	@DataProvider(name="BookData")
	public Object[][] getData() {
		
		return new Object[][] {{"Abcd","226a1"},{"Abce","226a2"}};
		
	}
	

}
