// default package
// Generated 28-Apr-2015 14:52:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Sheet1Id generated by hbm2java
 */
@Embeddable
public class Sheet1Id implements java.io.Serializable {

	private String a;
	private String b;
	private String c;
	private String d;
	private String e;

	public Sheet1Id() {
	}

	public Sheet1Id(String a, String b, String c, String d, String e) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}

	@Column(name = "A", length = 29)
	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	@Column(name = "B", length = 57)
	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	@Column(name = "C", length = 10)
	public String getC() {
		return this.c;
	}

	public void setC(String c) {
		this.c = c;
	}

	@Column(name = "D", length = 10)
	public String getD() {
		return this.d;
	}

	public void setD(String d) {
		this.d = d;
	}

	@Column(name = "E", length = 26)
	public String getE() {
		return this.e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Sheet1Id))
			return false;
		Sheet1Id castOther = (Sheet1Id) other;

		return ((this.getA() == castOther.getA()) || (this.getA() != null
				&& castOther.getA() != null && this.getA().equals(
				castOther.getA())))
				&& ((this.getB() == castOther.getB()) || (this.getB() != null
						&& castOther.getB() != null && this.getB().equals(
						castOther.getB())))
				&& ((this.getC() == castOther.getC()) || (this.getC() != null
						&& castOther.getC() != null && this.getC().equals(
						castOther.getC())))
				&& ((this.getD() == castOther.getD()) || (this.getD() != null
						&& castOther.getD() != null && this.getD().equals(
						castOther.getD())))
				&& ((this.getE() == castOther.getE()) || (this.getE() != null
						&& castOther.getE() != null && this.getE().equals(
						castOther.getE())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getA() == null ? 0 : this.getA().hashCode());
		result = 37 * result + (getB() == null ? 0 : this.getB().hashCode());
		result = 37 * result + (getC() == null ? 0 : this.getC().hashCode());
		result = 37 * result + (getD() == null ? 0 : this.getD().hashCode());
		result = 37 * result + (getE() == null ? 0 : this.getE().hashCode());
		return result;
	}

}