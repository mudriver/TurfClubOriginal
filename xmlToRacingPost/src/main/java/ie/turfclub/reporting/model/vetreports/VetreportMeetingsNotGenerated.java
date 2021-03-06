package ie.turfclub.reporting.model.vetreports;

// default package
// Generated 23-Dec-2014 15:36:25 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VetreportMeetingsNotGenerated generated by hbm2java
 */
@Entity
@Table(name = "vetreport_meetings_not_generated", catalog = "vetreports")
public class VetreportMeetingsNotGenerated implements java.io.Serializable {

	private int rowId;
	private String meeting;
	private Date dateRan;

	public VetreportMeetingsNotGenerated() {
	}

	public VetreportMeetingsNotGenerated(int rowId, String meeting,
			Date dateRan) {
		this.rowId = rowId;
		this.meeting = meeting;
		this.dateRan = dateRan;
	}

	@Id
	@Column(name = "row_id", nullable = false)
	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	@Column(name = "Meeting", nullable = false, length = 50)
	public String getMeeting() {
		return this.meeting;
	}

	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}

	@Column(name = "DateRan", nullable = false, length = 10)
	public Date getDateRan() {
		return this.dateRan;
	}

	public void setDateRan(Date dateRan) {
		this.dateRan = dateRan;
	}



	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getRowId();
		result = 37 * result
				+ (getMeeting() == null ? 0 : this.getMeeting().hashCode());
		result = 37 * result
				+ (getDateRan() == null ? 0 : this.getDateRan().hashCode());
		return result;
	}

}