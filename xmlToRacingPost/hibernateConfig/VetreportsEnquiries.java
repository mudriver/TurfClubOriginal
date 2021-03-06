// default package
// Generated 20-Feb-2015 09:56:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VetreportsEnquiries generated by hbm2java
 */
@Entity
@Table(name = "vetreports_enquiries", catalog = "vetreports")
public class VetreportsEnquiries implements java.io.Serializable {

	private VetreportsEnquiriesId id;

	public VetreportsEnquiries() {
	}

	public VetreportsEnquiries(VetreportsEnquiriesId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "enqId", column = @Column(name = "enq_id", nullable = false)),
			@AttributeOverride(name = "enqText", column = @Column(name = "enq_text", nullable = false)),
			@AttributeOverride(name = "enqMeeting", column = @Column(name = "enq_meeting", nullable = false, length = 200)),
			@AttributeOverride(name = "enqDate", column = @Column(name = "enq_date", nullable = false, length = 10)),
			@AttributeOverride(name = "enqEnteredBy", column = @Column(name = "enq_entered_by", nullable = false, length = 30)),
			@AttributeOverride(name = "enqIsDeleted", column = @Column(name = "enq_is_deleted", nullable = false)),
			@AttributeOverride(name = "enqRaceCode", column = @Column(name = "enq_race_code", nullable = false, length = 20)),
			@AttributeOverride(name = "enqRaceName", column = @Column(name = "enq_race_name", nullable = false, length = 200)),
			@AttributeOverride(name = "enqEnqType", column = @Column(name = "enq_enq_type", nullable = false, length = 16)),
			@AttributeOverride(name = "enqIsSentToCalendar", column = @Column(name = "enq_is_sent_to_calendar", nullable = false)),
			@AttributeOverride(name = "enqIsUploaded", column = @Column(name = "enq_is_uploaded", nullable = false)),
			@AttributeOverride(name = "enqShouldHaveDiscip", column = @Column(name = "enq_should_have_discip", nullable = false)),
			@AttributeOverride(name = "enqIsEmailed", column = @Column(name = "enq_is_emailed", nullable = false)),
			@AttributeOverride(name = "enqIsAccepted", column = @Column(name = "enq_is_accepted", nullable = false)),
			@AttributeOverride(name = "enqIsTurfclubApproved", column = @Column(name = "enq_is_turfclub_approved", nullable = false)) })
	public VetreportsEnquiriesId getId() {
		return this.id;
	}

	public void setId(VetreportsEnquiriesId id) {
		this.id = id;
	}

}
