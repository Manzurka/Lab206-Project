package com.mcajayon.employees.services;

import org.springframework.stereotype.Service;

import com.mcajayon.employees.models.Employee;
import com.mcajayon.employees.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRep;
	
	public EmployeeService(EmployeeRepository employeeRep) {
		this.employeeRep = employeeRep;
	}
	
	public Employee addEmployee(String firstName, String lastName) {
		Employee e = new Employee(firstName, lastName);
		return employeeRep.save(e);
	}
	
	public Employee findByName(String firstName, String lastName) {
		return employeeRep.findByName(firstName, lastName);
	}
}