package edu.carconfigurator.services;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sit.fraunhofer.cloud_demo.models.usermanagement.Person;

public class LoginService extends BaseService {

	public LoginService(SessionFactory sessionf) {
		super(sessionf);
	}


	public LoginResult login(String username, String password) {
		
		Transaction tx = getSession().beginTransaction();
		Person user = getController().findUser(username);
		tx.commit();
		
		if(user==null) {
			return new LoginResult(null, LoginResponseState.USER_NOT_FOUND);
		}
		
		if(!user.isValidPassword(password)) {
			
			return new LoginResult(null, LoginResponseState.WRONG_PASSWORD);
		}
		
		return new LoginResult(user, LoginResponseState.SUCESS);
		
}
	
	
}
