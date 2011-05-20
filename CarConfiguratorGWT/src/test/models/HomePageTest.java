package edu.hm.shareit.click.page;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.apache.click.control.*;
import org.junit.*;

import com.google.inject.*;

import edu.hm.shareit.click.usermanagement.*;
import edu.hm.shareit.models.usermanagement.*;

public class HomePageTest extends ClickPageTestBaseClass {
    
    private static final String PASSWORD = "bar";
    private static final String USERNAME = "foo";
    @Inject private ILoginService serviceMock;
    
    @Before
    public void setUp() {
        super.setUp();

        // Set the form name to ensure a Form submission occurs 
        container.setParameter(Form.FORM_NAME, "form"); 
        
        // Set the field value as a request parameter   
        container.setParameter("Login", USERNAME); 
        container.setParameter("Passwort", PASSWORD); 
        container.setParameter("submit", ""); 
    }

    @Test
    public void testFirstPage() throws Exception {
        expect(serviceMock.login(USERNAME, PASSWORD)).andReturn(new LoginResult(LoginResultStatus.NONEXISTING_USERNAME, null));
        replay(serviceMock);

        container.testPage(HomePage.class);

        assertNull("No forward expected for failed login.", container.getForwardPageClass()); 
        assertTrue("Error should be displayed", container.getHtml().contains("Login Failed"));

        container.stop(); 
        verify(serviceMock);
    }

    @Test
    public void testCorrectLogin() { 
        Person dummyUser = new  Person(USERNAME, "", "", PASSWORD, null);
        expect(serviceMock.login(USERNAME, PASSWORD)).andReturn(new LoginResult(LoginResultStatus.SUCCESS, dummyUser));
        replay(serviceMock);

        container.testPage(HomePage.class);

        assertNotNull("Forward page must not be null!", container.getForwardPageClass()); 
        assertEquals(WelcomePage.class, container.getForwardPageClass()); 
        
        container.testPage(WelcomePage.class);
        String html = container.getHtml();
        assertTrue("Username must be on page", html.contains("Hallo " + USERNAME));

        container.stop(); 
        verify(serviceMock);
    }

}
