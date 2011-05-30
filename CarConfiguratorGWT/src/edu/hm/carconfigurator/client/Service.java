package edu.hm.carconfigurator.client;

import com.google.gwt.user.client.rpc.RemoteService;

import edu.hm.carconfigurator.client.ressourcemanagement.Person;


public interface Service extends RemoteService {

  public Person checkLogin(String username, String passwort);
}
