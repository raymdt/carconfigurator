/**
 * 
 */
package edu.hm.carconfigurator.Testmodels;

import java.io.IOException;

import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.hm.carconfigurator.client.Person;
import edu.hm.carconfigurator.dbaccess.IGenericDao;

public class GenericDAOTest extends DatabaseTestClass {

    private IGenericDao<Person, String> genericDao;
    private Transaction tx;
    
    public GenericDAOTest(String name) throws IOException {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        genericDao = null;
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
        Object o  = genericDao.findByID("Ralphi");
        assertNotNull(o);
        Person person = (Person)o;
        assertEquals("Ralph", person.getUserName());
    }
    
}
