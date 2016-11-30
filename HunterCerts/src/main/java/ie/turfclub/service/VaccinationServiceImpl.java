package ie.turfclub.service;

import ie.turfclub.dao.VaccinationsDAO;
import ie.turfclub.model.Vaccination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class VaccinationServiceImpl implements VaccinationService {

	@Autowired
	VaccinationsDAO vaccinationsDAO;
	
	@Override
	public List<Vaccination> getVaccinations(int id) {
		return vaccinationsDAO.getVaccinations(id);
		 
	}

	@Override
	public Vaccination getVaccination(int id) {
		return vaccinationsDAO.getVaccination(id);
		
	}

	@Override
	public void saveVaccination(Vaccination vac) {
		vaccinationsDAO.addVaccination(vac);

	}

}
