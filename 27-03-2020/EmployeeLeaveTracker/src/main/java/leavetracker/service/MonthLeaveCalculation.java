package leavetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leavetracker.model.EmployeesLeaveTaken;
import leavetracker.model.EmployeesMonthLeaveCount;
import leavetracker.repository.EmployeeLeaveTakenRepository;
import leavetracker.repository.EmployeeMonthLeaveCountRepository;

@Service
public class MonthLeaveCalculation {
	
	@Autowired
	EmployeeMonthLeaveCountRepository employeeMonthLeaveCountRepository;
	
	@Autowired
	EmployeeLeaveTakenRepository employeeRepository;
	
	public void leaveMonthCountUpdate(String month, String employeeId)
	{
		List<EmployeesLeaveTaken> leaveTakenMonth = employeeRepository.findByMonthAndEmployeeId(month,employeeId);
		int totalLeave = 0;
		for(EmployeesLeaveTaken leaves : leaveTakenMonth)
    		totalLeave = totalLeave + Integer.parseInt(leaves.getNumberOfDays());
		
		EmployeesMonthLeaveCount leaveCount = new EmployeesMonthLeaveCount();
		leaveCount.setEmployeeId(employeeId);
		leaveCount.setMonth(month);
		leaveCount.setLeaveCount(totalLeave);
		
		employeeMonthLeaveCountRepository.save(leaveCount);
		
		
	}

}
