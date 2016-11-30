package ie.turfclub.utilities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;











import ie.turfclub.model.Vaccination;

public class VaccinationChecker {

	private static final String PRIMARYVAC1 = "P1";
	private static final String PRIMARYVAC2 = "P2";
	private static final String BOOSTER = "B";
	private static final String YEARLYBOOSTER = "YB";
	private static final int PRIMARYVAC2MIN = 21;
	private static final int PRIMARYVAC2MAX = 92;
	private static final int BOOSTERMIN = 150;
	private static final int BOOSTERMAX = 215;
	private static final int YEARLYBOOSTERMIN = 7;
	private int YEARLYBOOSTERMAX;
	
	private static final DateTime TODAY = new DateTime();
	private static final GregorianCalendar CAL = (GregorianCalendar) GregorianCalendar.getInstance();
	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("dd/MM/yyyy");

	private String lastVacType;
	
	
	public static void main(String[] args){
		
		List<Vaccination> vacs = new ArrayList<>();
		Vaccination vac = new Vaccination();
		vac.setVac_date("2008-12-24");
		vac.setVac_type(PRIMARYVAC1);
		vacs.add(vac);
		Vaccination vac1 = new Vaccination();
		vac1.setVac_date("2009-01-24");
		vac1.setVac_type(PRIMARYVAC2);
		vacs.add(vac1);
		Vaccination vac2 = new Vaccination();
		vac2.setVac_date("2009-07-04");
		vac2.setVac_type(BOOSTER);
		vacs.add(vac2);
		Vaccination vac3 = new Vaccination();
		vac3.setVac_date("2009-12-19");
		vac3.setVac_type(YEARLYBOOSTER);
		vacs.add(vac3);
		Vaccination vac4 = new Vaccination();
		vac4.setVac_date("2010-12-10");
		vac4.setVac_type(YEARLYBOOSTER);
		vacs.add(vac4);
		Vaccination vac5 = new Vaccination();
		vac5.setVac_date("2011-11-25");
		vac5.setVac_type(YEARLYBOOSTER);
		vacs.add(vac5);
		Vaccination vac6 = new Vaccination();
		vac6.setVac_date("2012-11-09");
		vac6.setVac_type(YEARLYBOOSTER);
		vacs.add(vac6);
		Vaccination vac7 = new Vaccination();
		vac7.setVac_date("2014-08-01");
		
		vacs.add(vac7);
		Vaccination vac8 = new Vaccination();
		vac8.setVac_date("2014-09-01");
		
		vacs.add(vac8);
		
		VaccinationChecker check = new VaccinationChecker();
		vacs = check.checkOrderedVaccinations(vacs);
		for(Vaccination vacin : vacs){
			if(!vacin.isValid()){
				System.out.println(vacin.getStringDate() + " " + vacin.getVac_type() + " is not valid");
			}
		}
	}
	
	
	
	
	
	
	
	//takes an input list of vaccinations in the order that they are entered and checks that they are correct and sets the valid flag on any vaccination that is
	public List<Vaccination> checkOrderedVaccinations(List<Vaccination> vaccinationList){
		//make sure all input vaccinations have their type set.
		Vaccination previous = null;
		Vaccination current = null;
		if(!vaccinationList.isEmpty()){
			previous = vaccinationList.get(0);
			current = previous;
			System.out.println( previous.getStringDate()  + " "  + current.getStringDate());
			//the first vaccination record is not valid unless it is a primary vaccination
			if(current.getVac_type() != null){
				current.setValid(current.getVac_type().equals(PRIMARYVAC1));
			}
			else{
				lastVacType = PRIMARYVAC1;
				current.setVac_type(PRIMARYVAC1);
				current.setValid(true);
			}
			
			
			
			
		for(int i=1; i<vaccinationList.size(); i++ ){
			current = vaccinationList.get(i);
			System.out.println(current.getVac_type());
			
			current = setType(current);
			System.out.println(current.getVac_type());
			System.out.println( i + previous.getStringDate()  + " "  + current.getStringDate() + current.getVac_type());
			current.setValid(checkVaccinations(previous, current));
			System.out.println("Valid vaccination " + current.isValid());
			previous = current;
		}
		//check that the last vaccination in the series is not a primary one if it is it's not valid & it is in date
		if(current.getVac_type() == PRIMARYVAC1 || !checkLastVaccination(current)){
			
			current.setValid(false);
		}
		
		
		}
		return vaccinationList;
		
		
	}
	

	
	//set the vaccination type of the current vaccination based on the last type or if already sets keeps record of the type for the next vaccination
	private Vaccination setType(Vaccination vac){
		if(vac.getVac_type() == null){
			
			vac.setVac_type(typeSetter(lastVacType));
			lastVacType = vac.getVac_type();
			return vac;
			
		}
		else{
			
			lastVacType = vac.getVac_type();
			return vac;
		}
	}
	
	//returns what the current vaccination type should be based on the input string of the last type
	private String typeSetter(String lastType){
		
		switch (lastType) {
		case PRIMARYVAC1:
			return PRIMARYVAC2;
		case PRIMARYVAC2:
			return BOOSTER;	
		case BOOSTER:
			return YEARLYBOOSTER;
		case YEARLYBOOSTER:
			return YEARLYBOOSTER;
			
		default:
			return PRIMARYVAC1;
		}
		
	}
	
	
	// checks the second vaccination against the first to ensure it is valid
	private boolean checkVaccinations(Vaccination vac1, Vaccination vac2) {

		// check for leap year and set variable accordingly
		setLeapYear(Integer.parseInt(vac1.getStringYear()),
				Integer.parseInt(vac2.getStringYear()));
		//Set both dates to joda time Date Time
		Date d1 = null;
		Date d2 = null;
		
		try {
			d1 = DATEFORMAT.parse(vac1.getStringDate());
			d2 = DATEFORMAT.parse(vac2.getStringDate());
			
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		DateTime dt1 = new DateTime(d1);
		DateTime dt2 = new DateTime(d2);
		if(TODAY.isBefore(dt2)){
			System.err.println("Date is in the future");
			return false;
		}
		
		
 		int daysBetween = Days.daysBetween(dt1, dt2).getDays();

 		System.out.println(daysBetween);

		switch (vac1.getVac_type()) {

		case PRIMARYVAC1:
			if(vac2.getVac_type().equals(PRIMARYVAC2)){
				if(daysBetween >= PRIMARYVAC2MIN && daysBetween <= PRIMARYVAC2MAX ){
					return true;
				}
				else{
					System.err.println("Primary Vac 2 not in range");
					return false;
				}
			}
			else{
				System.err.println("V1 VAC ORDER Incorrect");
				return false;
			}
		case PRIMARYVAC2:
			if(vac2.getVac_type().equals(BOOSTER)){
				if(daysBetween >= BOOSTERMIN && daysBetween <= BOOSTERMAX ){
					return true;
				}
				else{
					System.err.println("Booster not in range");
					return false;
				}
			}
			else{
				System.err.println("V2 VAC ORDER Incorrect");
				return false;
			}
		case BOOSTER:
			if(vac2.getVac_type().equals(YEARLYBOOSTER)){
				if(daysBetween >= YEARLYBOOSTERMIN && daysBetween <= YEARLYBOOSTERMAX ){
					return true;
				}
				else{
					System.err.println("Yearly not in range");
					return false;
				}
			}
			else{
				System.err.println("B VAC ORDER Incorrect");
				return false;
			}
		case YEARLYBOOSTER:
			if(vac2.getVac_type().equals(YEARLYBOOSTER)){
				if(daysBetween >= YEARLYBOOSTERMIN && daysBetween <= YEARLYBOOSTERMAX ){
					return true;
				}
				else{
					System.err.println("2nd Yearly not in range " + daysBetween + " " + vac1.getStringDate() + " " + vac2.getStringDate());
					return false;
				}
			}
			else if(vac2.getVac_type().equals(PRIMARYVAC1)){
				return true;
			}
			else{
				System.err.println("YB VAC ORDER Incorrect");
				return false;
			}
		default:
			System.err.println("ERROR");
			return false;

		}

	}
	
	
	// checks the second vaccination against the first to ensure it is valid
	private boolean checkLastVaccination(Vaccination vac) {

		// check for leap year and set variable accordingly
		setLeapYear(Integer.parseInt(vac.getStringYear()), TODAY.getYear());
		//Set both dates to joda time Date Time
		Date d1 = null;
	
		
		try {
			d1 = DATEFORMAT.parse(vac.getStringDate());
			
			
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		DateTime dt1 = new DateTime(d1);
	
		if(TODAY.isBefore(dt1)){
			System.err.println("Date is in the future");
			return false;
		}
		
		
 		int daysBetween = Days.daysBetween(dt1, TODAY).getDays();
		

		switch (vac.getVac_type()) {

	
			
		case PRIMARYVAC2:
			
				if(daysBetween <= BOOSTERMAX ){
					return true;
				}
				else{
					System.err.println("Booster not in range - out of date");
					return false;
				}
			
			
		case BOOSTER:
		
				if( daysBetween <= YEARLYBOOSTERMAX ){
					return true;
				}
				else{
					System.err.println("Yearly not in range - out of date");
					return false;
				}
			
		case YEARLYBOOSTER:
			
				if( daysBetween <= YEARLYBOOSTERMAX ){
					return true;
				}
				else{
					System.err.println("2nd Yearly not in range - out of date");
					return false;
				}
		
		default:
			System.err.println("ERROR");
			return false;

		}

	}
	
	

	public void setLeapYear(int year1, int year2) {

		if (CAL.isLeapYear(year1) || CAL.isLeapYear(year2)) {
			System.err.println("Leap year" + year1 + " " + year2);
			YEARLYBOOSTERMAX = 366;
		} else {
			YEARLYBOOSTERMAX = 365;
		}

	}

}
