package edu.tecnilogica.entity;
// Generated 27-jun-2017 12:19:30 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * JobHistoryId generated by hbm2java
 */
@Embeddable
public class JobHistoryId implements java.io.Serializable {

	private int employeeId;
	private Date startDate;

	public JobHistoryId() {
	}

	public JobHistoryId(int employeeId, Date startDate) {
		this.employeeId = employeeId;
		this.startDate = startDate;
	}

	@Column(name = "EMPLOYEE_ID", nullable = false, precision = 6, scale = 0)
	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "START_DATE", nullable = false, length = 7)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof JobHistoryId))
			return false;
		JobHistoryId castOther = (JobHistoryId) other;

		return (this.getEmployeeId() == castOther.getEmployeeId())
				&& ((this.getStartDate() == castOther.getStartDate()) || (this.getStartDate() != null
						&& castOther.getStartDate() != null && this.getStartDate().equals(castOther.getStartDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEmployeeId();
		result = 37 * result + (getStartDate() == null ? 0 : this.getStartDate().hashCode());
		return result;
	}

}
