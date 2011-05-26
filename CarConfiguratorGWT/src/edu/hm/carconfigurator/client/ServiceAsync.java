package edu.hm.carconfigurator.client;

import edu.hm.carconfigurator.usermanagement.Person;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceAsync {

  public void checkLogin(String username, String passwort, AsyncCallback<Person> callback);
}
