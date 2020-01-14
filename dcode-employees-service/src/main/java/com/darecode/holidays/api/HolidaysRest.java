package com.darecode.holidays.api;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darecode.holidays.dto.HolidayRequest;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/employees/{id}/holidays", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Employees Service", description = "Service to retrieve the list of users in the company")
@AllArgsConstructor
@Slf4j
@Validated
public class HolidaysRest {

	@GetMapping
	public List getAllData(@NotNull @PathVariable final String id) {
		return null;
	}

	@PostMapping
	public List requestHoliday(@RequestBody final HolidayRequest request) {
		return null;
	}
}

