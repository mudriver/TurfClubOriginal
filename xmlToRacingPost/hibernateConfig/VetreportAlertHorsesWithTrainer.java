// default package
// Generated 20-Feb-2015 09:56:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VetreportAlertHorsesWithTrainer generated by hbm2java
 */
@Entity
@Table(name = "vetreport_alert_horses_with_trainer", catalog = "vetreports")
public class VetreportAlertHorsesWithTrainer implements java.io.Serializable {

	private VetreportAlertHorsesWithTrainerId id;

	public VetreportAlertHorsesWithTrainer() {
	}

	public VetreportAlertHorsesWithTrainer(VetreportAlertHorsesWithTrainerId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "alertId", column = @Column(name = "alert_id", length = 21)),
			@AttributeOverride(name = "alertHorseName", column = @Column(name = "alert_horse_name", length = 200)),
			@AttributeOverride(name = "alertTrainerName", column = @Column(name = "alert_trainer_name", nullable = false, length = 200)) })
	public VetreportAlertHorsesWithTrainerId getId() {
		return this.id;
	}

	public void setId(VetreportAlertHorsesWithTrainerId id) {
		this.id = id;
	}

}
