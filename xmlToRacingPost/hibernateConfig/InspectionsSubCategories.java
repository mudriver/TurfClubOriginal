// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * InspectionsSubCategories generated by hbm2java
 */
@Entity
@Table(name = "inspections_sub_categories", catalog = "inspections")
public class InspectionsSubCategories implements java.io.Serializable {

	private Integer subCatId;
	private String subCatName;
	private int subCatCategoryId;

	public InspectionsSubCategories() {
	}

	public InspectionsSubCategories(String subCatName, int subCatCategoryId) {
		this.subCatName = subCatName;
		this.subCatCategoryId = subCatCategoryId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sub_cat_id", unique = true, nullable = false)
	public Integer getSubCatId() {
		return this.subCatId;
	}

	public void setSubCatId(Integer subCatId) {
		this.subCatId = subCatId;
	}

	@Column(name = "sub_cat_name", nullable = false, length = 200)
	public String getSubCatName() {
		return this.subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	@Column(name = "sub_cat_category_id", nullable = false)
	public int getSubCatCategoryId() {
		return this.subCatCategoryId;
	}

	public void setSubCatCategoryId(int subCatCategoryId) {
		this.subCatCategoryId = subCatCategoryId;
	}

}
