// default package
// Generated 31-Oct-2014 14:49:01 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DisUsers generated by hbm2java
 */
@Entity
@Table(name = "dis_users", catalog = "turf201_disciplinaries")
public class DisUsers implements java.io.Serializable {

	private String userName;
	private long userMobileNormal;
	private String userType;
	private long userMobile;

	public DisUsers() {
	}

	public DisUsers(String userName, long userMobileNormal, String userType,
			long userMobile) {
		this.userName = userName;
		this.userMobileNormal = userMobileNormal;
		this.userType = userType;
		this.userMobile = userMobile;
	}

	@Id
	@Column(name = "user_name", unique = true, nullable = false, length = 200)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_mobile_normal", nullable = false)
	public long getUserMobileNormal() {
		return this.userMobileNormal;
	}

	public void setUserMobileNormal(long userMobileNormal) {
		this.userMobileNormal = userMobileNormal;
	}

	@Column(name = "user_type", nullable = false, length = 7)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "user_mobile", nullable = false)
	public long getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(long userMobile) {
		this.userMobile = userMobile;
	}

}
