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
package edu.hm.carconfigurator.usermanagement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2767822461474953029L;

	/** The user name. */
	@Id
	private String userName;
	
	/** The password. */
	private String password;
	
	/** The email. */
	private String email;
	
	
	/**
	 * Instantiates a new person.
	 */
	public Person(){
		
	}
	
	/**
	 * Instantiates a new person.
	 *
	 * @param user the user
	 * @param password the password
	 * @param email the email
	 */
	public Person(String user, String password, String email){
		this.userName = user;
		this.password = password;
		this.email=email;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	@Column(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * Checks if is valid password.
	 *
	 * @param pass the pass
	 * @return true, if is valid password
	 */
	public boolean isValidPassword(String pass) {
		return pass.equals(this.password);
	}
}
