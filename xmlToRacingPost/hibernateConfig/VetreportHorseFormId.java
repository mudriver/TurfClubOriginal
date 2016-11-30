// default package
// Generated 20-Feb-2015 09:56:42 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VetreportHorseFormId generated by hbm2java
 */
@Embeddable
public class VetreportHorseFormId implements java.io.Serializable {

	private int formId;
	private String formHorse;
	private Date formDate;
	private String formConditions;
	private String formRace;
	private String formResult;
	private int formRcId;

	public VetreportHorseFormId() {
	}

	public VetreportHorseFormId(int formId, String formHorse, Date formDate,
			String formConditions, String formRace, String formResult,
			int formRcId) {
		this.formId = formId;
		this.formHorse = formHorse;
		this.formDate = formDate;
		this.formConditions = formConditions;
		this.formRace = formRace;
		this.formResult = formResult;
		this.formRcId = formRcId;
	}

	@Column(name = "form_id", nullable = false)
	public int getFormId() {
		return this.formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	@Column(name = "form_horse", nullable = false, length = 200)
	public String getFormHorse() {
		return this.formHorse;
	}

	public void setFormHorse(String formHorse) {
		this.formHorse = formHorse;
	}

	@Column(name = "form_date", nullable = false, length = 10)
	public Date getFormDate() {
		return this.formDate;
	}

	public void setFormDate(Date formDate) {
		this.formDate = formDate;
	}

	@Column(name = "form_conditions", nullable = false, length = 50)
	public String getFormConditions() {
		return this.formConditions;
	}

	public void setFormConditions(String formConditions) {
		this.formConditions = formConditions;
	}

	@Column(name = "form_race", nullable = false, length = 50)
	public String getFormRace() {
		return this.formRace;
	}

	public void setFormRace(String formRace) {
		this.formRace = formRace;
	}

	@Column(name = "form_result", nullable = false, length = 200)
	public String getFormResult() {
		return this.formResult;
	}

	public void setFormResult(String formResult) {
		this.formResult = formResult;
	}

	@Column(name = "form_rc_id", nullable = false)
	public int getFormRcId() {
		return this.formRcId;
	}

	public void setFormRcId(int formRcId) {
		this.formRcId = formRcId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VetreportHorseFormId))
			return false;
		VetreportHorseFormId castOther = (VetreportHorseFormId) other;

		return (this.getFormId() == castOther.getFormId())
				&& ((this.getFormHorse() == castOther.getFormHorse()) || (this
						.getFormHorse() != null
						&& castOther.getFormHorse() != null && this
						.getFormHorse().equals(castOther.getFormHorse())))
				&& ((this.getFormDate() == castOther.getFormDate()) || (this
						.getFormDate() != null
						&& castOther.getFormDate() != null && this
						.getFormDate().equals(castOther.getFormDate())))
				&& ((this.getFormConditions() == castOther.getFormConditions()) || (this
						.getFormConditions() != null
						&& castOther.getFormConditions() != null && this
						.getFormConditions().equals(
								castOther.getFormConditions())))
				&& ((this.getFormRace() == castOther.getFormRace()) || (this
						.getFormRace() != null
						&& castOther.getFormRace() != null && this
						.getFormRace().equals(castOther.getFormRace())))
				&& ((this.getFormResult() == castOther.getFormResult()) || (this
						.getFormResult() != null
						&& castOther.getFormResult() != null && this
						.getFormResult().equals(castOther.getFormResult())))
				&& (this.getFormRcId() == castOther.getFormRcId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getFormId();
		result = 37 * result
				+ (getFormHorse() == null ? 0 : this.getFormHorse().hashCode());
		result = 37 * result
				+ (getFormDate() == null ? 0 : this.getFormDate().hashCode());
		result = 37
				* result
				+ (getFormConditions() == null ? 0 : this.getFormConditions()
						.hashCode());
		result = 37 * result
				+ (getFormRace() == null ? 0 : this.getFormRace().hashCode());
		result = 37
				* result
				+ (getFormResult() == null ? 0 : this.getFormResult()
						.hashCode());
		result = 37 * result + this.getFormRcId();
		return result;
	}

}