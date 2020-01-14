package com.darecode.employees.api.exceptions;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.darecode.holidays.api.exception.HolidayException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class EmployeesExceptionHandler {

	/**
	 * Manages the exceptions produced by the Feign clients.
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(GenericException.class)
	public ResponseEntity handleMicroserviceException(GenericException e, WebRequest request) {
		return error(e, HttpStatus.INTERNAL_SERVER_ERROR, ExceptionError.builder().cause(e.getLocalizedMessage()).code("MS_500")
				.httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).timestamp(LocalTime.now()).build(), "microservice");
	}

	@ExceptionHandler(JpaException.class)
	public ResponseEntity handleMicroserviceException(JpaException e, WebRequest request) {
		return error(e, HttpStatus.INTERNAL_SERVER_ERROR, ExceptionError.builder().cause(e.getLocalizedMessage()).code("DB_001")
				.httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).timestamp(LocalTime.now()).build(), "request");
	}

	@ExceptionHandler(ParameterException.class)
	public ResponseEntity handleMicroserviceException(ParameterException e, WebRequest request) {
		return error(e, HttpStatus.BAD_REQUEST, ExceptionError.builder().cause(e.getLocalizedMessage()).code("PARAM_001")
				.httpCode(HttpStatus.BAD_REQUEST.value()).timestamp(LocalTime.now()).build(), "request");
	}

	@ExceptionHandler(HolidayException.class)
	public ResponseEntity handleMicroserviceException(HolidayException e, WebRequest request) {
		return error(e, HttpStatus.BAD_REQUEST, ExceptionError.builder().cause(e.getLocalizedMessage()).code("PARAM_001")
				.httpCode(HttpStatus.BAD_REQUEST.value()).timestamp(LocalTime.now()).build(), "request");
	}
	/**
	 * Centralized method to create the response error object.
	 * 
	 * @param exception
	 * @param httpStatus
	 * @param logRef
	 * @return
	 */
	private ResponseEntity error(final Exception exception, final HttpStatus httpStatus, ExceptionError body,
			final String logRef) {
		final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
		log.error("Error in the {}, message: {}", logRef, message);
		return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
	}
}
