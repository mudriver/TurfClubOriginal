package ie.turfclub.xmlToRacingPost.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="p2p_owners_handlers")
public class OwnerHandler implements Serializable  {

	private static final long serialVersionUID = 42L;
	
	@Id
	 @GeneratedValue
	 @Column(name = "owner_handler_id")
	private Integer id;
	@Size(min=6, max=6, message="Please enter 6 characters")
	@Column(name = "owner_handler_account_no")
	private String owner_handler_account_no;
	 @Column(name = "owner_handler_password")
	private String owner_handler_password;
	 @Column(name = "owner_handler_name")
	private String owner_handler_name;
	 @Column(name = "owner_handler_owner_colours")
	private String owner_handler_owner_colours;
	 @Column(name = "owner_handler_handler")
	private String owner_handler_handler;   
    @Column(name = "owner_handler_enabled")
    private boolean owner_handler_enabled;

	
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwner_handler_account_no() {
		return owner_handler_account_no;
	}
	public void setOwner_handler_account_no(String owner_handler_account_no) {
		this.owner_handler_account_no = owner_handler_account_no;
	}
	public String getOwner_handler_password() {
		return owner_handler_password;
	}
	public void setOwner_handler_password(String owner_handler_password) {
		this.owner_handler_password = owner_handler_password;
	}
	public String getOwner_handler_name() {
		return owner_handler_name;
	}
	public void setOwner_handler_name(String owner_handler_name) {
		this.owner_handler_name = owner_handler_name;
	}
	public String getOwner_handler_owner_colours() {
		return owner_handler_owner_colours;
	}
	public void setOwner_handler_owner_colours(String owner_handler_owner_colours) {
		this.owner_handler_owner_colours = owner_handler_owner_colours;
	}
	public String getOwner_handler_handler() {
		return owner_handler_handler;
	}
	public void setOwner_handler_handler(String owner_handler_handler) {
		this.owner_handler_handler = owner_handler_handler;
	}
	public boolean isOwner_handler_enabled() {
		return owner_handler_enabled;
	}
	public void setOwner_handler_enabled(boolean owner_handler_enabled) {
		this.owner_handler_enabled = owner_handler_enabled;
	}

	
	

	 
	 
}
