// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * InspectionsTrainers generated by hbm2java
 */
@Entity
@Table(name = "inspections_trainers", catalog = "inspections")
public class InspectionsTrainers implements java.io.Serializable {

	private InspectionsTrainersId id;

	public InspectionsTrainers() {
	}

	public InspectionsTrainers(InspectionsTrainersId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "trainerId", column = @Column(name = "trainer_id", nullable = false)),
			@AttributeOverride(name = "trainerDateRequested", column = @Column(name = "trainer_date_requested", nullable = false, length = 10)),
			@AttributeOverride(name = "trainerBatchNo", column = @Column(name = "trainer_batch_no", nullable = false)),
			@AttributeOverride(name = "trainerAccountNo", column = @Column(name = "trainer_account_no", nullable = false, length = 20)),
			@AttributeOverride(name = "trainerSurname", column = @Column(name = "trainer_surname", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerFirstName", column = @Column(name = "trainer_first_name", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerAddress1", column = @Column(name = "trainer_address1", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerAddress2", column = @Column(name = "trainer_address2", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerAddress3", column = @Column(name = "trainer_address3", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerStableAddress1", column = @Column(name = "trainer_stable_address1", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerStableAddress2", column = @Column(name = "trainer_stable_address2", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerStableAddress3", column = @Column(name = "trainer_stable_address3", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerHomePhone", column = @Column(name = "trainer_home_phone", nullable = false)),
			@AttributeOverride(name = "trainerMobilePhone", column = @Column(name = "trainer_mobile_phone", nullable = false)),
			@AttributeOverride(name = "trainerFax", column = @Column(name = "trainer_fax", nullable = false)),
			@AttributeOverride(name = "trainerEmail", column = @Column(name = "trainer_email", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerDateOfBirth", column = @Column(name = "trainer_date_of_birth", nullable = false, length = 10)),
			@AttributeOverride(name = "trainerRestricted", column = @Column(name = "trainer_restricted", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerHunterChase", column = @Column(name = "trainer_hunter_chase", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerCurragh", column = @Column(name = "trainer_curragh", nullable = false, length = 200)),
			@AttributeOverride(name = "trainerInsuranceExpiry", column = @Column(name = "trainer_insurance_expiry", nullable = false, length = 10)),
			@AttributeOverride(name = "trainerLastRacecardId", column = @Column(name = "trainer_last_racecard_id", nullable = false)),
			@AttributeOverride(name = "trainerTimeEntered", column = @Column(name = "trainer_time_entered", nullable = false, length = 19)) })
	public InspectionsTrainersId getId() {
		return this.id;
	}

	public void setId(InspectionsTrainersId id) {
		this.id = id;
	}

}