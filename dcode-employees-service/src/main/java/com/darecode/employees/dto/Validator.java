package com.darecode.employees.dto;

public interface Validator<T> {
	T validate(T source);
}
