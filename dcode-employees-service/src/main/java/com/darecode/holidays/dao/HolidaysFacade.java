package com.darecode.holidays.dao;

import java.time.LocalDate;
import java.util.List;

import com.darecode.employees.dto.GoogleUser;
import com.darecode.holidays.dto.Holiday;

public interface HolidaysFacade {

	public List<Holiday> getAll(final GoogleUser user);
	
	public Holiday getOne(final GoogleUser user, LocalDate date);
	
	public List<Holiday> requestHoliday(final GoogleUser user, LocalDate date);
	
	public List<Holiday> approveHoliday(final GoogleUser user, LocalDate date);
	
	public List<Holiday> cancelHoliday(final GoogleUser user, LocalDate date);
}
