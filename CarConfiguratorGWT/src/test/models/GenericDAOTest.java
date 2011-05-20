/**
 * 
 */
package edu.hm.shareit.tableaccess;

import java.io.*;

import org.hibernate.*;
import org.junit.*;

import edu.hm.shareit.dbaccess.*;
import edu.hm.shareit.models.*;
import edu.hm.shareit.models.usermanagement.*;

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
