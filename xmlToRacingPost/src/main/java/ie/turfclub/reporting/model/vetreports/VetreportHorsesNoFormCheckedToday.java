package ie.turfclub.reporting.model.vetreports;
// default package
// Generated 19-Dec-2014 11:30:23 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VetreportHorsesNoFormId generated by hbm2java
 */
@Entity
@Table(name = "vetreport_horses_no_form_checked_today", catalog = "vetreports")
public class VetreportHorsesNoFormCheckedToday implements java.io.Serializable {

	private String checkedHorse;
	private int checkedId;


	public VetreportHorsesNoFormCheckedToday() {
	}

	



	@Column(name = "checked_horse", nullable = false)
	public String getCheckedHorse() {
		return checkedHorse;
	}






	public void setCheckedHorse(String checkedHorse) {
		this.checkedHorse = checkedHorse;
	}






	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "checked_id", nullable = false)
	public int getCheckedId() {
		return checkedId;
	}






	public void setCheckedId(int checkedId) {
		this.checkedId = checkedId;
	}






}
