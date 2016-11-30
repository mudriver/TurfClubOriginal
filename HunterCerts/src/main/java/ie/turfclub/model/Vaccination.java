package ie.turfclub.model;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.common.base.Objects;




@Entity
@Table(name="p2p_vaccinations")
public class Vaccination implements Serializable  {

	private static final long serialVersionUID = 962565180113876324L;
	
	
	@Id
	 @GeneratedValue
	 @Column(name = "vac_id")
	private String vac_id;
	@Column(name = "vac_hcert_id")
	private String vac_hcert_id;
	 @Column(name = "vac_date")
	private String vac_date;
	 @Column(name = "vac_type")
		private String vac_type;
	 @Transient
	 private boolean isValid = false;
	
	
	
	public String getVac_id() {
		return vac_id;
	}

	public void setVac_id(String vac_id) {
		this.vac_id = vac_id;
	}

	public String getVac_hcert_id() {
		return vac_hcert_id;
	}

	public void setVac_hcert_id(String vac_hcert_id) {
		this.vac_hcert_id = vac_hcert_id;
	}

	public String getVac_date() {
		return vac_date;
	}

	public void setVac_date(String vac_date) {
		this.vac_date = vac_date;
	}

	public String getVac_type() {
		return vac_type;
	}

	public void setVac_type(String vac_type) {
		this.vac_type = vac_type;
	}

	@Override
	public String toString() {
		 return String.format(this.vac_date);
		}

	
    public String getStringDate(){
    	String date = null;
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat standard = new SimpleDateFormat("dd/MM/yyyy");
    	if(this.vac_date.contains("-")){
    		
        	
        	try {
        	
        		
        		
    		date = standard.format(sdf.parse(this.vac_date));
    		} catch (ParseException e) {
    			
    			e.printStackTrace();
    		}
    	}
    	else{
    		
        	
        	try {
        	
        		
        		
    		date = standard.format(standard.parse(this.vac_date));
    		} catch (ParseException e) {
    			
    			e.printStackTrace();
    		}
    	}
    	
    	
    	return date;
    }
    
    public String getStringYear(){
   	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	SimpleDateFormat standard = new SimpleDateFormat("dd/MM/yyyy");
   	SimpleDateFormat year = new SimpleDateFormat("yyyy");
   	String date = null;

   	
   		if(this.vac_date.contains("-")){
   			try {
   			date = year.format(sdf.parse(this.vac_date));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
   		}
   		else{
   			try {
   	   			date = year.format(standard.parse(this.vac_date));
   			} catch (ParseException e) {
   				
   				e.printStackTrace();
   			}
   		}
   		
		
   	return date;
   }
    
    
    

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public int hashCode() {
	 return Objects.hashCode(getVac_id());
	}
	
}



