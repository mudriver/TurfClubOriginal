// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InspectionsTrainersId generated by hbm2java
 */
@Embeddable
public class InspectionsTrainersId implements java.io.Serializable {

	private int trainerId;
	private Date trainerDateRequested;
	private int trainerBatchNo;
	private String trainerAccountNo;
	private String trainerSurname;
	private String trainerFirstName;
	private String trainerAddress1;
	private String trainerAddress2;
	private String trainerAddress3;
	private String trainerStableAddress1;
	private String trainerStableAddress2;
	private String trainerStableAddress3;
	private int trainerHomePhone;
	private int trainerMobilePhone;
	private int trainerFax;
	private String trainerEmail;
	private Date trainerDateOfBirth;
	private String trainerRestricted;
	private String trainerHunterChase;
	private String trainerCurragh;
	private Date trainerInsuranceExpiry;
	private int trainerLastRacecardId;
	private Date trainerTimeEntered;

	public InspectionsTrainersId() {
	}

	public InspectionsTrainersId(int trainerId, Date trainerDateRequested,
			int trainerBatchNo, String trainerAccountNo, String trainerSurname,
			String trainerFirstName, String trainerAddress1,
			String trainerAddress2, String trainerAddress3,
			String trainerStableAddress1, String trainerStableAddress2,
			String trainerStableAddress3, int trainerHomePhone,
			int trainerMobilePhone, int trainerFax, String trainerEmail,
			Date trainerDateOfBirth, String trainerRestricted,
			String trainerHunterChase, String trainerCurragh,
			Date trainerInsuranceExpiry, int trainerLastRacecardId,
			Date trainerTimeEntered) {
		this.trainerId = trainerId;
		this.trainerDateRequested = trainerDateRequested;
		this.trainerBatchNo = trainerBatchNo;
		this.trainerAccountNo = trainerAccountNo;
		this.trainerSurname = trainerSurname;
		this.trainerFirstName = trainerFirstName;
		this.trainerAddress1 = trainerAddress1;
		this.trainerAddress2 = trainerAddress2;
		this.trainerAddress3 = trainerAddress3;
		this.trainerStableAddress1 = trainerStableAddress1;
		this.trainerStableAddress2 = trainerStableAddress2;
		this.trainerStableAddress3 = trainerStableAddress3;
		this.trainerHomePhone = trainerHomePhone;
		this.trainerMobilePhone = trainerMobilePhone;
		this.trainerFax = trainerFax;
		this.trainerEmail = trainerEmail;
		this.trainerDateOfBirth = trainerDateOfBirth;
		this.trainerRestricted = trainerRestricted;
		this.trainerHunterChase = trainerHunterChase;
		this.trainerCurragh = trainerCurragh;
		this.trainerInsuranceExpiry = trainerInsuranceExpiry;
		this.trainerLastRacecardId = trainerLastRacecardId;
		this.trainerTimeEntered = trainerTimeEntered;
	}

	@Column(name = "trainer_id", nullable = false)
	public int getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	@Column(name = "trainer_date_requested", nullable = false, length = 10)
	public Date getTrainerDateRequested() {
		return this.trainerDateRequested;
	}

	public void setTrainerDateRequested(Date trainerDateRequested) {
		this.trainerDateRequested = trainerDateRequested;
	}

	@Column(name = "trainer_batch_no", nullable = false)
	public int getTrainerBatchNo() {
		return this.trainerBatchNo;
	}

	public void setTrainerBatchNo(int trainerBatchNo) {
		this.trainerBatchNo = trainerBatchNo;
	}

	@Column(name = "trainer_account_no", nullable = false, length = 20)
	public String getTrainerAccountNo() {
		return this.trainerAccountNo;
	}

	public void setTrainerAccountNo(String trainerAccountNo) {
		this.trainerAccountNo = trainerAccountNo;
	}

	@Column(name = "trainer_surname", nullable = false, length = 200)
	public String getTrainerSurname() {
		return this.trainerSurname;
	}

	public void setTrainerSurname(String trainerSurname) {
		this.trainerSurname = trainerSurname;
	}

	@Column(name = "trainer_first_name", nullable = false, length = 200)
	public String getTrainerFirstName() {
		return this.trainerFirstName;
	}

	public void setTrainerFirstName(String trainerFirstName) {
		this.trainerFirstName = trainerFirstName;
	}

	@Column(name = "trainer_address1", nullable = false, length = 200)
	public String getTrainerAddress1() {
		return this.trainerAddress1;
	}

	public void setTrainerAddress1(String trainerAddress1) {
		this.trainerAddress1 = trainerAddress1;
	}

	@Column(name = "trainer_address2", nullable = false, length = 200)
	public String getTrainerAddress2() {
		return this.trainerAddress2;
	}

	public void setTrainerAddress2(String trainerAddress2) {
		this.trainerAddress2 = trainerAddress2;
	}

	@Column(name = "trainer_address3", nullable = false, length = 200)
	public String getTrainerAddress3() {
		return this.trainerAddress3;
	}

	public void setTrainerAddress3(String trainerAddress3) {
		this.trainerAddress3 = trainerAddress3;
	}

	@Column(name = "trainer_stable_address1", nullable = false, length = 200)
	public String getTrainerStableAddress1() {
		return this.trainerStableAddress1;
	}

	public void setTrainerStableAddress1(String trainerStableAddress1) {
		this.trainerStableAddress1 = trainerStableAddress1;
	}

	@Column(name = "trainer_stable_address2", nullable = false, length = 200)
	public String getTrainerStableAddress2() {
		return this.trainerStableAddress2;
	}

	public void setTrainerStableAddress2(String trainerStableAddress2) {
		this.trainerStableAddress2 = trainerStableAddress2;
	}

	@Column(name = "trainer_stable_address3", nullable = false, length = 200)
	public String getTrainerStableAddress3() {
		return this.trainerStableAddress3;
	}

	public void setTrainerStableAddress3(String trainerStableAddress3) {
		this.trainerStableAddress3 = trainerStableAddress3;
	}

	@Column(name = "trainer_home_phone", nullable = false)
	public int getTrainerHomePhone() {
		return this.trainerHomePhone;
	}

	public void setTrainerHomePhone(int trainerHomePhone) {
		this.trainerHomePhone = trainerHomePhone;
	}

	@Column(name = "trainer_mobile_phone", nullable = false)
	public int getTrainerMobilePhone() {
		return this.trainerMobilePhone;
	}

	public void setTrainerMobilePhone(int trainerMobilePhone) {
		this.trainerMobilePhone = trainerMobilePhone;
	}

	@Column(name = "trainer_fax", nullable = false)
	public int getTrainerFax() {
		return this.trainerFax;
	}

	public void setTrainerFax(int trainerFax) {
		this.trainerFax = trainerFax;
	}

	@Column(name = "trainer_email", nullable = false, length = 200)
	public String getTrainerEmail() {
		return this.trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	@Column(name = "trainer_date_of_birth", nullable = false, length = 10)
	public Date getTrainerDateOfBirth() {
		return this.trainerDateOfBirth;
	}

	public void setTrainerDateOfBirth(Date trainerDateOfBirth) {
		this.trainerDateOfBirth = trainerDateOfBirth;
	}

	@Column(name = "trainer_restricted", nullable = false, length = 200)
	public String getTrainerRestricted() {
		return this.trainerRestricted;
	}

	public void setTrainerRestricted(String trainerRestricted) {
		this.trainerRestricted = trainerRestricted;
	}

	@Column(name = "trainer_hunter_chase", nullable = false, length = 200)
	public String getTrainerHunterChase() {
		return this.trainerHunterChase;
	}

	public void setTrainerHunterChase(String trainerHunterChase) {
		this.trainerHunterChase = trainerHunterChase;
	}

	@Column(name = "trainer_curragh", nullable = false, length = 200)
	public String getTrainerCurragh() {
		return this.trainerCurragh;
	}

	public void setTrainerCurragh(String trainerCurragh) {
		this.trainerCurragh = trainerCurragh;
	}

	@Column(name = "trainer_insurance_expiry", nullable = false, length = 10)
	public Date getTrainerInsuranceExpiry() {
		return this.trainerInsuranceExpiry;
	}

	public void setTrainerInsuranceExpiry(Date trainerInsuranceExpiry) {
		this.trainerInsuranceExpiry = trainerInsuranceExpiry;
	}

	@Column(name = "trainer_last_racecard_id", nullable = false)
	public int getTrainerLastRacecardId() {
		return this.trainerLastRacecardId;
	}

	public void setTrainerLastRacecardId(int trainerLastRacecardId) {
		this.trainerLastRacecardId = trainerLastRacecardId;
	}

	@Column(name = "trainer_time_entered", nullable = false, length = 19)
	public Date getTrainerTimeEntered() {
		return this.trainerTimeEntered;
	}

	public void setTrainerTimeEntered(Date trainerTimeEntered) {
		this.trainerTimeEntered = trainerTimeEntered;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InspectionsTrainersId))
			return false;
		InspectionsTrainersId castOther = (InspectionsTrainersId) other;

		return (this.getTrainerId() == castOther.getTrainerId())
				&& ((this.getTrainerDateRequested() == castOther
						.getTrainerDateRequested()) || (this
						.getTrainerDateRequested() != null
						&& castOther.getTrainerDateRequested() != null && this
						.getTrainerDateRequested().equals(
								castOther.getTrainerDateRequested())))
				&& (this.getTrainerBatchNo() == castOther.getTrainerBatchNo())
				&& ((this.getTrainerAccountNo() == castOther
						.getTrainerAccountNo()) || (this.getTrainerAccountNo() != null
						&& castOther.getTrainerAccountNo() != null && this
						.getTrainerAccountNo().equals(
								castOther.getTrainerAccountNo())))
				&& ((this.getTrainerSurname() == castOther.getTrainerSurname()) || (this
						.getTrainerSurname() != null
						&& castOther.getTrainerSurname() != null && this
						.getTrainerSurname().equals(
								castOther.getTrainerSurname())))
				&& ((this.getTrainerFirstName() == castOther
						.getTrainerFirstName()) || (this.getTrainerFirstName() != null
						&& castOther.getTrainerFirstName() != null && this
						.getTrainerFirstName().equals(
								castOther.getTrainerFirstName())))
				&& ((this.getTrainerAddress1() == castOther
						.getTrainerAddress1()) || (this.getTrainerAddress1() != null
						&& castOther.getTrainerAddress1() != null && this
						.getTrainerAddress1().equals(
								castOther.getTrainerAddress1())))
				&& ((this.getTrainerAddress2() == castOther
						.getTrainerAddress2()) || (this.getTrainerAddress2() != null
						&& castOther.getTrainerAddress2() != null && this
						.getTrainerAddress2().equals(
								castOther.getTrainerAddress2())))
				&& ((this.getTrainerAddress3() == castOther
						.getTrainerAddress3()) || (this.getTrainerAddress3() != null
						&& castOther.getTrainerAddress3() != null && this
						.getTrainerAddress3().equals(
								castOther.getTrainerAddress3())))
				&& ((this.getTrainerStableAddress1() == castOther
						.getTrainerStableAddress1()) || (this
						.getTrainerStableAddress1() != null
						&& castOther.getTrainerStableAddress1() != null && this
						.getTrainerStableAddress1().equals(
								castOther.getTrainerStableAddress1())))
				&& ((this.getTrainerStableAddress2() == castOther
						.getTrainerStableAddress2()) || (this
						.getTrainerStableAddress2() != null
						&& castOther.getTrainerStableAddress2() != null && this
						.getTrainerStableAddress2().equals(
								castOther.getTrainerStableAddress2())))
				&& ((this.getTrainerStableAddress3() == castOther
						.getTrainerStableAddress3()) || (this
						.getTrainerStableAddress3() != null
						&& castOther.getTrainerStableAddress3() != null && this
						.getTrainerStableAddress3().equals(
								castOther.getTrainerStableAddress3())))
				&& (this.getTrainerHomePhone() == castOther
						.getTrainerHomePhone())
				&& (this.getTrainerMobilePhone() == castOther
						.getTrainerMobilePhone())
				&& (this.getTrainerFax() == castOther.getTrainerFax())
				&& ((this.getTrainerEmail() == castOther.getTrainerEmail()) || (this
						.getTrainerEmail() != null
						&& castOther.getTrainerEmail() != null && this
						.getTrainerEmail().equals(castOther.getTrainerEmail())))
				&& ((this.getTrainerDateOfBirth() == castOther
						.getTrainerDateOfBirth()) || (this
						.getTrainerDateOfBirth() != null
						&& castOther.getTrainerDateOfBirth() != null && this
						.getTrainerDateOfBirth().equals(
								castOther.getTrainerDateOfBirth())))
				&& ((this.getTrainerRestricted() == castOther
						.getTrainerRestricted()) || (this
						.getTrainerRestricted() != null
						&& castOther.getTrainerRestricted() != null && this
						.getTrainerRestricted().equals(
								castOther.getTrainerRestricted())))
				&& ((this.getTrainerHunterChase() == castOther
						.getTrainerHunterChase()) || (this
						.getTrainerHunterChase() != null
						&& castOther.getTrainerHunterChase() != null && this
						.getTrainerHunterChase().equals(
								castOther.getTrainerHunterChase())))
				&& ((this.getTrainerCurragh() == castOther.getTrainerCurragh()) || (this
						.getTrainerCurragh() != null
						&& castOther.getTrainerCurragh() != null && this
						.getTrainerCurragh().equals(
								castOther.getTrainerCurragh())))
				&& ((this.getTrainerInsuranceExpiry() == castOther
						.getTrainerInsuranceExpiry()) || (this
						.getTrainerInsuranceExpiry() != null
						&& castOther.getTrainerInsuranceExpiry() != null && this
						.getTrainerInsuranceExpiry().equals(
								castOther.getTrainerInsuranceExpiry())))
				&& (this.getTrainerLastRacecardId() == castOther
						.getTrainerLastRacecardId())
				&& ((this.getTrainerTimeEntered() == castOther
						.getTrainerTimeEntered()) || (this
						.getTrainerTimeEntered() != null
						&& castOther.getTrainerTimeEntered() != null && this
						.getTrainerTimeEntered().equals(
								castOther.getTrainerTimeEntered())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTrainerId();
		result = 37
				* result
				+ (getTrainerDateRequested() == null ? 0 : this
						.getTrainerDateRequested().hashCode());
		result = 37 * result + this.getTrainerBatchNo();
		result = 37
				* result
				+ (getTrainerAccountNo() == null ? 0 : this
						.getTrainerAccountNo().hashCode());
		result = 37
				* result
				+ (getTrainerSurname() == null ? 0 : this.getTrainerSurname()
						.hashCode());
		result = 37
				* result
				+ (getTrainerFirstName() == null ? 0 : this
						.getTrainerFirstName().hashCode());
		result = 37
				* result
				+ (getTrainerAddress1() == null ? 0 : this.getTrainerAddress1()
						.hashCode());
		result = 37
				* result
				+ (getTrainerAddress2() == null ? 0 : this.getTrainerAddress2()
						.hashCode());
		result = 37
				* result
				+ (getTrainerAddress3() == null ? 0 : this.getTrainerAddress3()
						.hashCode());
		result = 37
				* result
				+ (getTrainerStableAddress1() == null ? 0 : this
						.getTrainerStableAddress1().hashCode());
		result = 37
				* result
				+ (getTrainerStableAddress2() == null ? 0 : this
						.getTrainerStableAddress2().hashCode());
		result = 37
				* result
				+ (getTrainerStableAddress3() == null ? 0 : this
						.getTrainerStableAddress3().hashCode());
		result = 37 * result + this.getTrainerHomePhone();
		result = 37 * result + this.getTrainerMobilePhone();
		result = 37 * result + this.getTrainerFax();
		result = 37
				* result
				+ (getTrainerEmail() == null ? 0 : this.getTrainerEmail()
						.hashCode());
		result = 37
				* result
				+ (getTrainerDateOfBirth() == null ? 0 : this
						.getTrainerDateOfBirth().hashCode());
		result = 37
				* result
				+ (getTrainerRestricted() == null ? 0 : this
						.getTrainerRestricted().hashCode());
		result = 37
				* result
				+ (getTrainerHunterChase() == null ? 0 : this
						.getTrainerHunterChase().hashCode());
		result = 37
				* result
				+ (getTrainerCurragh() == null ? 0 : this.getTrainerCurragh()
						.hashCode());
		result = 37
				* result
				+ (getTrainerInsuranceExpiry() == null ? 0 : this
						.getTrainerInsuranceExpiry().hashCode());
		result = 37 * result + this.getTrainerLastRacecardId();
		result = 37
				* result
				+ (getTrainerTimeEntered() == null ? 0 : this
						.getTrainerTimeEntered().hashCode());
		return result;
	}

}
