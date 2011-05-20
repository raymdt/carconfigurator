package edu.carconfigurator.services;

import sit.fraunhofer.cloud_demo.models.usermanagement.Person;

public class LoginResult {

	

	private final Person person;
	
	private final LoginResponseState status;
	
	
	public LoginResult(Person person, LoginResponseState status) {
		
		this.person = person;
		this.status = status;
	}


	public Person getPerson() {
		return person;
	}


	public LoginResponseState getStatus() {
		return status;
	}
}
