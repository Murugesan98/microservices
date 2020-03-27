package leavetracker.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leavetracker.model.EmployeesLeaveTaken;
import leavetracker.model.Holidays;
import leavetracker.repository.EmployeeLeaveTakenRepository;
import leavetracker.repository.HolidayRepository;
import leavetracker.service.LeaveCountCalculation;
import leavetracker.service.MonthLeaveCalculation;

@RestController
@RequestMapping(path = "/employees")
public class Controller {

	@Autowired
	EmployeeLeaveTakenRepository employeeRepository;
	@Autowired
	LeaveCountCalculation leaveCount;
	@Autowired
	HolidayRepository holidayRepository;
	@Autowired
	MonthLeaveCalculation monthLeave;


	@GetMapping("/leaves")
	public void getLeaves(@RequestBody EmployeesLeaveTaken employee) throws ParseException {
		employee.setNumberOfDays(
				Integer.toString(leaveCount.leaveCountCalculation(employee.getStartDate(), employee.getEndDate())));
		String month = employee.getMonth();
		String employeeId = employee.getEmployeeId();
		employeeRepository.save(employee);
		monthLeave.leaveMonthCountUpdate(month, employeeId);
	}

	@GetMapping("/holidays")
	public void getHolidays(@RequestBody Holidays holidays) {
		System.out.println(holidays.getDate());
		holidayRepository.save(holidays);
	}

}	
