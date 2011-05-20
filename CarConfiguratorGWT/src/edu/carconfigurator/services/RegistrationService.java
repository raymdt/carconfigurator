package edu.carconfigurator.services;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sit.fraunhofer.cloud_demo.models.usermanagement.Person;

public class RegistrationService extends BaseService{

	public RegistrationService(SessionFactory sessionf) {
		super(sessionf);

	}


	public RegistrationResult registerUser(String userName, String passwort_first,String passwort_wdh, String email) {

		
		if( !passwort_first.equals(passwort_wdh) ) {
			
			return new RegistrationResult( RegistrationResponseState.PASSWORD_ARE_NOT_THE_SAME);
			
		}
		
		Person person;
		
		
		
		Transaction tx = getSession().beginTransaction();

		try {
		
		person = getController().findUser(userName);

		if(person!=null) {
			
			return new RegistrationResult( RegistrationResponseState.USERNAME_EXIST);

		}
		else 
		{
			person = getController().createUser(userName, passwort_first , email);

			tx.commit();

			if(person==null) {
				return new RegistrationResult(RegistrationResponseState.ERROR );
			}

			
			return new RegistrationResult(RegistrationResponseState.SUCESS);


		}
		}
		catch(HibernateException e) {
			
			e.printStackTrace();
			tx.rollback();
			return new RegistrationResult(RegistrationResponseState.ERROR );
		}

	}


}
