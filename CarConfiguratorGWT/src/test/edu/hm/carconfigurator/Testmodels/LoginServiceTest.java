package edu.hm.carconfigurator.Testmodels;

import org.junit.Before;
import org.junit.Test;

import edu.hm.carconfigurator.services.LoginResult;
import edu.hm.carconfigurator.services.LoginService;

public class LoginServiceTest extends DatabaseTestClass {

    private LoginService loginService;

    public LoginServiceTest(String name) {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        loginService = new LoginService(null);
    }

    @Test
    public void testLogonNonExistingUser() {
        LoginResult loginResult = loginService.login("bla", "blubb");
        assertNull("No user should be provided here.", loginResult.toString());
    }
    
    @Test
    public void testCorrectUser() {
        LoginResult loginResult = loginService.login("pegr", "PP");
        assertNotNull(loginResult.toString());
        assertEquals("pegr", loginResult.toString());
        assertEquals("Login Status is: SUCCESS for user pegr", loginResult.toString());
    }

}