package com.darecode.employees.api;

import java.net.HttpURLConnection;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.darecode.employees.dto.Employee;
import com.darecode.employees.service.EmployeesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Employees Service", description = "Service to retrieve the list of users in the company")
@AllArgsConstructor
@Slf4j
@Validated
public class EmployeesRest {

	private EmployeesService service;
	
	@GetMapping
	@ApiOperation(value = "Get all the employees in the company", response = List.class)
	@ApiResponses({ @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "True when the operation was fine"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Unexpected error"), })
	public 
	@ResponseBody
	List<Employee> readAll() {
		return  service.readAll();
	}
	
	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Get one employees in the company", response = Employee.class)
	@ApiResponses({ @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "True when the operation was fine"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Unexpected error"), })
	public 
	@ResponseBody
	Employee readEmployee(@NotNull @Valid @PathVariable final String id) {
		log.info("id: {}", id);
		Employee employee = service.read(id);
		
		log.info("Employee: {}", employee);
		return employee;
	}

	@PostMapping
	@ApiOperation(value = "Creates one employees in the company", response = Employee.class)
	@ApiResponses({ @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "True when the operation was fine"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Unexpected error"), })
	public 
	@ResponseBody
	Employee createsEmployee(@NotNull @Valid @RequestBody final Employee employee) {
		log.info("employee: {}", employee);
		Employee created = service.creates(employee);
		
		log.info("Employee: {}", created);

		return created;
	}
	
	@PutMapping
	@ApiOperation(value = "Updates the info of one employee", response = Employee.class)
	@ApiResponses({ @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "True when the operation was fine"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Unexpected error"), })
	public 
	@ResponseBody
	Employee updateEmployee(@NotNull @Valid @RequestBody final Employee employee) {
		log.info("employee: {}", employee);
		Employee created = service.creates(employee);
		
		log.info("Employee: {}", created);

		return created;
	}

}
