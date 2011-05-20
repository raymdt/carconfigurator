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

import edu.hm.carconfigurator.usermanagement.Person;


// TODO: Auto-generated Javadoc
/**
 * The Class LoginResult.
 */
public class LoginResult {

	

	/** The person. */
	private final Person person;
	
	/** The status. */
	private final LoginResponseState status;
	
	
	/**
	 * Instantiates a new login result.
	 *
	 * @param person the person
	 * @param status the status
	 */
	public LoginResult(Person person, LoginResponseState status) {
		
		this.person = person;
		this.status = status;
	}


	/**
	 * Gets the person.
	 *
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}


	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public LoginResponseState getStatus() {
		return status;
	}
}
