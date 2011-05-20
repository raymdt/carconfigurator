package edu.hm.carconfigurator.models;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import edu.hm.carconfigurator.services.RegistrationResult;

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
