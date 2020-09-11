package com.studentapp.cucumber.steps;

import java.util.HashMap;
import java.util.List;

import com.studentapp.model.StudentClass;
import com.studentapp.utils.ReusableSpecifications1;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;


public class StudentSteps1 {
	
	@Step("Creating student with firstName:{0},lastName:{1}, email:{2}, programme:{3},Courses:{4}")
	public ValidatableResponse createStudent(String firstName,String lastName,String email,String programme, List<String> myList) {
		StudentClass st=new StudentClass();
		st.setFirstName(firstName);
		st.setLastName(lastName);
		st.setEmail(email);
		st.setProgramme(programme);
		st.setCourses(myList);
		return SerenityRest.rest().given()
		.spec(ReusableSpecifications1.getGenericRequestSpec())
		.log()
		.all()
		.when()
		.body(st)
		.post()
		.then();
	}
	@Step("Getting the student information with the firstName:{0}")
	public HashMap<String,Object> getStudentByFirstName(String firstName){
		String p1="findAll{it.firstName=='";
		String p2="'}.get(0)";
	    return SerenityRest.rest().given()
	    .when().get("/list")
		.then().log().all().extract()
		.path(p1+firstName+p2);
	}
	
	@Step("Updating student with studentId:{0}, firstName:{1},lastName:{2}, email:{3}, programme:{4},Courses:{5}")
	public ValidatableResponse updateStudent(int studentId, String firstName,String lastName,String email,String programme, List<String> myList) {
		StudentClass st=new StudentClass();
		st.setFirstName(firstName);
		st.setLastName(lastName);
		st.setEmail(email);
		st.setProgramme(programme);
		st.setCourses(myList);
		return SerenityRest.rest().given()
		.spec(ReusableSpecifications1.getGenericRequestSpec())
		.log()
		.all()
		.when()
		.body(st)
		.put("/"+studentId)
		.then();
	}
	@Step("Delete the student info with StudentId:{0}")
	public ValidatableResponse deleteStudentById(int studentId){
	    return SerenityRest.rest().given()
	    		.when().delete("/"+studentId)
	    		.then().log().all();	
	}
	@Step("Get the student info with StudentId:{0}")
	public ValidatableResponse getStudentById(int studentId){
	    return SerenityRest.rest().given()
	    		.when().get("/"+studentId)
	    		.then().log().all();	
	}
	
}
