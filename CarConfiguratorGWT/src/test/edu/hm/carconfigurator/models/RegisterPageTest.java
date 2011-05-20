package edu.hm.carconfigurator.models;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.text.*;

import org.apache.click.control.*;
import org.junit.*;

import com.google.inject.*;

import edu.hm.shareit.click.usermanagement.*;

public class RegisterPageTest extends ClickPageTestBaseClass {

    private static final String PASSWORD = "blubber123";
    private static final String USERNAME = "idaehrlich";
    private static final String EMIL = "ida@ehlich.de";
    private static final String GEBURTSDATUM = "01-02-2001";
    private static final String NACHNAME = "Ehrlich";
    private static final String VORNAME = "Ida";
    @Inject private IRegistrationService serviceMock;
    
    @Before
    public void setUp() {
        super.setUp();

        // Set the form name to ensure a Form submission occurs 
        container.setParameter(Form.FORM_NAME, "form"); 
        // Set the field value as a request parameter   
        container.setParameter("Vorname", VORNAME); 
        container.setParameter("Nachname", NACHNAME); 
        container.setParameter("Geburtsdatum", GEBURTSDATUM); 
        container.setParameter("Email", EMIL); 
        container.setParameter("Username", USERNAME); 
        container.setParameter("Passwort", PASSWORD); 
        container.setParameter("submit", ""); 
    }
    
    @Test
    public void testCorrectRegistration() throws Exception {
        expect(serviceMock.registerNewUser(USERNAME, VORNAME, NACHNAME, PASSWORD, EMIL, new SimpleDateFormat("dd-MM-yyyy").parse(GEBURTSDATUM))).
                andReturn(RegistrationResult.SUCCESS);
        replay(serviceMock);

        container.testPage(RegisterPage.class);

        assertEquals(HomePage.class, container.getForwardPageClass()); 

        container.stop(); 
        verify(serviceMock);
    }

    @Test
    public void testincorrectRegistration() throws Exception {
        expect(serviceMock.registerNewUser(USERNAME, VORNAME, NACHNAME, PASSWORD, EMIL, new SimpleDateFormat("dd-MM-yyyy").parse(GEBURTSDATUM))).
                andReturn(RegistrationResult.USERNAME_EXISTS);
        replay(serviceMock);

        container.testPage(RegisterPage.class);

        assertNull("No forward page in this case", container.getForwardPageClass()); 
        assertTrue("Error should be displayed", container.getHtml().contains("The username already exists"));

        container.stop(); 
        verify(serviceMock);
    }

}
