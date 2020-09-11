package com.serenityrestassured.model.StudentClass;

import java.util.List;
//Alt+Shift+S key combination to generate getters and setters
public class StudenClass {
	private String firstName;
	private String lastName;
	private String email;
	private String program;
	private List<String> cources;
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
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public List<String> getCources() {
		return cources;
	}
	public void setCources(List<String> cources) {
		this.cources = cources;
	}


}
