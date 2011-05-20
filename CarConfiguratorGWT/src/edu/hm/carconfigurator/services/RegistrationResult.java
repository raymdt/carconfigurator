package edu.hm.carconfigurator.services;


public class RegistrationResult {

	
	private final RegistrationResponseState status;
	
	public RegistrationResult(RegistrationResponseState status) {
		this.status= status;
	}


	public RegistrationResponseState getStatus() {
		return status;
	}
	

}
