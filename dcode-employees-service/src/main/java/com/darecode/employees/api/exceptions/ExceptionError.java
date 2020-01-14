package com.darecode.employees.api.exceptions;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionError {

	private String cause;
	private String code;
	private int httpCode;
	private LocalTime timestamp;
	
}
