package com.darecode.employees.api.exceptions;

public class ParameterException extends RuntimeException {

	public ParameterException(String field) {
		super(String.format("The request contains %s field which is invalid", field));
	}
}
