package com.mcajayon.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mcajayon.license.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	
	List<Person> findAll();

}
