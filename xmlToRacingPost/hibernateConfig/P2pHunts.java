// default package
// Generated 15-Oct-2014 16:45:06 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * P2pHunts generated by hbm2java
 */
@Entity
@Table(name = "p2p_hunts", catalog = "p2p")
public class P2pHunts implements java.io.Serializable {

	private int huntId;
	private String huntName;
	private int huntPrice;
	private boolean huntLive;
	private Set p2pHunterCertses = new HashSet(0);

	public P2pHunts() {
	}

	public P2pHunts(int huntId, String huntName, int huntPrice, boolean huntLive) {
		this.huntId = huntId;
		this.huntName = huntName;
		this.huntPrice = huntPrice;
		this.huntLive = huntLive;
	}

	public P2pHunts(int huntId, String huntName, int huntPrice,
			boolean huntLive, Set p2pHunterCertses) {
		this.huntId = huntId;
		this.huntName = huntName;
		this.huntPrice = huntPrice;
		this.huntLive = huntLive;
		this.p2pHunterCertses = p2pHunterCertses;
	}

	@Id
	@Column(name = "hunt_id", unique = true, nullable = false)
	public int getHuntId() {
		return this.huntId;
	}

	public void setHuntId(int huntId) {
		this.huntId = huntId;
	}

	@Column(name = "hunt_name", nullable = false, length = 200)
	public String getHuntName() {
		return this.huntName;
	}

	public void setHuntName(String huntName) {
		this.huntName = huntName;
	}

	@Column(name = "hunt_price", nullable = false)
	public int getHuntPrice() {
		return this.huntPrice;
	}

	public void setHuntPrice(int huntPrice) {
		this.huntPrice = huntPrice;
	}

	@Column(name = "hunt_live", nullable = false)
	public boolean isHuntLive() {
		return this.huntLive;
	}

	public void setHuntLive(boolean huntLive) {
		this.huntLive = huntLive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "p2pHunts")
	public Set getP2pHunterCertses() {
		return this.p2pHunterCertses;
	}

	public void setP2pHunterCertses(Set p2pHunterCertses) {
		this.p2pHunterCertses = p2pHunterCertses;
	}

}
