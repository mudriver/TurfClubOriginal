// default package
// Generated 15-Oct-2014 16:45:06 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * P2pFixtures generated by hbm2java
 */
@Entity
@Table(name = "p2p_fixtures", catalog = "p2p")
public class P2pFixtures implements java.io.Serializable {

	private Integer fixtureId;
	private Date fixtureDate;
	private String fixtureName;

	public P2pFixtures() {
	}

	public P2pFixtures(Date fixtureDate, String fixtureName) {
		this.fixtureDate = fixtureDate;
		this.fixtureName = fixtureName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "fixture_id", unique = true, nullable = false)
	public Integer getFixtureId() {
		return this.fixtureId;
	}

	public void setFixtureId(Integer fixtureId) {
		this.fixtureId = fixtureId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fixture_date", nullable = false, length = 10)
	public Date getFixtureDate() {
		return this.fixtureDate;
	}

	public void setFixtureDate(Date fixtureDate) {
		this.fixtureDate = fixtureDate;
	}

	@Column(name = "fixture_name", nullable = false, length = 200)
	public String getFixtureName() {
		return this.fixtureName;
	}

	public void setFixtureName(String fixtureName) {
		this.fixtureName = fixtureName;
	}

}
