// default package
// Generated 31-Oct-2014 14:49:01 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DisCategories generated by hbm2java
 */
@Entity
@Table(name = "dis_categories", catalog = "turf201_disciplinaries")
public class DisCategories implements java.io.Serializable {

	private Integer catId;
	private String catName;
	private int catStatusId;

	public DisCategories() {
	}

	public DisCategories(String catName, int catStatusId) {
		this.catName = catName;
		this.catStatusId = catStatusId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cat_id", unique = true, nullable = false)
	public Integer getCatId() {
		return this.catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	@Column(name = "cat_name", nullable = false, length = 100)
	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Column(name = "cat_status_id", nullable = false)
	public int getCatStatusId() {
		return this.catStatusId;
	}

	public void setCatStatusId(int catStatusId) {
		this.catStatusId = catStatusId;
	}

}