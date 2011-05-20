package sit.fraunhofer.cloud_demo.dbaccess.usermanagement;

import java.io.Serializable;

import sit.fraunhofer.cloud_demo.models.usermanagement.Person;

public interface IDaoController extends Serializable{

	
	public void createUser(Person person);
	
	public Person createUser(String username,String password, String email);
	
	public Person findUser(String username);
	
	
}
