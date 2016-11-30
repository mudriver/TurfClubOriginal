package ie.turfclub.model;

import ie.turfclub.utilities.StringToTitleCase;
import java.io.Serializable;


import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import com.google.common.base.Objects;

@Entity
@Table(name = "p2p_hunter_certs")
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HunterCert implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 96285180113476324L;
	@Id
	@GeneratedValue
	@Column(name = "hcert_id")
	private Integer id;
	@NotNull(message = "{error.huntercert.name.null}")
	@NotEmpty(message = "{error.huntercert.name.empty}")
	@Column(name = "hcert_horse_name")
	private String horse_name;
	@NotNull(message = "{error.huntercert.type.null}")
	@Column(name = "hcert_yob", length = 4)
	private Integer yob;
	@Column(name = "hcert_horse_colours")
	private String horse_colours;
	@Column(name = "hcert_sex")
	private String horse_sex;
	@Column(name = "hcert_sire")
	private String sire;
	@Column(name = "hcert_dam")
	private String dam;
	@Basic(optional=true)
	@Type(type="ie.turfclub.model.Hunt")
	@NotFound(action=NotFoundAction.IGNORE) 
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="hcert_hunt_id", nullable=false)
	private Hunt hunt_id;
	@Basic(optional=true)
	@NotFound(action=NotFoundAction.IGNORE)  
	@OneToOne( optional = true, fetch = FetchType.EAGER)
		@JoinColumn(name="hcert_owner_id", nullable=true)
		private OwnerHandler owner_id;
	@Basic(optional=true)
	@NotFound(action=NotFoundAction.IGNORE) 
	@OneToOne( optional = true, fetch = FetchType.EAGER)
		@JoinColumn(name="hcert_handler_id", nullable=true)
		private OwnerHandler handler_id;
		@Type(type="boolean")
	@Column(name = "hcert_ran_out_ireland")
	private boolean ran_out_of_ireland;
		@Basic(optional=true)
		@Column(name = "hcert_date_issued")
	private Date date_issued;
	@Column(name = "hcert_cert_status")
	private String status;
	@Column(name = "hcert_vaccination_attempts")
	private Integer hcert_vaccination_attempts ;
	@Basic(optional=true)
	@Column(name = "hcert_order_id")
	private String hcert_order_id;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYob() {
		return yob;
	}

	public void setYob(Integer yob) {
		this.yob = yob;
	}

	public String getHorse_name() {
		
		return StringToTitleCase.convertString(horse_name);
	}

	public void setHorse_name(String horse_name) {
		this.horse_name = horse_name;
	}

	public String getHorse_colours() {
		return horse_colours;
	}

	public void setHorse_colours(String horse_colours) {
		this.horse_colours = horse_colours;
	}

	public String getHorse_sex() {
		return horse_sex;
	}

	public void setHorse_sex(String horse_sex) {
		this.horse_sex = horse_sex;
	}

	public String getSire() {
		return sire;
	}

	public void setSire(String sire) {
		this.sire = sire;
	}

	public String getDam() {
		return dam;
	}

	public void setDam(String dam) {
		this.dam = dam;
	}

	public Hunt getHunt_id() {
		return hunt_id;
	}

	public void setHunt_id(Hunt hunt_id) {
		this.hunt_id = hunt_id;
	}

	



	public OwnerHandler getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(OwnerHandler owner_id) {
		this.owner_id = owner_id;
	}

	public OwnerHandler getHandler_id() {
		return handler_id;
	}

	public void setHandler_id(OwnerHandler handler_id) {
		this.handler_id = handler_id;
	}

	public boolean isRan_out_of_ireland() {
		return ran_out_of_ireland;
	}

	public void setRan_out_of_ireland(boolean ran_out_of_ireland) {
		this.ran_out_of_ireland = ran_out_of_ireland;
	}

	public Date getDate_issued() {
		return date_issued;
	}

	public void setDate_issued(Date date_issued) {
		this.date_issued = date_issued;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	public String getHcert_order_id() {
		return hcert_order_id;
	}

	public void setHcert_order_id(String hcert_order_id) {
		this.hcert_order_id = hcert_order_id;
	}

	public Integer getHcert_vaccination_attempts() {
		return hcert_vaccination_attempts;
	}

	public void setHcert_vaccination_attempts(Integer hcert_vaccination_attempts) {
		this.hcert_vaccination_attempts = hcert_vaccination_attempts;
	}

	@Override
	public String toString() {
		return String.format("HCert - Id: [%s]  YOB: [%s]  Name: [%s]",
				this.id, this.yob, this.horse_name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		if (o instanceof HunterCert) {
			final HunterCert other = (HunterCert) o;
			return Objects.equal(getId(), other.getId())
					&& Objects.equal(getYob(), other.getYob())
					&& Objects.equal(getHorse_name(), other.getHorse_name());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getYob(), getHorse_name());
	}

}