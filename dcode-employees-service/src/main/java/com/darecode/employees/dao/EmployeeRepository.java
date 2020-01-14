package com.darecode.employees.dao;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darecode.employees.dto.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

	public Employee findByEmail(@NotNull final String email);
}
