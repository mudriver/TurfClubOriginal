package ie.turfclub.reporting.model.vetreports;

// default package
// Generated 23-Dec-2014 15:36:25 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VetreportReportsSent generated by hbm2java
 */
@Entity
@Table(name = "vetreport_reports_sent", catalog = "vetreports")
public class VetreportReportsSent implements java.io.Serializable {

	private Integer sentId;
	private String sentMeeting;
	private Date sentDate;

	public VetreportReportsSent() {
	}

	public VetreportReportsSent(String sentMeeting, Date sentDate) {
		this.sentMeeting = sentMeeting;
		this.sentDate = sentDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sent_id", unique = true, nullable = false)
	public Integer getSentId() {
		return this.sentId;
	}

	public void setSentId(Integer sentId) {
		this.sentId = sentId;
	}

	@Column(name = "sent_meeting", nullable = false, length = 200)
	public String getSentMeeting() {
		return this.sentMeeting;
	}

	public void setSentMeeting(String sentMeeting) {
		this.sentMeeting = sentMeeting;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "sent_date", nullable = false, length = 10)
	public Date getSentDate() {
		return this.sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

}
