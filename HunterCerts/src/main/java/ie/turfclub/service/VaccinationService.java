package ie.turfclub.service;

import ie.turfclub.model.Vaccination;

import java.util.List;

public interface VaccinationService {

	public List<Vaccination> getVaccinations(int id);
	public Vaccination getVaccination(int id);
	public void saveVaccination(Vaccination vac);
	
}
