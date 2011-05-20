package edu.hm.shareit.tableaccess;

import java.io.*;
import java.text.*;
import java.util.*;

import org.hibernate.*;
import org.junit.*;

import edu.hm.shareit.models.*;
import edu.hm.shareit.models.usermanagement.*;
import edu.hm.shareit.services.usermanagement.*;

/**
 * Tests the data access facade.
 * @author axel
 *
 */
public class DataAccessFacadeTest extends DatabaseTestClass {
    private Person person;
    private EMail email1;
    private EMail email2;
    private IDataAccessFacade facade;
    private Transaction tx;
    
    public DataAccessFacadeTest() throws IOException {
        super(TEST_DATA_BASE_XML);
        facade = injector.getInstance(IDataAccessFacade.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        person = new Person("HH", "Hugo", "Habicht", "", new SimpleDateFormat("MM/dd/yyyy").parse("29/02/1988"));
        email1 = new EMail("habicht@hm.edu");
        email2 = new EMail("habicht@gmx.de");
        person.addEmail(email1);
        person.addEmail(email2);
        tx = session.beginTransaction();
    }
    
    @After
    public void tearDown() {
        tx.commit();
    }

    @Test
    public void testUserExists() {
        assertNotNull("User Ralphi should exist", facade.findUser("Ralphi"));
    }

    @Test
    public void testUserDoesNotExist() {
        assertNull("User XXX should not exist", facade.findUser("XXX"));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testcreatePerson() {
        facade.createPerson(person);
        List<Person> allPersons = session.createQuery("from Person where username='HH'").list();
        assertEquals(1, allPersons.size());
        Person hugo = allPersons.get(0);
        Iterator<EMail> iterator = hugo.getEmails();
        int count = 0;
        while(iterator.hasNext()) {
            count++;
            iterator.next();
        }
        assertEquals("Expected 2 Email addresses for Hugo", 2, count);
    }

    @Test
    public void testCreateUser() throws Exception {
        Person user = facade.createUser("Homi", "Homer", "Simpson", "g", new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2000"));
        assertNotNull("user Homer should have been createdâ", user);
    }
    
    @Test
    public void testDelete() {
        Person ralphi = facade.findUser("Ralphi");
        assertNotNull("User Ralphi should have been found", ralphi);
        facade.deletePerson(ralphi);
        ralphi = facade.findUser("Ralphi");
        assertNull("Deleted user should not be found", ralphi);
    }
    
}
