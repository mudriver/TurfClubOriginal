// default package
// Generated 20-Feb-2015 09:56:42 by Hibernate Tools 3.4.0.CR1

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
 * VetreportHorseForm2 generated by hbm2java
 */
@Entity
@Table(name = "vetreport_horse_form2", catalog = "vetreports")
public class VetreportHorseForm2 implements java.io.Serializable {

	private Integer formId;
	private String formHorse;
	private Date formDate;
	private String formConditions;
	private String formRace;
	private String formResult;
	private int formRcId;

	public VetreportHorseForm2() {
	}

	public VetreportHorseForm2(String formHorse, Date formDate,
			String formConditions, String formRace, String formResult,
			int formRcId) {
		this.formHorse = formHorse;
		this.formDate = formDate;
		this.formConditions = formConditions;
		this.formRace = formRace;
		this.formResult = formResult;
		this.formRcId = formRcId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "form_id", unique = true, nullable = false)
	public Integer getFormId() {
		return this.formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	@Column(name = "form_horse", nullable = false, length = 200)
	public String getFormHorse() {
		return this.formHorse;
	}

	public void setFormHorse(String formHorse) {
		this.formHorse = formHorse;
	}

	@Temporal(TemporalType.DATE)
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

}
