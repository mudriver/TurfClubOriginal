// default package
// Generated 20-Feb-2015 09:56:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VetreportAlertHorses generated by hbm2java
 */
@Entity
@Table(name = "vetreport_alert_horses", catalog = "vetreports")
public class VetreportAlertHorses implements java.io.Serializable {

	private Integer alertHorseAlertId;
	private String alertHorseId;
	private Integer alertRacecardId;

	public VetreportAlertHorses() {
	}

	public VetreportAlertHorses(String alertHorseId) {
		this.alertHorseId = alertHorseId;
	}

	public VetreportAlertHorses(String alertHorseId, Integer alertRacecardId) {
		this.alertHorseId = alertHorseId;
		this.alertRacecardId = alertRacecardId;
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

	@Column(name = "alert_horse_id", nullable = false, length = 20)
	public String getAlertHorseId() {
		return this.alertHorseId;
	}

	public void setAlertHorseId(String alertHorseId) {
		this.alertHorseId = alertHorseId;
	}

	@Column(name = "alert_racecard_id")
	public Integer getAlertRacecardId() {
		return this.alertRacecardId;
	}

	public void setAlertRacecardId(Integer alertRacecardId) {
		this.alertRacecardId = alertRacecardId;
	}

}
