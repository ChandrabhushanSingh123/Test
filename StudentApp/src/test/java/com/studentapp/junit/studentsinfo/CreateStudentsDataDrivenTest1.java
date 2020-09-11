package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.studentapp.cucumber.steps.StudentSteps1;
import com.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

/*@Concurrent
Indicates that data-driven tests can and should be run in parallel.You can optionally indicate the number of threads to use. 
If not specified,a sensible value based on the number of processors will be used. 
In the above case 4 dataDriven test will run in parallel as we have two cores but in below case it will be 4*2=8 will run in parallel
*/
@Concurrent(threads="4x")
@UseTestDataFrom("testdata\\studentinfo1.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentsDataDrivenTest1 extends TestBase {
	
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private String course;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public StudentSteps1 getSteps() {
		return steps;
	}

	public void setSteps(StudentSteps1 steps) {
		this.steps = steps;
	}

	@Steps
	StudentSteps1 steps;
	
	@Title("DataDriven Test for adding multiple students to the Student App.")
	@Test
	public void createMultiplestudents(){
		ArrayList<String> myList = new ArrayList();
		myList.add(course);
		steps.createStudent(firstName, lastName, email, programme, myList)
		.statusCode(201);
	}

}
