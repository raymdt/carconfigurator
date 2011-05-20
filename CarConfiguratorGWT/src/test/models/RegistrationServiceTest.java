package edu.hm.shareit.services;

import java.text.*;

import org.junit.*;

import edu.hm.shareit.click.usermanagement.*;
import edu.hm.shareit.models.*;

public class RegistrationServiceTest extends DatabaseTestClass {

    public RegistrationServiceTest(String name) {
        super(name);
    }

    private IRegistrationService registrationService;
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        registrationService = injector.getInstance(IRegistrationService.class);
    }
    
    @Test
    public void testRegisterExistingUsername() {
        assertEquals(RegistrationResult.USERNAME_EXISTS, registrationService.registerNewUser("pegr", "Glenn", "Quagmire", "", null, null));
    }
    
    @Test
    public void testRegisterExistingUser() {
        assertEquals(RegistrationResult.USER_EXISTS, registrationService.registerNewUser("ICH", "Addam", "West", "", null, null));
    }
    
    @Test
    public void testRegisterNewUser() throws Exception {
        assertEquals(RegistrationResult.SUCCESS, registrationService.registerNewUser("abo", "Axel", "Bšttcher", "xxx", "ab@cs.hm.edu", new SimpleDateFormat("MM/dd/yyyy").parse("29/02/1988")));
    }
    
}
