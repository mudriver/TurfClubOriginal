package ie.turfclub.xmlToRacingPost.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="p2p_hunts")
public class Hunt implements Serializable  {

	private static final long serialVersionUID = 96285180113476324L;
	
	@Id
	 @GeneratedValue

	 @Column(name = "hunt_id")
	private String id;
	@Column(name = "hunt_name", length=50)
	private String hunt_name;
	 @Column(name = "hunt_price", length=4)
	private Integer hunt_price;
	
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


	
}
