package com.studentapp.junit.studentsinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;

@RunWith(SerenityRunner.class)  //Comment this line if you want to run the test with Junit Runner
public class FirstSerenityTest1 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RestAssured.baseURI="http://localhost:8080/student";
	}

	@Test
	public void test() {
		//RestAssured.given() 
		SerenityRest.given() //run with this option if you want to see request/response in the output 
		.when()
		.get("/list")
		.then()
		.log().all()
		.statusCode(200);
	}
	//Method to print different type of result outcome
	@Test
	public void WrongErrCode() {
		//RestAssured.given() 
		SerenityRest.given() //run with this option if you want to see request/response in the output 
		.when()
		.get("/list")
		.then()
		.log().all()
		.statusCode(500);
	}
	@Pending
	@Test
	public void thisIsAPendingTest() {
		
	}
	@Ignore
	@Test
	public void thisIsASkippedTest(){
		
	}

	@Test
	public void thisIsAtestWithError(){
		System.out.println("This is an error"+(5/0));
	}
	
	@Test
	public void fileDoesNotExist() throws FileNotFoundException{
		File file = new File("E://file.txt");
		FileReader fr = new FileReader(file);
	}
	
	@Manual //Which ever test we cannot automate we can tag it as manual
	@Test
	public void thisIsAManualTest() {
	
	}
}
