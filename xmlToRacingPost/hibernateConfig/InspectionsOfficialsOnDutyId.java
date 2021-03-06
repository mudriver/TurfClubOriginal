// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InspectionsOfficialsOnDutyId generated by hbm2java
 */
@Embeddable
public class InspectionsOfficialsOnDutyId implements java.io.Serializable {

	private int onDutyInspectionId;
	private int onDutyOfficialId;

	public InspectionsOfficialsOnDutyId() {
	}

	public InspectionsOfficialsOnDutyId(int onDutyInspectionId,
			int onDutyOfficialId) {
		this.onDutyInspectionId = onDutyInspectionId;
		this.onDutyOfficialId = onDutyOfficialId;
	}

	@Column(name = "on_duty_inspection_id", nullable = false)
	public int getOnDutyInspectionId() {
		return this.onDutyInspectionId;
	}

	public void setOnDutyInspectionId(int onDutyInspectionId) {
		this.onDutyInspectionId = onDutyInspectionId;
	}

	@Column(name = "on_duty_official_id", nullable = false)
	public int getOnDutyOfficialId() {
		return this.onDutyOfficialId;
	}

	public void setOnDutyOfficialId(int onDutyOfficialId) {
		this.onDutyOfficialId = onDutyOfficialId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InspectionsOfficialsOnDutyId))
			return false;
		InspectionsOfficialsOnDutyId castOther = (InspectionsOfficialsOnDutyId) other;

		return (this.getOnDutyInspectionId() == castOther
				.getOnDutyInspectionId())
				&& (this.getOnDutyOfficialId() == castOther
						.getOnDutyOfficialId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOnDutyInspectionId();
		result = 37 * result + this.getOnDutyOfficialId();
		return result;
	}

}
