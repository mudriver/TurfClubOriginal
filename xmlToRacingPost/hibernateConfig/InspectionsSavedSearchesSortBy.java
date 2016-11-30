// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * InspectionsSavedSearchesSortBy generated by hbm2java
 */
@Entity
@Table(name = "inspections_saved_searches_sort_by", catalog = "inspections")
public class InspectionsSavedSearchesSortBy implements java.io.Serializable {

	private InspectionsSavedSearchesSortById id;

	public InspectionsSavedSearchesSortBy() {
	}

	public InspectionsSavedSearchesSortBy(InspectionsSavedSearchesSortById id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "savedSortSearchId", column = @Column(name = "saved_sort_search_id", nullable = false)),
			@AttributeOverride(name = "savedSortSortbyId", column = @Column(name = "saved_sort_sortby_id", nullable = false)) })
	public InspectionsSavedSearchesSortById getId() {
		return this.id;
	}

	public void setId(InspectionsSavedSearchesSortById id) {
		this.id = id;
	}

}