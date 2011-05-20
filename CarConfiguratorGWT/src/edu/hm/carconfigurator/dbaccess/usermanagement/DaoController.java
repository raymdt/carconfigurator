package edu.hm.carconfigurator.dbaccess.usermanagement;

import edu.hm.carconfigurator.usermanagement.Person;

@SuppressWarnings("serial")
public class DaoController implements IDaoController {


	
	private final PersonDao persondao;


	public DaoController(PersonDao perdao) {
		this.persondao = perdao;

	}



	public void createUser(Person person) {


		persondao.makePersitent(person);


	}


	public Person createUser(String username, String password, String email) {

			Person person = new Person(username, password, email);
			persondao.makePersitent(person);
			return person;

	}


	public Person findUser(String username) {

	return  persondao.findByID(username);
	
	
	}

	public PersonDao getPersondao() {
		return persondao;
	}

}
