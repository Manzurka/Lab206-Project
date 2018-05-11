package com.mcajayon.license.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mcajayon.license.models.Person;
import com.mcajayon.license.repositories.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRep;
	public PersonService(PersonRepository personRep) {
		this.personRep = personRep;
	}
	
	public List<Person> allPerson() {
		return personRep.findAll();
	}
	
	public void addPerson(Person person) {
		personRep.save(person);
	}
}
