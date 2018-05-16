package com.mcajayon.employees.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcajayon.employees.models.Employee;
import com.mcajayon.employees.services.EmployeeService;

@Controller
public class Employees {
	
	public final EmployeeService employeeService;
	
	public Employees(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping("/")
	public String index() {
		Employee emp1 = employeeService.addEmployee("Severus", "Snape");
		Employee emp2 = employeeService.addEmployee("Harry", "Potter");
		Employee emp3 = employeeService.addEmployee("Ron", "Weasely");
		
		Employee manager = employeeService.findByName("Severus", "Snape");
		List<Employee> employees = new ArrayList<Employee>();
		Employee e1 = employeeService.findByName("Harry", "Potter");
		Employee e2 = employeeService.findByName("Ron", "Weasely");
		employees.add(emp1);
		employees.add(emp2);
		manager.setEmployees(employees);
		employeeService.findByName("Harry", "Potter").setManager(manager);
		employeeService.findByName("Ron", "Weasely").setManager(manager);
		List<Employee> list = manager.getEmployees();
		
		
		for(Employee e : list) {
			System.out.println(e.getFirstName() + e.getLastName());
		}
		return null;
	}
	
}