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
package sit.fraunhofer.cloud_demo.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sit.fraunhofer.cloud_demo.dbaccess.usermanagement.IDaoController;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseService.
 * 
 * * @author
 * <TABLE WIDTH=360>
 * <TR><TD><b>author´s name</b></TD><TD><b>Occupation:</b></TD>
 * <TR><TD><a href=mailto:cmalcher@napcabs.com>Camilla malcher</a></TD> <TD> <b>Hiwi</b> </TD></TR>
 * <TR><TD><a href=mailto:Charly.Mbiep@sit.frauenhofer.de>Tchinda Mbiep Charly Raymond</a></TD>praktikant<TD></TD>
 * </TABLE>
 */
public class BaseService {



	/** The sessionfactory. */
	private final SessionFactory sessionfactory;
	
	private IDaoController controller;
	
	
	/**
	 * Gets the sessionfactory.
	 *
	 * @return the sessionfactory
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
	

	public IDaoController getController() {
		return controller;
	}


	public void setController(IDaoController controller) {
		this.controller = controller;
	}
}
