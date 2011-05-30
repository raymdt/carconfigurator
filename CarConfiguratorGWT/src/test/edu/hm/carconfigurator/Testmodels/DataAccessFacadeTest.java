package edu.hm.carconfigurator.Testmodels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.hm.carconfigurator.client.ressourcemanagement.Person;

public class DataAccessFacadeTest  {
    private Person person;
    Session session ;

    private Transaction tx;
    
    public DataAccessFacadeTest() throws IOException {
    }

    @Before
    public void setUp() throws Exception {
        tx = session.beginTransaction();
    }
    
    @After
    public void tearDown() {
        tx.commit();
    }

    @Test
    public void testUserExists() {
        assertNotNull("User Ralphi should exist");
    }

    @Test
    public void testUserDoesNotExist() {
        assertNull("User XXX should not exist");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testcreatePerson() {
        List<Person> allPersons = session.createQuery("from Person where username='HH'").list();
        assertEquals(1, allPersons.size());
        Person hugo = allPersons.get(0);
        int count = 0;
  
        assertEquals("Expected 2 Email addresses for Hugo", 2, count);
    }

    @Test
    public void testCreateUser() throws Exception {
        assertNotNull("user Homer should have been createdâ");
    }
    
    @Test
    public void testDelete() {
        assertNotNull("User Ralphi should have been found");
        assertNull("Deleted user should not be found");
    }
    
}
