// default package
// Generated 31-Oct-2014 14:49:01 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DisPersons generated by hbm2java
 */
@Entity
@Table(name = "dis_persons", catalog = "turf201_disciplinaries")
public class DisPersons implements java.io.Serializable {

	private Integer perId;
	private String perFirstName;
	private String perSurname;

	public DisPersons() {
	}

	public DisPersons(String perFirstName, String perSurname) {
		this.perFirstName = perFirstName;
		this.perSurname = perSurname;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "per_id", unique = true, nullable = false)
	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	@Column(name = "per_first_name", nullable = false, length = 65535)
	public String getPerFirstName() {
		return this.perFirstName;
	}

	public void setPerFirstName(String perFirstName) {
		this.perFirstName = perFirstName;
	}

	@Column(name = "per_surname", nullable = false, length = 65535)
	public String getPerSurname() {
		return this.perSurname;
	}

	public void setPerSurname(String perSurname) {
		this.perSurname = perSurname;
	}

}
