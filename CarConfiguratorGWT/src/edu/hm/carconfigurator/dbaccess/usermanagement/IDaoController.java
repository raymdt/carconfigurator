package edu.hm.carconfigurator.dbaccess.usermanagement;


import java.io.Serializable;

import edu.hm.carconfigurator.usermanagement.Person;


public interface IDaoController extends Serializable{

	
	public void createUser(Person person);
	
	public Person createUser(String username,String password, String email);
	
	public Person findUser(String username);
	
	
}
