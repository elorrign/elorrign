package com.darecode.employees.dao;

import java.util.List;

import com.darecode.employees.dto.Employee;

public interface EmployeesFacade {

	public List<Employee> readAll();
	
	public Employee read(final String id);
	
	public Employee creates(final Employee employee);
	
	public Employee updates(final Employee employee);
}
