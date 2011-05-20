package sit.fraunhofer.cloud_demo.services;

import sit.fraunhofer.cloud_demo.models.usermanagement.Person;

public class RegistrationResult {

	
	private final RegistrationResponseState status;
	
	public RegistrationResult(RegistrationResponseState status) {
		this.status= status;
	}


	public RegistrationResponseState getStatus() {
		return status;
	}
	

}
