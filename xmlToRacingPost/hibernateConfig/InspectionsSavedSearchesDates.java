// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * InspectionsSavedSearchesDates generated by hbm2java
 */
@Entity
@Table(name = "inspections_saved_searches_dates", catalog = "inspections")
public class InspectionsSavedSearchesDates implements java.io.Serializable {

	private InspectionsSavedSearchesDatesId id;

	public InspectionsSavedSearchesDates() {
	}

	public InspectionsSavedSearchesDates(InspectionsSavedSearchesDatesId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "savedSearchId", column = @Column(name = "saved_search_id", nullable = false)),
			@AttributeOverride(name = "savedSearchStartDate", column = @Column(name = "saved_search_start_date", length = 10)),
			@AttributeOverride(name = "savedSearchEndDate", column = @Column(name = "saved_search_end_date", length = 10)) })
	public InspectionsSavedSearchesDatesId getId() {
		return this.id;
	}

	public void setId(InspectionsSavedSearchesDatesId id) {
		this.id = id;
	}

}
