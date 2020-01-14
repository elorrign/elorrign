package com.darecode.employees.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.darecode.employees.dao.EmployeesFacade;
import com.darecode.employees.dto.Employee;
import com.darecode.employees.dto.Validator;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeesService {

	private EmployeesFacade employeeDao;
	private Validator<Employee> validator;
	
	@Cacheable(cacheNames = "employees")
	public List<Employee> readAll() {
		return employeeDao.readAll();
	}
	
	@Cacheable(cacheNames = "employees")
	public Employee read(final String googleId) {
		
		return employeeDao.read(googleId);
	}
	
	@CacheEvict(allEntries = true, cacheNames = "employees")
	public Employee creates(final Employee employee) {
		validator.validate(employee);
		if(StringUtils.isBlank(employee.getId())) {
			employee.setId(String.valueOf(Math.random()));
		}
		return employeeDao.creates(employee);
	}
	
	@CacheEvict(allEntries = true, cacheNames = "employees")
	public Employee updates(final Employee employee) {
		validator.validate(employee);
		return employeeDao.updates(employee);
	}
	
	
}
