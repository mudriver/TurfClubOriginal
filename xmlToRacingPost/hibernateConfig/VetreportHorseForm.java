// default package
// Generated 20-Feb-2015 09:56:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VetreportHorseForm generated by hbm2java
 */
@Entity
@Table(name = "vetreport_horse_form", catalog = "vetreports")
public class VetreportHorseForm implements java.io.Serializable {

	private VetreportHorseFormId id;

	public VetreportHorseForm() {
	}

	public VetreportHorseForm(VetreportHorseFormId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "formId", column = @Column(name = "form_id", nullable = false)),
			@AttributeOverride(name = "formHorse", column = @Column(name = "form_horse", nullable = false, length = 200)),
			@AttributeOverride(name = "formDate", column = @Column(name = "form_date", nullable = false, length = 10)),
			@AttributeOverride(name = "formConditions", column = @Column(name = "form_conditions", nullable = false, length = 50)),
			@AttributeOverride(name = "formRace", column = @Column(name = "form_race", nullable = false, length = 50)),
			@AttributeOverride(name = "formResult", column = @Column(name = "form_result", nullable = false, length = 200)),
			@AttributeOverride(name = "formRcId", column = @Column(name = "form_rc_id", nullable = false)) })
	public VetreportHorseFormId getId() {
		return this.id;
	}

	public void setId(VetreportHorseFormId id) {
		this.id = id;
	}

}
