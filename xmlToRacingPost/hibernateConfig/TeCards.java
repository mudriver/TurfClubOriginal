// default package
// Generated 28-Apr-2015 14:57:35 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TeCards generated by hbm2java
 */
@Entity
@Table(name = "te_cards", catalog = "trainers_employees")
public class TeCards implements java.io.Serializable {

	private Integer cardsCardId;
	private TeEmployees teEmployees;
	private String cardsCardNumber;
	private Date cardsIssueDate;
	private Boolean cardsCardReturnedToOffice;
	private Boolean cardsPreviousAirCardHolder;
	private Set teEmployentHistories = new HashSet(0);

	public TeCards() {
	}

	public TeCards(TeEmployees teEmployees, String cardsCardNumber) {
		this.teEmployees = teEmployees;
		this.cardsCardNumber = cardsCardNumber;
	}

	public TeCards(TeEmployees teEmployees, String cardsCardNumber,
			Date cardsIssueDate, Boolean cardsCardReturnedToOffice,
			Boolean cardsPreviousAirCardHolder, Set teEmployentHistories) {
		this.teEmployees = teEmployees;
		this.cardsCardNumber = cardsCardNumber;
		this.cardsIssueDate = cardsIssueDate;
		this.cardsCardReturnedToOffice = cardsCardReturnedToOffice;
		this.cardsPreviousAirCardHolder = cardsPreviousAirCardHolder;
		this.teEmployentHistories = teEmployentHistories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cards_card_id", unique = true, nullable = false)
	public Integer getCardsCardId() {
		return this.cardsCardId;
	}

	public void setCardsCardId(Integer cardsCardId) {
		this.cardsCardId = cardsCardId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cards_employee_id", nullable = false)
	public TeEmployees getTeEmployees() {
		return this.teEmployees;
	}

	public void setTeEmployees(TeEmployees teEmployees) {
		this.teEmployees = teEmployees;
	}

	@Column(name = "cards_card_number", nullable = false, length = 5)
	public String getCardsCardNumber() {
		return this.cardsCardNumber;
	}

	public void setCardsCardNumber(String cardsCardNumber) {
		this.cardsCardNumber = cardsCardNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "cards_issue_date", length = 10)
	public Date getCardsIssueDate() {
		return this.cardsIssueDate;
	}

	public void setCardsIssueDate(Date cardsIssueDate) {
		this.cardsIssueDate = cardsIssueDate;
	}

	@Column(name = "cards_card_returned_to_office")
	public Boolean getCardsCardReturnedToOffice() {
		return this.cardsCardReturnedToOffice;
	}

	public void setCardsCardReturnedToOffice(Boolean cardsCardReturnedToOffice) {
		this.cardsCardReturnedToOffice = cardsCardReturnedToOffice;
	}

	@Column(name = "cards_previous_air_card_holder")
	public Boolean getCardsPreviousAirCardHolder() {
		return this.cardsPreviousAirCardHolder;
	}

	public void setCardsPreviousAirCardHolder(Boolean cardsPreviousAirCardHolder) {
		this.cardsPreviousAirCardHolder = cardsPreviousAirCardHolder;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teCards")
	public Set getTeEmployentHistories() {
		return this.teEmployentHistories;
	}

	public void setTeEmployentHistories(Set teEmployentHistories) {
		this.teEmployentHistories = teEmployentHistories;
	}

}
