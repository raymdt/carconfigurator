/**
 * 
 */
package edu.hm.carconfigurator.models;

import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.hm.carconfigurator.usermanagement.Person;

public class GenericDAOTest extends DatabaseTestClass {

    private IGenericDAO<Person, String> genericDao;
    private Transaction tx;
    
    public GenericDAOTest(String name) throws IOException {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        genericDao = new GenericDAOImpl<Person, String>(injector.getInstance(SessionFactory.class)){};
        tx = getSession().beginTransaction();
    }

    @After
    public void tearDown() {
        tx.commit();
        try {
            super.tearDown();
        } catch (Exception e) {
            fail(e.getLocalizedMessage());
        }
    }

    @Test
    public void testFindPersonRalphi() {
        Object o  = genericDao.findById("Ralphi");
        assertNotNull(o);
        Person person = (Person)o;
        assertEquals("Ralph", person.getFirstName());
    }
    
}
