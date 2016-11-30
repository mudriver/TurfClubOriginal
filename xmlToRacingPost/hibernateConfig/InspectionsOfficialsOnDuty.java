// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * InspectionsOfficialsOnDuty generated by hbm2java
 */
@Entity
@Table(name = "inspections_officials_on_duty", catalog = "inspections")
public class InspectionsOfficialsOnDuty implements java.io.Serializable {

	private InspectionsOfficialsOnDutyId id;

	public InspectionsOfficialsOnDuty() {
	}

	public InspectionsOfficialsOnDuty(InspectionsOfficialsOnDutyId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "onDutyInspectionId", column = @Column(name = "on_duty_inspection_id", nullable = false)),
			@AttributeOverride(name = "onDutyOfficialId", column = @Column(name = "on_duty_official_id", nullable = false)) })
	public InspectionsOfficialsOnDutyId getId() {
		return this.id;
	}

	public void setId(InspectionsOfficialsOnDutyId id) {
		this.id = id;
	}

}