// default package
// Generated 28-Apr-2015 14:53:07 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LicTrainers generated by hbm2java
 */
@Entity
@Table(name = "lic_trainers", catalog = "trainers_employees")
public class LicTrainers implements java.io.Serializable {

	private Integer trainerId;
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
	private Set teEmployentHistories = new HashSet(0);

	public LicTrainers() {
	}

	public LicTrainers(Date trainerDateRequested, int trainerBatchNo,
			String trainerAccountNo, String trainerSurname,
			String trainerFirstName, String trainerAddress1,
			String trainerAddress2, String trainerAddress3,
			String trainerStableAddress1, String trainerStableAddress2,
			String trainerStableAddress3, int trainerHomePhone,
			int trainerMobilePhone, int trainerFax, String trainerEmail,
			Date trainerDateOfBirth, String trainerRestricted,
			String trainerHunterChase, String trainerCurragh,
			Date trainerInsuranceExpiry, int trainerLastRacecardId,
			Date trainerTimeEntered) {
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

	public LicTrainers(Date trainerDateRequested, int trainerBatchNo,
			String trainerAccountNo, String trainerSurname,
			String trainerFirstName, String trainerAddress1,
			String trainerAddress2, String trainerAddress3,
			String trainerStableAddress1, String trainerStableAddress2,
			String trainerStableAddress3, int trainerHomePhone,
			int trainerMobilePhone, int trainerFax, String trainerEmail,
			Date trainerDateOfBirth, String trainerRestricted,
			String trainerHunterChase, String trainerCurragh,
			Date trainerInsuranceExpiry, int trainerLastRacecardId,
			Date trainerTimeEntered, Set teEmployentHistories) {
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
		this.teEmployentHistories = teEmployentHistories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "trainer_id", unique = true, nullable = false)
	public Integer getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "trainer_time_entered", nullable = false, length = 19)
	public Date getTrainerTimeEntered() {
		return this.trainerTimeEntered;
	}

	public void setTrainerTimeEntered(Date trainerTimeEntered) {
		this.trainerTimeEntered = trainerTimeEntered;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licTrainers")
	public Set getTeEmployentHistories() {
		return this.teEmployentHistories;
	}

	public void setTeEmployentHistories(Set teEmployentHistories) {
		this.teEmployentHistories = teEmployentHistories;
	}

}
