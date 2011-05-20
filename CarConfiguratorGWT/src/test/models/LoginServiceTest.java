package edu.hm.shareit.services;

import org.junit.*;

import edu.hm.shareit.click.usermanagement.*;
import edu.hm.shareit.models.*;

public class LoginServiceTest extends DatabaseTestClass {

    private ILoginService loginService;

    public LoginServiceTest(String name) {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        loginService = injector.getInstance(ILoginService.class);
    }

    @Test
    public void testLogonNonExistingUser() {
        LoginResult loginResult = loginService.login("bla", "blubb");
        assertEquals(LoginResultStatus.NONEXISTING_USERNAME, loginResult.getStatus());
        assertNull("No user should be provided here.", loginResult.getUser());
    }
    
    @Test
    public void testCorrectUser() {
        LoginResult loginResult = loginService.login("pegr", "PP");
        assertEquals(LoginResultStatus.SUCCESS, loginResult.getStatus());
        assertNotNull(loginResult.getUser());
        assertEquals("pegr", loginResult.getUser().getUserName());
        assertEquals("Login Status is: SUCCESS for user pegr", loginResult.toString());
    }

}