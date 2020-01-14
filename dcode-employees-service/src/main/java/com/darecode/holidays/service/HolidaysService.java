package com.darecode.holidays.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.darecode.employees.dto.GoogleUser;
import com.darecode.holidays.api.exception.HolidayException;
import com.darecode.holidays.dao.HolidaysFacade;
import com.darecode.holidays.dto.Holiday;
import com.darecode.holidays.dto.Status;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class HolidaysService {

	private HolidaysFacade facade;
	@Cacheable("holidays-user")
	public List<Holiday> getAllHolidays(final GoogleUser user) {
		return facade.getAll(user);
	}
	@CacheEvict(cacheNames = "holidays-user")
	public List<Holiday> requestHoliday(final GoogleUser user, LocalDate date) {
		log.info("User {} request to have a new holiday on {}", user, date);
		Holiday day = facade.getOne(user, date);
		checkIsRequested(day);
		return facade.requestHoliday(user, date);
	}
	@CacheEvict(cacheNames = "holidays-user")	
	public List<Holiday> approveDay(final GoogleUser user, LocalDate day) {
		getAllHolidays(user).stream().forEach(p -> {
			if(p.getDate() == day) {
				checkIsRequested(p);
			}
		});
		return facade.approveHoliday(user, day);
	}
	@CacheEvict(cacheNames = "holidays-user")
	public List<Holiday> approveHoliday(final GoogleUser user, List<LocalDate> dates){
		log.info("Approving the list of dates {}", dates);
		dates.stream().forEach(p -> approveDay(user, p));
		return getAllHolidays(user);
	}
	
	private void checkIsRequested(final Holiday day) {
		if(day.getStatus() == Status.REQUESTED || day.getStatus() == Status.CONSUMED) {
			throw new HolidayException("This day is either already pending to approve or consumed");
		}
	}
}
