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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.hm.carconfigurator.dbaccess.usermanagement.IDaoController;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseService.
 */
public class BaseService {



	/** The sessionfactory. */
	private final SessionFactory sessionfactory;
	
	/** The controller. */
	private IDaoController controller;
	
	
	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		return sessionfactory.getCurrentSession();
	}





	/**
	 * Instantiates a new base service.
	 *
	 * @param sessionf the sessionf
	 */
	public BaseService(SessionFactory sessionf) {
		this.sessionfactory = sessionf;
	}
	

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public IDaoController getController() {
		return controller;
	}


	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	public void setController(IDaoController controller) {
		this.controller = controller;
	}
}
