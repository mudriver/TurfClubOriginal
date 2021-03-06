package ie.turfclub.reporting.model.pointToPoint;
// default package
// Generated 02-Oct-2014 15:38:46 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * P2pHunterCerts generated by hbm2java
 */
@Entity
@Table(name = "p2p_hunter_certs", catalog = "p2p")
public class HunterCert implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer hcertId;
	private Hunts p2pHunts;
	private String hcertHorseName;
	private int hcertYob;
	private String hcertHorseColours;
	private String hcertSex;
	private String hcertSire;
	private String hcertDam;
	private Integer hcertOwnerId;
	private Integer hcertHandlerId;
	private boolean hcertRanOutIreland;
	private Date hcertLastWinDate;
	private Date hcertLastRunDate;
	private Date hcertDateIssued;
	private String hcertCertStatus;
	private int hcertVaccinationAttempts;
	private String hcertOrderId;
	private boolean hcertAutumnRejected;
	private boolean hcertRejected;
	private boolean hcertDailyRountineCompleted;
	private Date hcertTransactionTime;
	private HuntercertsSales p2pHuntercertsSales;

	public HunterCert() {
	}

	public HunterCert(String hcertHorseName, int hcertYob,
			String hcertHorseColours, String hcertSex, String hcertSire,
			String hcertDam, boolean hcertRanOutIreland,
			String hcertCertStatus, int hcertVaccinationAttempts,
			boolean hcertRejected, boolean hcertDailyRountineCompleted,
			Date hcertTransactionTime) {
		this.hcertHorseName = hcertHorseName;
		this.hcertYob = hcertYob;
		this.hcertHorseColours = hcertHorseColours;
		this.hcertSex = hcertSex;
		this.hcertSire = hcertSire;
		this.hcertDam = hcertDam;
		this.hcertRanOutIreland = hcertRanOutIreland;
		this.hcertCertStatus = hcertCertStatus;
		this.hcertVaccinationAttempts = hcertVaccinationAttempts;
		this.hcertRejected = hcertRejected;
		this.hcertDailyRountineCompleted = hcertDailyRountineCompleted;
		this.hcertTransactionTime = hcertTransactionTime;
	}

	public HunterCert(Hunts p2pHunts, String hcertHorseName,
			int hcertYob, String hcertHorseColours, String hcertSex,
			String hcertSire, String hcertDam, Integer hcertOwnerId,
			Integer hcertHandlerId, boolean hcertRanOutIreland,
			Date hcertDateIssued, String hcertCertStatus,
			int hcertVaccinationAttempts, String hcertOrderId,
			boolean hcertRejected, boolean hcertDailyRountineCompleted,
			Date hcertTransactionTime, HuntercertsSales p2pHuntercertsSales) {
		this.p2pHunts = p2pHunts;
		this.hcertHorseName = hcertHorseName;
		this.hcertYob = hcertYob;
		this.hcertHorseColours = hcertHorseColours;
		this.hcertSex = hcertSex;
		this.hcertSire = hcertSire;
		this.hcertDam = hcertDam;
		this.hcertOwnerId = hcertOwnerId;
		this.hcertHandlerId = hcertHandlerId;
		this.hcertRanOutIreland = hcertRanOutIreland;
		this.hcertDateIssued = hcertDateIssued;
		this.hcertCertStatus = hcertCertStatus;
		this.hcertVaccinationAttempts = hcertVaccinationAttempts;
		this.hcertOrderId = hcertOrderId;
		this.hcertRejected = hcertRejected;
		this.hcertDailyRountineCompleted = hcertDailyRountineCompleted;
		this.hcertTransactionTime = hcertTransactionTime;
		this.p2pHuntercertsSales = p2pHuntercertsSales;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "hcert_id", unique = true, nullable = false)
	public Integer getHcertId() {
		return this.hcertId;
	}

	public void setHcertId(Integer hcertId) {
		this.hcertId = hcertId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hcert_hunt_id")
	public Hunts getP2pHunts() {
		return this.p2pHunts;
	}

	public void setP2pHunts(Hunts p2pHunts) {
		this.p2pHunts = p2pHunts;
	}
	
	

	@Column(name = "hcert_horse_name", nullable = false, length = 200)
	public String getHcertHorseName() {
		return this.hcertHorseName;
	}

	public void setHcertHorseName(String hcertHorseName) {
		this.hcertHorseName = hcertHorseName;
	}

	@Column(name = "hcert_yob", nullable = false)
	public int getHcertYob() {
		return this.hcertYob;
	}

	public void setHcertYob(int hcertYob) {
		this.hcertYob = hcertYob;
	}

	@Column(name = "hcert_horse_colours", nullable = false, length = 10)
	public String getHcertHorseColours() {
		return this.hcertHorseColours;
	}

	public void setHcertHorseColours(String hcertHorseColours) {
		this.hcertHorseColours = hcertHorseColours;
	}

	@Column(name = "hcert_sex", nullable = false, length = 10)
	public String getHcertSex() {
		return this.hcertSex;
	}

	public void setHcertSex(String hcertSex) {
		this.hcertSex = hcertSex;
	}

	@Column(name = "hcert_sire", nullable = false, length = 200)
	public String getHcertSire() {
		return this.hcertSire;
	}

	public void setHcertSire(String hcertSire) {
		this.hcertSire = hcertSire;
	}

	@Column(name = "hcert_dam", nullable = false, length = 200)
	public String getHcertDam() {
		return this.hcertDam;
	}

	public void setHcertDam(String hcertDam) {
		this.hcertDam = hcertDam;
	}

	@Column(name = "hcert_owner_id")
	public Integer getHcertOwnerId() {
		return this.hcertOwnerId;
	}

	public void setHcertOwnerId(Integer hcertOwnerId) {
		this.hcertOwnerId = hcertOwnerId;
	}

	@Column(name = "hcert_handler_id")
	public Integer getHcertHandlerId() {
		return this.hcertHandlerId;
	}

	public void setHcertHandlerId(Integer hcertHandlerId) {
		this.hcertHandlerId = hcertHandlerId;
	}

	@Column(name = "hcert_ran_out_ireland", nullable = false)
	public boolean isHcertRanOutIreland() {
		return this.hcertRanOutIreland;
	}

	public void setHcertRanOutIreland(boolean hcertRanOutIreland) {
		this.hcertRanOutIreland = hcertRanOutIreland;
	}

	
	
	@Basic(optional=true)
	@Temporal(TemporalType.DATE)
	@Column(name = "hcert_last_win_date", length = 10)
	public Date getHcertLastWinDate() {
		return hcertLastWinDate;
	}

	public void setHcertLastWinDate(Date hcertLastWinDate) {
		this.hcertLastWinDate = hcertLastWinDate;
	}

	@Basic(optional=true)
	@Temporal(TemporalType.DATE)
	@Column(name = "hcert_last_run_date", length = 10)
	public Date getHcertLastRunDate() {
		return hcertLastRunDate;
	}

	public void setHcertLastRunDate(Date hcertLastRunDate) {
		this.hcertLastRunDate = hcertLastRunDate;
	}

	@Basic(optional=true)
	@Temporal(TemporalType.DATE)
	@Column(name = "hcert_date_issued", length = 10)
	public Date getHcertDateIssued() {
		return this.hcertDateIssued;
	}

	public void setHcertDateIssued(Date hcertDateIssued) {
		this.hcertDateIssued = hcertDateIssued;
	}

	@Column(name = "hcert_cert_status", nullable = false, length = 12)
	public String getHcertCertStatus() {
		return this.hcertCertStatus;
	}

	public void setHcertCertStatus(String hcertCertStatus) {
		this.hcertCertStatus = hcertCertStatus;
	}

	@Column(name = "hcert_vaccination_attempts", nullable = false)
	public int getHcertVaccinationAttempts() {
		return this.hcertVaccinationAttempts;
	}

	public void setHcertVaccinationAttempts(int hcertVaccinationAttempts) {
		this.hcertVaccinationAttempts = hcertVaccinationAttempts;
	}

	@Column(name = "hcert_order_id", length = 12, nullable = true)
	public String getHcertOrderId() {
		return this.hcertOrderId;
	}

	public void setHcertOrderId(String hcertOrderId) {
		this.hcertOrderId = hcertOrderId;
	}

	
	@Column(name = "hcert_autumn_rejected", nullable = false)
	public boolean isHcertAutumnRejected() {
		return this.hcertAutumnRejected;
	}

	public void setHcertAutumnRejected(boolean hcertAutumnRejected) {
		this.hcertAutumnRejected = hcertAutumnRejected;
	}
	
	@Column(name = "hcert_rejected", nullable = false)
	public boolean isHcertRejected() {
		return this.hcertRejected;
	}

	public void setHcertRejected(boolean hcertRejected) {
		this.hcertRejected = hcertRejected;
	}

	@Column(name = "hcert_daily_rountine_completed", nullable = false)
	public boolean isHcertDailyRountineCompleted() {
		return this.hcertDailyRountineCompleted;
	}

	public void setHcertDailyRountineCompleted(
			boolean hcertDailyRountineCompleted) {
		this.hcertDailyRountineCompleted = hcertDailyRountineCompleted;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hcert_transaction_time", nullable = false, length = 19)
	public Date getHcertTransactionTime() {
		return this.hcertTransactionTime;
	}

	public void setHcertTransactionTime(Date hcertTransactionTime) {
		this.hcertTransactionTime = hcertTransactionTime;
	}

/*	@OneToOne(fetch = FetchType.LAZY, mappedBy = "p2pHunterCerts")
	public HuntercertsSales getP2pHuntercertsSales() {
		return this.p2pHuntercertsSales;
	}

	public void setP2pHuntercertsSales(HuntercertsSales p2pHuntercertsSales) {
		this.p2pHuntercertsSales = p2pHuntercertsSales;
	}
*/
}
