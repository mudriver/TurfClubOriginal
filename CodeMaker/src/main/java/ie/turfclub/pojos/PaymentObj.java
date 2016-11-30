package ie.turfclub.pojos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class PaymentObj {

	private String horsesPaid;
	private String terminalId="2422001";
	private String orderId;
	private String currency="EUR";
	private String returnPage="http://www.inhsc.ie:8080/huntercerts/hunterCert/receipt";
	private String amount;		
	private String dateTime;
	private String hash;
	private String description;
	private String secret = "1790testestablished";
	
	
	public String getHorsesPaid() {
		return horsesPaid;
	}
	public void setHorsesPaid(String horsesPaid) {
		this.horsesPaid = horsesPaid;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getReturnPage() {
		return returnPage;
	}
	public void setReturnPage(String returnPage) {
		this.returnPage = returnPage;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

 public String makeHash(){
	 
	 String original = terminalId + orderId + amount + dateTime + returnPage + secret; 
	 MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("MD5");
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		System.out.println("original:" + original);
		System.out.println("digested(hex):" + sb.toString());
		this.hash = sb.toString();
	 return sb.toString();
	 
 }
	
	
	
}
