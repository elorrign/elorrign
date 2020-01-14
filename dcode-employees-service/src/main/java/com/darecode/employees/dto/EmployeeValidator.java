package com.darecode.employees.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.darecode.employees.api.exceptions.ParameterException;

@Component
public class EmployeeValidator implements Validator<Employee>{

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(".+@darecode.com", Pattern.CASE_INSENSITIVE);


	public boolean isValid(final String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.find();
	}
	
	private void validateEmail(final String email) {
		if(StringUtils.isBlank(email) || email.contains(" ") || !isValid(email)) {
			throw new ParameterException("email");
		}
	}
	
	@Override
	public Employee validate(Employee source) {
		validateEmail(source.getEmail());
		return null;
	}

}
