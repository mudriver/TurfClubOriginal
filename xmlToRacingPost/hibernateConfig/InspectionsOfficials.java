// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * InspectionsOfficials generated by hbm2java
 */
@Entity
@Table(name = "inspections_officials", catalog = "inspections", uniqueConstraints = @UniqueConstraint(columnNames = {
		"officials_first_name", "officials_surname" }))
public class InspectionsOfficials implements java.io.Serializable {

	private Integer officialsId;
	private String officialsFirstName;
	private String officialsSurname;
	private String officialsInitials;
	private boolean officialShowOnProgram;

	public InspectionsOfficials() {
	}

	public InspectionsOfficials(String officialsFirstName,
			String officialsSurname, boolean officialShowOnProgram) {
		this.officialsFirstName = officialsFirstName;
		this.officialsSurname = officialsSurname;
		this.officialShowOnProgram = officialShowOnProgram;
	}

	public InspectionsOfficials(String officialsFirstName,
			String officialsSurname, String officialsInitials,
			boolean officialShowOnProgram) {
		this.officialsFirstName = officialsFirstName;
		this.officialsSurname = officialsSurname;
		this.officialsInitials = officialsInitials;
		this.officialShowOnProgram = officialShowOnProgram;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "officials_id", unique = true, nullable = false)
	public Integer getOfficialsId() {
		return this.officialsId;
	}

	public void setOfficialsId(Integer officialsId) {
		this.officialsId = officialsId;
	}

	@Column(name = "officials_first_name", nullable = false, length = 200)
	public String getOfficialsFirstName() {
		return this.officialsFirstName;
	}

	public void setOfficialsFirstName(String officialsFirstName) {
		this.officialsFirstName = officialsFirstName;
	}

	@Column(name = "officials_surname", nullable = false, length = 200)
	public String getOfficialsSurname() {
		return this.officialsSurname;
	}

	public void setOfficialsSurname(String officialsSurname) {
		this.officialsSurname = officialsSurname;
	}

	@Column(name = "officials_initials", length = 10)
	public String getOfficialsInitials() {
		return this.officialsInitials;
	}

	public void setOfficialsInitials(String officialsInitials) {
		this.officialsInitials = officialsInitials;
	}

	@Column(name = "official_show_on_program", nullable = false)
	public boolean isOfficialShowOnProgram() {
		return this.officialShowOnProgram;
	}

	public void setOfficialShowOnProgram(boolean officialShowOnProgram) {
		this.officialShowOnProgram = officialShowOnProgram;
	}

}
