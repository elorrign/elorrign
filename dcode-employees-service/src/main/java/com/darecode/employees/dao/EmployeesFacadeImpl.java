package com.darecode.employees.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.darecode.employees.api.exceptions.JpaException;
import com.darecode.employees.dto.Employee;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class EmployeesFacadeImpl implements EmployeesFacade {

	private EmployeeRepository repository;

	@Override
	public List<Employee> readAll() {
		log.info("Reading all the employees");
		try {
			return repository.findAll();
		} catch (Exception e) {
			throw new JpaException(e.getMessage());
		}
	}

	@Override
	public Employee read(String id) {
		log.info("Reading the employee with ID {}", id);
		try {
			return repository.getOne(id);
		} catch (Exception e) {
			throw new JpaException(e.getMessage());
		}
	}

	@Override
	public Employee creates(Employee employee) {
		log.info("Creating a new Employee with the data: {}", employee);
		
		try {
			Employee created = repository.save(employee);
			log.info("Saved the info: {}", created);
			return created;
		} catch (Exception e) {
			throw new JpaException(e.getMessage());
		}

	}

	@Override
	public Employee updates(Employee employee) {
		log.info("Updating a new Employee with the data: {}", employee);
		
		try {
			Employee created = repository.save(employee);
			log.info("Updated the info: {}", created);
			return created;
		} catch (Exception e) {
			throw new JpaException(e.getMessage());
		}
	}

}
