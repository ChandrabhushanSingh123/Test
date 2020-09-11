package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecifications1;
import com.studentapp.utils.TestUtils;
import com.studentapp.cucumber.steps.*;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //This is used to execute the methods in asc order
public class StudentsCRUDTest1 extends TestBase {
	//calling the static method getRandomValue() from other class
	
	static String firstName="Shambhu"+TestUtils.getRandomValue();
	static String lastName="Pandey"+TestUtils.getRandomValue();
	static String email=TestUtils.getRandomValue()+"Abc123@gmail.com"; 
	static String programme="Pure Science";
	static String firstSubject="Physic";
	static String secondSubject="Chemistry";
	static int studentId;
	
	@Steps
	StudentSteps1 steps; //We will have to define a varable of type class in which methods are defined.
	
	@Title("Adding the student details")
	@Test
	public void test001() {
		List<String> myList=new ArrayList<String>();
		myList.add(firstSubject);
		myList.add(secondSubject);			
		steps.createStudent(firstName, lastName, email, programme, myList)
		.statusCode(201)
		.spec(ReusableSpecifications1.getGenericResponseSpec());
	}
	@Title("Verifying the student details are getting added successfully")
	@Test
	public void test002() {
		steps.getStudentByFirstName(firstName);
	    studentId=(Integer) steps.getStudentByFirstName(firstName).get("id");
	  // assertThat(value,hasValue("firstName"));
	  System.out.println(steps.getStudentByFirstName(firstName).get("firstName"));
	  System.out.println(steps.getStudentByFirstName(firstName));
		
	}
	@Title("Updating the student details")
	@Test
	public void test003() {
		/* String p1="findAll{it.firstName=='";
		String p2="'}.get(0)"; */
		
		firstName=firstName+"_Updated";
		List<String> myList=new ArrayList<String>();
		myList.add("JAVA");
		myList.add("C++");
		steps.updateStudent(studentId, firstName, lastName, email, programme, myList)
		.statusCode(200);
		/* StudentClass st=new StudentClass();
		st.setFirstName(firstName);
		st.setLastName(lastName);
		st.setEmail(email);
		st.setProgramme(programme);
		List<String> myList=new ArrayList<String>();
		st.setCourses(myList);
		myList.add("JAVA");
		myList.add("C++");
		st.setCourses(myList);
		SerenityRest.rest().given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(st)
		.put("/"+studentId)
		.then().log().all()
		.statusCode(200); */
		//To verify that the record has been updated successfully.
	/*	HashMap<String,Object> value;
	    value=SerenityRest.rest().given()
		.when().get("/list")
		.then().log().all().extract()
		.path(p1+firstName+p2); */
	   System.out.println(steps.getStudentByFirstName(firstName));
	    //studentId=(Integer) value.get("id");
	// assertThat(value,hasValue(firstName));
	//System.out.println(value.get("firstName"));
	//System.out.println(value);
	}
	@Title("Deleting the student details")
	@Test
	public void test004() {
		/* SerenityRest.rest().given()
		.when().delete("/"+studentId)
		.then().log().all();	*/
		steps.deleteStudentById(studentId);
		//Verify that record has been deleted or not
		/* SerenityRest.rest().given()
		.when().get("/"+studentId)
		.then().log().all()*/
		steps.getStudentById(studentId)
		.statusCode(404);
		
	}
}
