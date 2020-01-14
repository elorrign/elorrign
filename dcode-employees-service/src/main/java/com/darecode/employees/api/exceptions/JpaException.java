package com.darecode.employees.api.exceptions;

public class JpaException extends RuntimeException {

	public JpaException(final String message) {
		super(message);
	}
}
