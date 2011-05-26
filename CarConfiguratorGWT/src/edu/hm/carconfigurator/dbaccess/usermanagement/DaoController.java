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

import edu.hm.carconfigurator.client.Person;

@SuppressWarnings("serial")
public class DaoController implements IDaoController {


	
	private final PersonDao persondao;


	public DaoController(PersonDao perdao) {
		this.persondao = perdao;

	}



	/* (non-Javadoc)
	 * @see edu.hm.carconfigurator.dbaccess.usermanagement.IDaoController#createUser(edu.hm.carconfigurator.usermanagement.Person)
	 */
	public void createUser(Person person) {


		persondao.makePersitent(person);


	}


	public Person createUser(String username, String password, String email) {

			Person person = new Person(username, password, email);
			persondao.makePersitent(person);
			return person;

	}


	public Person findUser(String username) {

	return  persondao.findByID(username);
	
	
	}

	public PersonDao getPersondao() {
		return persondao;
	}

}
