package <package>;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name = <table>, catalog = <database>)
public class $className$ implements java.io.Serializable {

	private $variable; separator="\n"$; 
	

	public $className$() {

	}

	public <className>(<variable>) {
		this.alertHorseId = alertHorseId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "alert_horse_alert_id", unique = true, nullable = false)
	public Integer getAlertHorseAlertId() {
		return this.alertHorseAlertId;
	}

	public void setAlertHorseAlertId(Integer alertHorseAlertId) {
		this.alertHorseAlertId = alertHorseAlertId;
	}

	@Column(name = "alert_horse_id", nullable = false)
	public String getAlertHorseId() {
		return this.alertHorseId;
	}

	public void setAlertHorseId(String alertHorseId) {
		this.alertHorseId = alertHorseId;
	}

	@Basic(optional=true)
	@NotFound(action=NotFoundAction.IGNORE)  
	@OneToOne( optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "alert_racecard_id", nullable = true)
	public VetreportRacecard getReportRacecardId() {
		return reportRacecardId;
	}

	public void setReportRacecardId(VetreportRacecard reportRacecardId) {
		this.reportRacecardId = reportRacecardId;
	}
	


	

}
