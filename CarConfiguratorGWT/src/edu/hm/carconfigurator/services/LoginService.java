/**
 ******************************************************************
 ******************************************************************
 * 				   SOFTWARE ENGINEERING II SS-2009
 *                 * * CAR CONFIGURATOR                           *
 *                                                                *
 * 				   * * VERSION 1.0                                *
 * 			                                                      *
 * 				   * * Informatik cs.hm.edu                       *
 * 						                                          *
 ******************************************************************
 ******************************************************************
 * 
 * Copyright (c) SS 2011 Charly Tchinda && Eric Pokam
 * 
 * 
 *  * @author
 * <TABLE WIDTH=360>
 * <TR><TD><b>authors name</b></TD><TD><b>Occupation:</b></TD>
 * <TR><TD><a href=mailto:ericpokam@yahoo.fr>Eric Pokam</a></TD> <TD> <b>Student Informatik</b> </TD></TR>
 * <TR><TD><a href=mailto:janairo1883@yahoo.com>Tchinda Mbiep Charly Raymond</a></TD>Student Informatik<TD></TD>
 * </TABLE>
 */
package edu.hm.carconfigurator.services;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.hm.carconfigurator.client.ressourcemanagement.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginService.
 */
public class LoginService extends BaseService {

	/**
	 * Instantiates a new login service.
	 *
	 * @param sessionf the sessionf
	 */
	public LoginService(SessionFactory sessionf) {
		super(sessionf);
	}


	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the login result
	 */
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
