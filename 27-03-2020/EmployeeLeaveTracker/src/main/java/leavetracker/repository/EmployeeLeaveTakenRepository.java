package leavetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leavetracker.model.EmployeesLeaveTaken;

public interface EmployeeLeaveTakenRepository extends JpaRepository<EmployeesLeaveTaken, Long>
{


	List<EmployeesLeaveTaken> findByMonthAndEmployeeId(String month, String employeeId);

}
