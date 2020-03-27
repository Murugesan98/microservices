package leavetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import leavetracker.model.EmployeesMonthLeaveCount;

public interface EmployeeMonthLeaveCountRepository extends JpaRepository<EmployeesMonthLeaveCount,Long> {

}
