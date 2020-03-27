package leavetracker.service;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leavetracker.model.Holidays;
import leavetracker.repository.HolidayRepository;

@Service
public class LeaveCountCalculation {
	@Autowired
	HolidayRepository holidayRepository;
	Map<String, String> map = new HashMap<>();

	public int leaveCountCalculation(String startDate, String endDate) throws ParseException {
		LocalDate beginningDate = LocalDate.parse(startDate);
		LocalDate lastDate = LocalDate.parse(endDate);
		int count = 0;
		List<LocalDate> leaveDaysOfEmployee = Stream.iterate(beginningDate, date -> date.plusDays(1))
				.limit(ChronoUnit.DAYS.between(beginningDate, lastDate) + 1).collect(Collectors.toList());

		List<Holidays> samples = holidayRepository.findAll();
		for (Holidays i : samples)
			map.put(i.getDate(), i.getHolidayName());

		for (LocalDate date : leaveDaysOfEmployee) {	
			if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY
					&& !map.containsKey(date.toString())) {
				count++;
			}

		}

		return count;
	}

}
