package ie.turfclub.dao;


import ie.turfclub.model.Vaccination;

import java.util.List;

public interface VaccinationsDAO {

	  public void addVaccination(Vaccination vac);
	    public Vaccination getVaccination(int id);
	    public List<Vaccination> getVaccinations(int id);
	
}
