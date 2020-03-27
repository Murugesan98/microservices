package leavetracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeMonthlyLeaveCount")
public class EmployeesMonthLeaveCount {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="employeeId")
	private String employeeId;
	@Column(name="leaveCount")
	private int leaveCount;
	@Column(name="month")
	private String month;
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
	public int getLeaveCount() {
		return leaveCount;
	}
	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	

}
