/**
 ******************************************************************
 ******************************************************************
 * 				* * Software Engineering II
 * 
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
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * The Class GenericDaoImpl.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public class GenericDaoImpl<T , ID extends Serializable> implements IGenericDao<T , ID > {

	/** The session. */
	private final Session session;
	
	/** The persistent class. */
	private final Class<T> persistentClass;
	
	
	/**
	 * Instantiates a new generic dao impl.
	 *
	 * @param sessionfactory the sessionfactory
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl(SessionFactory sessionfactory) {
		
		this.session = sessionfactory.getCurrentSession();
		final Class<? extends GenericDaoImpl> myClass = this.getClass();
		Type superclass = myClass.getGenericSuperclass();
		ParameterizedType paratype = (ParameterizedType)superclass;
		persistentClass = (Class<T>)paratype.getActualTypeArguments()[0];
		
	}
	

	@SuppressWarnings("unchecked")
	public T findByID(Serializable id) {

		return (T)getSession().get(persistentClass , id);
	}

	


	/**
	 * Gets the persistent class.
	 *
	 * @return the persistent class
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}


	public void makePersitent(T t) {

		getSession().save(t);
	}

	public void update(T t) {

		getSession().update(t);
	}

	@Override
	public void makeTransient(T t) {

		getSession().delete(t);
	}
	
	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

}
