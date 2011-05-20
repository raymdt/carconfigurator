package edu.hm.shareit.click.page;

import org.apache.click.*;
import org.apache.click.service.*;
import org.apache.click.servlet.*;
import org.junit.*;

import com.google.inject.*;

import edu.hm.shareit.click.*;

public class ClickPageTestBaseClass {

    protected MockContainer container;
    protected MockServletContext servletContext;
    protected Injector injector;

    @Before
    public void setUp() {
        // Specify the project web directory 
        String curDir = System.getProperty("user.dir");
        container = new MockContainer(curDir + "/src/main/webapp/"); 
        
        // Bootstrap the container   
        container.start();
        servletContext = container.getServletContext();
        
        // set up the config serice
        ShareitClickConfigService service = new ConfigServiceMock();
        servletContext.setAttribute(ConfigService.CONTEXT_NAME, service);
        injector = service.getInjector();
        injector.injectMembers(this);

    }
    
}
