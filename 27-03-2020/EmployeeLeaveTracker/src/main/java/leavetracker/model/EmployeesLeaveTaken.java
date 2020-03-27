package leavetracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EmployeeLeave")

public class EmployeesLeaveTaken {

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(String numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="employeeId")
	private String employeeId;
	@Column(name="startDate")
    private String startDate;
	@Column(name="endDate")
    private String endDate;
	@Column(name="month")
    private String month;
	@Column(name="leaveType")
    private String leaveType;
	@Column(name="numberOfDays")
    private String numberOfDays;
}
