package ie.turfclub.reporting.model.pointToPoint;
// default package
// Generated 02-Oct-2014 15:38:46 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * P2pOwnersHandlers generated by hbm2java
 */
@Entity
@Table(name = "p2p_owners_handlers", catalog = "p2p")
public class OwnersHandlers implements java.io.Serializable {

	private int ownerHandlerId;
	private String ownerHandlerAccountNo;
	private String ownerHandlerPassword;
	private String ownerHandlerName;
	private boolean ownerHandlerOwner;
	private String ownerHandlerOwnerColours;
	private boolean ownerHandlerHandler;
	private byte ownerHandlerEnabled;

	public OwnersHandlers() {
	}

	public OwnersHandlers(int ownerHandlerId, String ownerHandlerAccountNo,
			String ownerHandlerPassword, String ownerHandlerName,
			boolean ownerHandlerOwner, boolean ownerHandlerHandler,
			byte ownerHandlerEnabled) {
		this.ownerHandlerId = ownerHandlerId;
		this.ownerHandlerAccountNo = ownerHandlerAccountNo;
		this.ownerHandlerPassword = ownerHandlerPassword;
		this.ownerHandlerName = ownerHandlerName;
		this.ownerHandlerOwner = ownerHandlerOwner;
		this.ownerHandlerHandler = ownerHandlerHandler;
		this.ownerHandlerEnabled = ownerHandlerEnabled;
	}

	public OwnersHandlers(int ownerHandlerId, String ownerHandlerAccountNo,
			String ownerHandlerPassword, String ownerHandlerName,
			boolean ownerHandlerOwner, String ownerHandlerOwnerColours,
			boolean ownerHandlerHandler, byte ownerHandlerEnabled) {
		this.ownerHandlerId = ownerHandlerId;
		this.ownerHandlerAccountNo = ownerHandlerAccountNo;
		this.ownerHandlerPassword = ownerHandlerPassword;
		this.ownerHandlerName = ownerHandlerName;
		this.ownerHandlerOwner = ownerHandlerOwner;
		this.ownerHandlerOwnerColours = ownerHandlerOwnerColours;
		this.ownerHandlerHandler = ownerHandlerHandler;
		this.ownerHandlerEnabled = ownerHandlerEnabled;
	}

	@Id
	@Column(name = "owner_handler_id", unique = true, nullable = false)
	public int getOwnerHandlerId() {
		return this.ownerHandlerId;
	}

	public void setOwnerHandlerId(int ownerHandlerId) {
		this.ownerHandlerId = ownerHandlerId;
	}

	@Column(name = "owner_handler_account_no", nullable = false, length = 11)
	public String getOwnerHandlerAccountNo() {
		return this.ownerHandlerAccountNo;
	}

	public void setOwnerHandlerAccountNo(String ownerHandlerAccountNo) {
		this.ownerHandlerAccountNo = ownerHandlerAccountNo;
	}

	@Column(name = "owner_handler_password", nullable = false, length = 200)
	public String getOwnerHandlerPassword() {
		return this.ownerHandlerPassword;
	}

	public void setOwnerHandlerPassword(String ownerHandlerPassword) {
		this.ownerHandlerPassword = ownerHandlerPassword;
	}

	@Column(name = "owner_handler_name", nullable = false, length = 250)
	public String getOwnerHandlerName() {
		return this.ownerHandlerName;
	}

	public void setOwnerHandlerName(String ownerHandlerName) {
		this.ownerHandlerName = ownerHandlerName;
	}

	@Column(name = "owner_handler_owner", nullable = false)
	public boolean isOwnerHandlerOwner() {
		return this.ownerHandlerOwner;
	}

	public void setOwnerHandlerOwner(boolean ownerHandlerOwner) {
		this.ownerHandlerOwner = ownerHandlerOwner;
	}

	@Column(name = "owner_handler_owner_colours", length = 250)
	public String getOwnerHandlerOwnerColours() {
		return this.ownerHandlerOwnerColours;
	}

	public void setOwnerHandlerOwnerColours(String ownerHandlerOwnerColours) {
		this.ownerHandlerOwnerColours = ownerHandlerOwnerColours;
	}

	@Column(name = "owner_handler_handler", nullable = false)
	public boolean isOwnerHandlerHandler() {
		return this.ownerHandlerHandler;
	}

	public void setOwnerHandlerHandler(boolean ownerHandlerHandler) {
		this.ownerHandlerHandler = ownerHandlerHandler;
	}

	@Column(name = "owner_handler_enabled", nullable = false)
	public byte getOwnerHandlerEnabled() {
		return this.ownerHandlerEnabled;
	}

	public void setOwnerHandlerEnabled(byte ownerHandlerEnabled) {
		this.ownerHandlerEnabled = ownerHandlerEnabled;
	}

}
