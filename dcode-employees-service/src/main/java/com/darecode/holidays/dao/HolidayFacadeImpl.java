package com.darecode.holidays.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.darecode.employees.dto.GoogleUser;
import com.darecode.holidays.dto.Holiday;

@Component
public class HolidayFacadeImpl implements HolidaysFacade {

	
	@Override
	public List<Holiday> getAll(GoogleUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Holiday getOne(GoogleUser user, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Holiday> requestHoliday(GoogleUser user, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Holiday> approveHoliday(GoogleUser user, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Holiday> cancelHoliday(GoogleUser user, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

}
