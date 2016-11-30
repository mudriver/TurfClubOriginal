// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InspectionsSavedSearchesSortById generated by hbm2java
 */
@Embeddable
public class InspectionsSavedSearchesSortById implements java.io.Serializable {

	private int savedSortSearchId;
	private int savedSortSortbyId;

	public InspectionsSavedSearchesSortById() {
	}

	public InspectionsSavedSearchesSortById(int savedSortSearchId,
			int savedSortSortbyId) {
		this.savedSortSearchId = savedSortSearchId;
		this.savedSortSortbyId = savedSortSortbyId;
	}

	@Column(name = "saved_sort_search_id", nullable = false)
	public int getSavedSortSearchId() {
		return this.savedSortSearchId;
	}

	public void setSavedSortSearchId(int savedSortSearchId) {
		this.savedSortSearchId = savedSortSearchId;
	}

	@Column(name = "saved_sort_sortby_id", nullable = false)
	public int getSavedSortSortbyId() {
		return this.savedSortSortbyId;
	}

	public void setSavedSortSortbyId(int savedSortSortbyId) {
		this.savedSortSortbyId = savedSortSortbyId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InspectionsSavedSearchesSortById))
			return false;
		InspectionsSavedSearchesSortById castOther = (InspectionsSavedSearchesSortById) other;

		return (this.getSavedSortSearchId() == castOther.getSavedSortSearchId())
				&& (this.getSavedSortSortbyId() == castOther
						.getSavedSortSortbyId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSavedSortSearchId();
		result = 37 * result + this.getSavedSortSortbyId();
		return result;
	}

}
