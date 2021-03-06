// default package
// Generated 15-Oct-2014 16:45:06 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * P2pUsers generated by hbm2java
 */
@Entity
@Table(name = "p2p_users", catalog = "p2p")
public class P2pUsers implements java.io.Serializable {

	private Integer userId;
	private String userUsername;
	private String userPassword;
	private byte userEnabled;
	private String userRole;
	private int userHuntId;

	public P2pUsers() {
	}

	public P2pUsers(String userUsername, String userPassword, byte userEnabled,
			String userRole, int userHuntId) {
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userEnabled = userEnabled;
		this.userRole = userRole;
		this.userHuntId = userHuntId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_username", nullable = false, length = 200)
	public String getUserUsername() {
		return this.userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	@Column(name = "user_password", nullable = false, length = 200)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_enabled", nullable = false)
	public byte getUserEnabled() {
		return this.userEnabled;
	}

	public void setUserEnabled(byte userEnabled) {
		this.userEnabled = userEnabled;
	}

	@Column(name = "user_role", nullable = false, length = 20)
	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Column(name = "user_hunt_id", nullable = false)
	public int getUserHuntId() {
		return this.userHuntId;
	}

	public void setUserHuntId(int userHuntId) {
		this.userHuntId = userHuntId;
	}

}
