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
package sit.fraunhofer.cloud_demo.dbaccess.usermanagement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import sit.fraunhofer.cloud_demo.dbaccess.GenericDaoImpl;
import sit.fraunhofer.cloud_demo.models.usermanagement.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonDao.
 * 
 * * @author
 * <TABLE WIDTH=360>
 * <TR><TD><b>author´s name</b></TD><TD><b>Occupation:</b></TD>
 * <TR><TD><a href=mailto:cmalcher@napcabs.com>Camilla malcher</a></TD> <TD> <b>Hiwi</b> </TD></TR>
 * <TR><TD><a href=mailto:Charly.Mbiep@sit.frauenhofer.de>Tchinda Mbiep Charly Raymond</a></TD>praktikant<TD></TD>
 * </TABLE>
 */
public class PersonDao extends GenericDaoImpl<Person, String>{

	/**
	 * 
	 */
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
