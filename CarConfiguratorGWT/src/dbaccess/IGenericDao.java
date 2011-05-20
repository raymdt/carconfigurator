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
package sit.fraunhofer.cloud_demo.dbaccess;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGenericDao.
 * 
 * * @author
 * <TABLE WIDTH=360>
 * <TR><TD><b>author´s name</b></TD><TD><b>Occupation:</b></TD>
 * <TR><TD><a href=mailto:cmalcher@napcabs.com>Camilla malcher</a></TD> <TD> <b>Hiwi</b> </TD></TR>
 * <TR><TD><a href=mailto:Charly.Mbiep@sit.frauenhofer.de>Tchinda Mbiep Charly Raymond</a></TD>praktikant<TD></TD>
 * </TABLE>
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public interface IGenericDao<T, ID extends Serializable> extends Serializable{

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T findByID(ID id);
	
	/**
	 * Make persitent.
	 *
	 * @param t the t
	 */
	public void makePersitent(T t);
	
	/**
	 * Update.
	 *
	 * @param t the t
	 */
	public void update(T t);
	
	/**
	 * Make transient.
	 *
	 * @param t the t
	 */
	public void makeTransient(T t);
	
	
}
