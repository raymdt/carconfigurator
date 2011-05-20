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
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericDaoImpl.
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
	
	/* (non-Javadoc)
	 * @see sit.fraunhofer.cloud_demo.dbaccess.IGenericDao#findByID(java.io.Serializable)
	 */
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

	/* (non-Javadoc)
	 * @see sit.fraunhofer.cloud_demo.dbaccess.IGenericDao#makePersitent(java.lang.Object)
	 */
	public void makePersitent(T t) {

		getSession().save(t);
	}

	/* (non-Javadoc)
	 * @see sit.fraunhofer.cloud_demo.dbaccess.IGenericDao#update(java.lang.Object)
	 */
	public void update(T t) {

		getSession().update(t);
	}

	/* (non-Javadoc)
	 * @see sit.fraunhofer.cloud_demo.dbaccess.IGenericDao#makeTransient(java.lang.Object)
	 */
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
