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
package edu.hm.carconfigurator.dbaccess.usermanagement;


import java.io.Serializable;

import edu.hm.carconfigurator.client.ressourcemanagement.Person;


// TODO: Auto-generated Javadoc
/**
 * The Interface IDaoController.
 */
public interface IDaoController extends Serializable{

	
	/**
	 * Creates the user.
	 *
	 * @param person the person
	 */
	public void createUser(Person person);
	
	/**
	 * Creates the user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param email the email
	 * @return the person
	 */
	public Person createUser(String username,String password, String email);
	
	/**
	 * Find user.
	 *
	 * @param username the username
	 * @return the person
	 */
	public Person findUser(String username);
	
	
}
