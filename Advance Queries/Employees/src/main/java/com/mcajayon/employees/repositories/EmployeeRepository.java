package com.mcajayon.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mcajayon.employees.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	List<Employee> findAll();
	
	@Query("SELECT e FROM Employee e WHERE firstName =?1 AND lastName = ?2")
	Employee findByName(String firstName, String lastName);
}