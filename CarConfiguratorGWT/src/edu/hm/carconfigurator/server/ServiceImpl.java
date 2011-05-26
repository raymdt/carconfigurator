package edu.hm.carconfigurator.server;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.hm.carconfigurator.client.Person;
import edu.hm.carconfigurator.client.Service;

public class ServiceImpl  extends RemoteServiceServlet implements Service{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final String USER_SESSION ="AppUser";
  
  
  private void setUserInSession(Person user) {
    HttpSession session = getThreadLocalRequest().getSession();
    session.setAttribute(USER_SESSION, user);
  }
  @Override
  public Person checkLogin(String username, String passwort) {
    
    if(username.equalsIgnoreCase("carconfigurator")) {
      Person user = new Person();
      user.setUserName(username);
      setUserInSession(user);
      return user;
      
    }
    else
      return null;
  
  }

}
