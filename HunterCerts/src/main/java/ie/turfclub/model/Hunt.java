package ie.turfclub.model;

import ie.turfclub.validation.HuntID;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;


@Entity
@Table(name="p2p_hunts")
public class Hunt implements Serializable  {

	private static final long serialVersionUID = 96285180113476324L;
	
	@Id
	 @GeneratedValue
	 @HuntID
	 @Column(name = "hunt_id")
	private String id;
	@Column(name = "hunt_name", length=50)
	private String hunt_name;
	 @Column(name = "hunt_price", length=4)
	private Integer hunt_price;
	 @Column(name = "hunt_live", length=1)
	private boolean hunt_live;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHunt_name() {
		return hunt_name;
	}
	public void setHunt_name(String hunt_name) {
		this.hunt_name = hunt_name;
	}
	public Integer getHunt_price() {
		return hunt_price;
	}
	public void setHunt_price(Integer hunt_price) {
		this.hunt_price = hunt_price;
	}
	
	@Override
	public String toString() {
		 return String.format(this.getHunt_name());
		}

	
	
	
	public boolean isHunt_live() {
		return hunt_live;
	}
	public void setHunt_live(boolean hunt_live) {
		this.hunt_live = hunt_live;
	}
	@Override
	public boolean equals(Object o) {
	 if (this == o) return true;
	 if (o == null) return false;

	 if (o instanceof Hunt) {
	  final Hunt other = (Hunt) o;
	  return Objects.equal(getId(), other.getId()) && 
	      Objects.equal(getHunt_price(), other.getHunt_price()) && 
	      Objects.equal(getHunt_name(), other.getHunt_name());
	 }
	 return false;
	}

	@Override
	public int hashCode() {
	 return Objects.hashCode(getId(), getHunt_name(), getHunt_price());
	}
	
}
