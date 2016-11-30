package ie.turfclub.pojos;

import ie.turfclub.model.Vaccination;
import ie.turfclub.validation.VaccinationDates;

import java.util.ArrayList;
import java.util.List;

public class VaccinationForm {

	@VaccinationDates
	private List<Vaccination> vaccinations;
	
	
	
	public VaccinationForm(){
		vaccinations = new ArrayList<>();
		Vaccination vac;
		//add three blank vaccinations when initializing the form object
		for(int i=0; i<3; i++){
			vac = new Vaccination();
			vaccinations.add(vac);
		}
	}
	
	
	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}
	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}
	
	
	
	
	
}
