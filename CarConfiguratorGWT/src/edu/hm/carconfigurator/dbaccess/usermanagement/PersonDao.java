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
/**
 ******************************************************************
 ******************************************************************
 *                 * * CLOUD-DEMONSTRATOR                         *
 *                                                                *
 * 				   * * VERSION 1.0                                *
 * 			                                                      *
 * 				   * * Frauenhofer SIT München                    *
 * 						                                          *
 ******************************************************************
 ******************************************************************
 * 
 * Copyright (c) 2010 Fraunhofer Institute for Secure Information Technology  
 * 
 */

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import edu.hm.carconfigurator.dbaccess.GenericDaoImpl;
import edu.hm.carconfigurator.usermanagement.Person;


// TODO: Auto-generated Javadoc
/**
 * The Class PersonDao.
 */
public class PersonDao extends GenericDaoImpl<Person, String>{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1086806804019653646L;


	/**
	 * Instantiates a new person dao.
	 *
	 * @param sessionfactory the sessionfactory
	 */
	public PersonDao(SessionFactory sessionfactory) {
		super(sessionfactory);
		
	}
	
	
	/**
	 * Find user.
	 *
	 * @param username the username
	 * @return the person
	 */
	public Person findUser(String username) {
		
		Person person;
		
		Query query = getSession().createSQLQuery("select * from person where userName= :uname");
		query.setString("uname", username);
		
		List list = query.list();
		if(list.size()==0) {
			return null;
		}
		else
			return (Person)list.get(0);
	}

}
