/**
 ******************************************************************
 ******************************************************************
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
package edu.hm.carconfigurator.dbaccess;


import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGenericDao.
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
