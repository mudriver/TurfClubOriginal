package ie.turfclub.model;

import ie.turfclub.validation.HorseID;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "p2p_hunter_certs")
public class HorseWithID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5472355901834783966L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue
	@Column(name = "hcert_id")
	@HorseID
	private String id;
	@Column(name = "hcert_horse_name")
	private String horse_name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHorse_name() {
		return horse_name;
	}
	public void setHorse_name(String horse_name) {
		this.horse_name = horse_name;
	}



	
	
	
}
