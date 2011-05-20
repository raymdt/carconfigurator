package edu.hm.carconfigurator.Testmodels;

import java.io.IOException;
import java.util.List;

import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.hm.carconfigurator.dbaccess.usermanagement.PersonDao;
import edu.hm.carconfigurator.usermanagement.Person;

public class PersonDAOTest extends DatabaseTestClass {

    private PersonDao personDao;
    private Transaction tx;
    
    public PersonDAOTest(String name) throws IOException {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        personDao = null;
        tx = getSession().beginTransaction();
    }

    @After
    public void tearDown() {
        tx.commit();
    }

    @Test
    public void testFindPersonPeter() {
        List<Person> persons = (List<Person>) personDao.findUser("test paerson");
        assertEquals(1, persons.size());
    }
    
    @Test
    public void testFindRalph() {
        List<Person> persons = (List<Person>) personDao.findUser("Ralph");
        assertEquals(1, persons.size());
    }
    
    @Test
    public void testFindNonExistingUser() {
        Person person = personDao.findUser("bla");
        assertNull("Should not find anything with username 'bla'", person);
    }
    
    @Test
    public void testFindUserAddam() {
        Person person = personDao.findUser("addam");
        assertNotNull("Should find user 'addam'", person);
    }
    
    @Test
    public void testDelete() {
        List<Person> persons = (List<Person>) personDao.findUser("Charly");
        assertEquals(1, persons.size());
        Person peter = persons.get(0);
        personDao.makeTransient(peter);
        persons = (List<Person>) personDao.findUser("Manou");
        assertEquals(0, persons.size());
    }

}
