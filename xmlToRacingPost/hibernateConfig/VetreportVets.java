// default package
// Generated 20-Feb-2015 09:56:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VetreportVets generated by hbm2java
 */
@Entity
@Table(name = "vetreport_vets", catalog = "vetreports")
public class VetreportVets implements java.io.Serializable {

	private Integer vetId;
	private String vetName;
	private String vetLogin;
	private String vetPwd;

	public VetreportVets() {
	}

	public VetreportVets(String vetName, String vetLogin, String vetPwd) {
		this.vetName = vetName;
		this.vetLogin = vetLogin;
		this.vetPwd = vetPwd;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vet_id", unique = true, nullable = false)
	public Integer getVetId() {
		return this.vetId;
	}

	public void setVetId(Integer vetId) {
		this.vetId = vetId;
	}

	@Column(name = "vet_name", nullable = false, length = 200)
	public String getVetName() {
		return this.vetName;
	}

	public void setVetName(String vetName) {
		this.vetName = vetName;
	}

	@Column(name = "vet_login", nullable = false, length = 5)
	public String getVetLogin() {
		return this.vetLogin;
	}

	public void setVetLogin(String vetLogin) {
		this.vetLogin = vetLogin;
	}

	@Column(name = "vet_pwd", nullable = false, length = 200)
	public String getVetPwd() {
		return this.vetPwd;
	}

	public void setVetPwd(String vetPwd) {
		this.vetPwd = vetPwd;
	}

}