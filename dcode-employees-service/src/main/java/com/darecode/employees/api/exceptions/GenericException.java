package com.darecode.employees.api.exceptions;

public class GenericException extends RuntimeException {

	public GenericException(final Throwable cause) {
		super(cause);
	}
	
	public GenericException(final String cause) {
		super(cause);
	}
}
