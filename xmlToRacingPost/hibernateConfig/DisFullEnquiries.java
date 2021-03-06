// default package
// Generated 31-Oct-2014 14:49:01 by Hibernate Tools 3.4.0.CR1

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
 * DisFullEnquiries generated by hbm2java
 */
@Entity
@Table(name = "dis_full_enquiries", catalog = "turf201_disciplinaries")
public class DisFullEnquiries implements java.io.Serializable {

	private Integer fullId;
	private Date fullMeetingDate;
	private String fullMeetingName;
	private String fullRecordText;

	public DisFullEnquiries() {
	}

	public DisFullEnquiries(Date fullMeetingDate, String fullMeetingName,
			String fullRecordText) {
		this.fullMeetingDate = fullMeetingDate;
		this.fullMeetingName = fullMeetingName;
		this.fullRecordText = fullRecordText;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "full_id", unique = true, nullable = false)
	public Integer getFullId() {
		return this.fullId;
	}

	public void setFullId(Integer fullId) {
		this.fullId = fullId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "full_meeting_date", nullable = false, length = 10)
	public Date getFullMeetingDate() {
		return this.fullMeetingDate;
	}

	public void setFullMeetingDate(Date fullMeetingDate) {
		this.fullMeetingDate = fullMeetingDate;
	}

	@Column(name = "full_meeting_name", nullable = false, length = 80)
	public String getFullMeetingName() {
		return this.fullMeetingName;
	}

	public void setFullMeetingName(String fullMeetingName) {
		this.fullMeetingName = fullMeetingName;
	}

	@Column(name = "full_record_text", nullable = false)
	public String getFullRecordText() {
		return this.fullRecordText;
	}

	public void setFullRecordText(String fullRecordText) {
		this.fullRecordText = fullRecordText;
	}

}
