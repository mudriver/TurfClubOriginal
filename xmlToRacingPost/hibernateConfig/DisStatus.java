// default package
// Generated 31-Oct-2014 14:49:01 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DisStatus generated by hbm2java
 */
@Entity
@Table(name = "dis_status", catalog = "turf201_disciplinaries")
public class DisStatus implements java.io.Serializable {

	private Integer staId;
	private String staName;

	public DisStatus() {
	}

	public DisStatus(String staName) {
		this.staName = staName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sta_id", unique = true, nullable = false)
	public Integer getStaId() {
		return this.staId;
	}

	public void setStaId(Integer staId) {
		this.staId = staId;
	}

	@Column(name = "sta_name", nullable = false, length = 65535)
	public String getStaName() {
		return this.staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

}
