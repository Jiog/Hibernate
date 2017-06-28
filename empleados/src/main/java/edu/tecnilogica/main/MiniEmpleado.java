package edu.tecnilogica.main;

public class MiniEmpleado {
	private Integer employeeId;
	private String firstName;
	
	public MiniEmpleado(Integer employeeId, String firstName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
	}
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	@Override
	public String toString() {
		return "MiniEmpleado [employeeId=" + employeeId + ", firstName=" + firstName + "]";
	}
}
