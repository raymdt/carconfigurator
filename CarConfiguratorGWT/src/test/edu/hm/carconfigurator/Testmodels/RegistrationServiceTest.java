package edu.hm.carconfigurator.Testmodels;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import edu.hm.carconfigurator.services.RegistrationResult;
import edu.hm.carconfigurator.services.RegistrationService;

public class RegistrationServiceTest extends DatabaseTestClass {

    public RegistrationServiceTest(String name) {
        super(name);
    }

    private RegistrationService registrationService;
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        registrationService = new RegistrationService(null);
        	}
    
    @Test
    public void testRegisterExistingUsername() {
        assertEquals("Test user Exist",false);
    }
    
    @Test
    public void testRegisterExistingUser() {
    	
    }
    
    @Test
    public void testRegisterNewUser() throws Exception {
        assertEquals("Registered User","raoul");
    }
    
}
