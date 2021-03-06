// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InspectionsHandlersId generated by hbm2java
 */
@Embeddable
public class InspectionsHandlersId implements java.io.Serializable {

	private int ownerId;
	private String ownerFirstName;
	private String ownerAccountNo;
	private String ownerSurname;
	private String ownerAddress1;
	private String ownerAddress2;
	private String ownerAddress3;
	private String ownerAddress4;
	private String ownerMobileNo;
	private String ownerPhoneNo;
	private String ownerEmail;
	private Date ownerDateOfBirth;
	private String ownerHriAccNo;
	private String ownerStatus;

	public InspectionsHandlersId() {
	}

	public InspectionsHandlersId(int ownerId, String ownerFirstName,
			String ownerAccountNo, String ownerSurname, String ownerAddress1,
			String ownerAddress2, String ownerAddress3, String ownerAddress4,
			String ownerMobileNo, String ownerPhoneNo, String ownerEmail,
			Date ownerDateOfBirth, String ownerHriAccNo, String ownerStatus) {
		this.ownerId = ownerId;
		this.ownerFirstName = ownerFirstName;
		this.ownerAccountNo = ownerAccountNo;
		this.ownerSurname = ownerSurname;
		this.ownerAddress1 = ownerAddress1;
		this.ownerAddress2 = ownerAddress2;
		this.ownerAddress3 = ownerAddress3;
		this.ownerAddress4 = ownerAddress4;
		this.ownerMobileNo = ownerMobileNo;
		this.ownerPhoneNo = ownerPhoneNo;
		this.ownerEmail = ownerEmail;
		this.ownerDateOfBirth = ownerDateOfBirth;
		this.ownerHriAccNo = ownerHriAccNo;
		this.ownerStatus = ownerStatus;
	}

	@Column(name = "owner_id", nullable = false)
	public int getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Column(name = "owner_first_name", nullable = false, length = 200)
	public String getOwnerFirstName() {
		return this.ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	@Column(name = "owner_account_no", nullable = false, length = 200)
	public String getOwnerAccountNo() {
		return this.ownerAccountNo;
	}

	public void setOwnerAccountNo(String ownerAccountNo) {
		this.ownerAccountNo = ownerAccountNo;
	}

	@Column(name = "owner_surname", nullable = false, length = 200)
	public String getOwnerSurname() {
		return this.ownerSurname;
	}

	public void setOwnerSurname(String ownerSurname) {
		this.ownerSurname = ownerSurname;
	}

	@Column(name = "owner_address1", nullable = false, length = 200)
	public String getOwnerAddress1() {
		return this.ownerAddress1;
	}

	public void setOwnerAddress1(String ownerAddress1) {
		this.ownerAddress1 = ownerAddress1;
	}

	@Column(name = "owner_address2", nullable = false, length = 200)
	public String getOwnerAddress2() {
		return this.ownerAddress2;
	}

	public void setOwnerAddress2(String ownerAddress2) {
		this.ownerAddress2 = ownerAddress2;
	}

	@Column(name = "owner_address3", nullable = false, length = 200)
	public String getOwnerAddress3() {
		return this.ownerAddress3;
	}

	public void setOwnerAddress3(String ownerAddress3) {
		this.ownerAddress3 = ownerAddress3;
	}

	@Column(name = "owner_address4", nullable = false, length = 200)
	public String getOwnerAddress4() {
		return this.ownerAddress4;
	}

	public void setOwnerAddress4(String ownerAddress4) {
		this.ownerAddress4 = ownerAddress4;
	}

	@Column(name = "owner_mobile_no", nullable = false, length = 200)
	public String getOwnerMobileNo() {
		return this.ownerMobileNo;
	}

	public void setOwnerMobileNo(String ownerMobileNo) {
		this.ownerMobileNo = ownerMobileNo;
	}

	@Column(name = "owner_phone_no", nullable = false, length = 200)
	public String getOwnerPhoneNo() {
		return this.ownerPhoneNo;
	}

	public void setOwnerPhoneNo(String ownerPhoneNo) {
		this.ownerPhoneNo = ownerPhoneNo;
	}

	@Column(name = "owner_email", nullable = false, length = 200)
	public String getOwnerEmail() {
		return this.ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	@Column(name = "owner_date_of_birth", nullable = false, length = 10)
	public Date getOwnerDateOfBirth() {
		return this.ownerDateOfBirth;
	}

	public void setOwnerDateOfBirth(Date ownerDateOfBirth) {
		this.ownerDateOfBirth = ownerDateOfBirth;
	}

	@Column(name = "owner_hri_acc_no", nullable = false, length = 200)
	public String getOwnerHriAccNo() {
		return this.ownerHriAccNo;
	}

	public void setOwnerHriAccNo(String ownerHriAccNo) {
		this.ownerHriAccNo = ownerHriAccNo;
	}

	@Column(name = "owner_status", nullable = false, length = 200)
	public String getOwnerStatus() {
		return this.ownerStatus;
	}

	public void setOwnerStatus(String ownerStatus) {
		this.ownerStatus = ownerStatus;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InspectionsHandlersId))
			return false;
		InspectionsHandlersId castOther = (InspectionsHandlersId) other;

		return (this.getOwnerId() == castOther.getOwnerId())
				&& ((this.getOwnerFirstName() == castOther.getOwnerFirstName()) || (this
						.getOwnerFirstName() != null
						&& castOther.getOwnerFirstName() != null && this
						.getOwnerFirstName().equals(
								castOther.getOwnerFirstName())))
				&& ((this.getOwnerAccountNo() == castOther.getOwnerAccountNo()) || (this
						.getOwnerAccountNo() != null
						&& castOther.getOwnerAccountNo() != null && this
						.getOwnerAccountNo().equals(
								castOther.getOwnerAccountNo())))
				&& ((this.getOwnerSurname() == castOther.getOwnerSurname()) || (this
						.getOwnerSurname() != null
						&& castOther.getOwnerSurname() != null && this
						.getOwnerSurname().equals(castOther.getOwnerSurname())))
				&& ((this.getOwnerAddress1() == castOther.getOwnerAddress1()) || (this
						.getOwnerAddress1() != null
						&& castOther.getOwnerAddress1() != null && this
						.getOwnerAddress1()
						.equals(castOther.getOwnerAddress1())))
				&& ((this.getOwnerAddress2() == castOther.getOwnerAddress2()) || (this
						.getOwnerAddress2() != null
						&& castOther.getOwnerAddress2() != null && this
						.getOwnerAddress2()
						.equals(castOther.getOwnerAddress2())))
				&& ((this.getOwnerAddress3() == castOther.getOwnerAddress3()) || (this
						.getOwnerAddress3() != null
						&& castOther.getOwnerAddress3() != null && this
						.getOwnerAddress3()
						.equals(castOther.getOwnerAddress3())))
				&& ((this.getOwnerAddress4() == castOther.getOwnerAddress4()) || (this
						.getOwnerAddress4() != null
						&& castOther.getOwnerAddress4() != null && this
						.getOwnerAddress4()
						.equals(castOther.getOwnerAddress4())))
				&& ((this.getOwnerMobileNo() == castOther.getOwnerMobileNo()) || (this
						.getOwnerMobileNo() != null
						&& castOther.getOwnerMobileNo() != null && this
						.getOwnerMobileNo()
						.equals(castOther.getOwnerMobileNo())))
				&& ((this.getOwnerPhoneNo() == castOther.getOwnerPhoneNo()) || (this
						.getOwnerPhoneNo() != null
						&& castOther.getOwnerPhoneNo() != null && this
						.getOwnerPhoneNo().equals(castOther.getOwnerPhoneNo())))
				&& ((this.getOwnerEmail() == castOther.getOwnerEmail()) || (this
						.getOwnerEmail() != null
						&& castOther.getOwnerEmail() != null && this
						.getOwnerEmail().equals(castOther.getOwnerEmail())))
				&& ((this.getOwnerDateOfBirth() == castOther
						.getOwnerDateOfBirth()) || (this.getOwnerDateOfBirth() != null
						&& castOther.getOwnerDateOfBirth() != null && this
						.getOwnerDateOfBirth().equals(
								castOther.getOwnerDateOfBirth())))
				&& ((this.getOwnerHriAccNo() == castOther.getOwnerHriAccNo()) || (this
						.getOwnerHriAccNo() != null
						&& castOther.getOwnerHriAccNo() != null && this
						.getOwnerHriAccNo()
						.equals(castOther.getOwnerHriAccNo())))
				&& ((this.getOwnerStatus() == castOther.getOwnerStatus()) || (this
						.getOwnerStatus() != null
						&& castOther.getOwnerStatus() != null && this
						.getOwnerStatus().equals(castOther.getOwnerStatus())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOwnerId();
		result = 37
				* result
				+ (getOwnerFirstName() == null ? 0 : this.getOwnerFirstName()
						.hashCode());
		result = 37
				* result
				+ (getOwnerAccountNo() == null ? 0 : this.getOwnerAccountNo()
						.hashCode());
		result = 37
				* result
				+ (getOwnerSurname() == null ? 0 : this.getOwnerSurname()
						.hashCode());
		result = 37
				* result
				+ (getOwnerAddress1() == null ? 0 : this.getOwnerAddress1()
						.hashCode());
		result = 37
				* result
				+ (getOwnerAddress2() == null ? 0 : this.getOwnerAddress2()
						.hashCode());
		result = 37
				* result
				+ (getOwnerAddress3() == null ? 0 : this.getOwnerAddress3()
						.hashCode());
		result = 37
				* result
				+ (getOwnerAddress4() == null ? 0 : this.getOwnerAddress4()
						.hashCode());
		result = 37
				* result
				+ (getOwnerMobileNo() == null ? 0 : this.getOwnerMobileNo()
						.hashCode());
		result = 37
				* result
				+ (getOwnerPhoneNo() == null ? 0 : this.getOwnerPhoneNo()
						.hashCode());
		result = 37
				* result
				+ (getOwnerEmail() == null ? 0 : this.getOwnerEmail()
						.hashCode());
		result = 37
				* result
				+ (getOwnerDateOfBirth() == null ? 0 : this
						.getOwnerDateOfBirth().hashCode());
		result = 37
				* result
				+ (getOwnerHriAccNo() == null ? 0 : this.getOwnerHriAccNo()
						.hashCode());
		result = 37
				* result
				+ (getOwnerStatus() == null ? 0 : this.getOwnerStatus()
						.hashCode());
		return result;
	}

}
