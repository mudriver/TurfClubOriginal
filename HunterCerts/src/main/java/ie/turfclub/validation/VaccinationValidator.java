package ie.turfclub.validation;

import ie.turfclub.model.HunterCert;
import ie.turfclub.model.Vaccination;
import ie.turfclub.service.HunterCertService;
import ie.turfclub.service.VaccinationService;
import ie.turfclub.utilities.VaccinationChecker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class VaccinationValidator implements
		ConstraintValidator<VaccinationDates, List<Vaccination>> {

	@Autowired
	VaccinationService vacService;
	@Autowired
	HunterCertService huntercertService;

	VaccinationChecker checker = new VaccinationChecker();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	

	

	
	
	@Override
	public void initialize(VaccinationDates arg0) {
		org.springframework.web.context.support.SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	public boolean isValid(List<Vaccination> vacs,
			ConstraintValidatorContext arg1) {

		// check if any dates entered are in order in correct boxes
		boolean no1IsEmpty, no2IsEmpty, no3IsEmpty;
		System.out.println(vacs.get(0).getVac_date());
		no1IsEmpty = vacs.get(0).getVac_date().isEmpty();
		no2IsEmpty = vacs.get(1).getVac_date().isEmpty();
		no3IsEmpty = vacs.get(2).getVac_date().isEmpty();

		if (no1IsEmpty && (!no2IsEmpty || !no3IsEmpty)) {
			arg1.buildConstraintViolationWithTemplate(
					"Box Number 1 Should not be empty when a date is entered in another box!")
					.addConstraintViolation();
			return false;
		} else if (no2IsEmpty && !no3IsEmpty) {
			arg1.buildConstraintViolationWithTemplate(
					"Box Number 2 Should not be empty when a date is entered in box number 3!")
					.addConstraintViolation();
			return false;
		}

		else {

			// if dates are in correct boxes
			// check there are no new vaccinations on the form and if none get
			// existing vaccinations based on huntercertid
			boolean valid = true;
			boolean attempt = false;

			List<Vaccination> vacins = vacService.getVaccinations(Integer
					.parseInt(vacs.get(0).getVac_hcert_id()));
			// if there are no existing vaccinations not valid vaccinations
			// required
			if (vacins.isEmpty()) {
				valid = false;
				return valid;
			}
			// if there are new vaccinations add to the list
			else {
				Date currentDate = new Date();

				Collections.sort(vacins, new Comparator<Vaccination>() {
					@Override
					public int compare(Vaccination vac1, Vaccination vac2) {

						try {
							return dateFormat.parse(vac1.getStringDate())
									.compareTo(
											dateFormat.parse(vac2
													.getStringDate()));
						} catch (ParseException e) {

							e.printStackTrace();
							return 0;
						}
					}
				});

				Date mostRecentVacDate = null;
				try {
					System.out.println(vacins.get(vacins.size() - 1)
							.getStringDate());
					mostRecentVacDate = dateFormat.parse(vacins.get(
							vacins.size() - 1).getStringDate());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (Vaccination vac : vacs) {
					if (!vac.getVac_date().isEmpty()) {
						// check if any date is in the future return false if it
						// is
						Date vacDate = null;
						try {
							System.out.println(vac.getVac_date());
							vacDate = dateFormat.parse(vac.getVac_date());

						} catch (ParseException e) {

							e.printStackTrace();
						}
						if (vacDate.after(currentDate)) {
							arg1.buildConstraintViolationWithTemplate(
									"Vaccination dates cannot be in the future!")
									.addConstraintViolation();
							return false;
						}
						// check that the new dates are not before the current
						// dates
						else if (mostRecentVacDate.after(vacDate)) {
							arg1.buildConstraintViolationWithTemplate(
									"Vaccination dates cannot be before existing dates!")
									.addConstraintViolation();
							return false;
						} else {
							vacins.add(vac);
						}

					}
				}

				// sort the list in date order
				Collections.sort(vacins, new Comparator<Vaccination>() {
					@Override
					public int compare(Vaccination vac1, Vaccination vac2) {

						try {
							return dateFormat.parse(vac1.getStringDate())
									.compareTo(
											dateFormat.parse(vac2
													.getStringDate()));
						} catch (ParseException e) {

							e.printStackTrace();
							return 0;
						}
					}
				});

				// check that the vaccinations are valid using the checker
				vacins = checker.checkOrderedVaccinations(vacins);
				for (Vaccination vacin : vacins) {
					System.out.println(vacin.isValid() + vacin.getStringDate());
					if (!vacin.isValid()) {
						// if there is no id its a new vaccination attempt so
						// set the
						// trigger to update the hcert with a new attempt
						if (vacin.getVac_id() == null) {
							attempt = true;
						}
						valid = false;
					}

				}
				
				System.out.println("Attempt" + attempt);
				// check input list on its own to see if new set of vaccinations
				// has been started
				if (attempt) {
					
					List<Vaccination> vacsList = new ArrayList<>();
					for (Vaccination vac : vacs) {
						if (!vac.getVac_date().isEmpty()) {
							vac.setVac_type(null);
							vacsList.add(vac);
								
							
						}

					}
					vacsList = checker.checkOrderedVaccinations(vacsList);
					boolean newSetValid = true;
					for (Vaccination vac : vacsList) {
						if (!vac.isValid() && vac.getVac_id() == null) {
							
							newSetValid = false;	
							
						}

					}
					if(newSetValid){
						attempt = false;
						valid = true;
						
					}
				}
				System.out.println("Attempt - check new set" + attempt);
				// check input list on its own to see if new set of vaccinations
				// has been started - without the first vaccination in the list
				if (attempt) {
					
					List<Vaccination> vacsList = new ArrayList<>();
					int count = 0;
					for (Vaccination vac : vacs) {
						if (!vac.getVac_date().isEmpty() && count!=0) {
							System.out.println(vac.getVac_date());
							vac.setVac_type(null);
							vacsList.add(vac);
								
							
						}
						count ++;
					}
					System.out.println(vacsList.size());
					boolean newSetValid = true;
					if(vacsList.size() != 0 && vacsList.size() != 1){
						vacsList = checker.checkOrderedVaccinations(vacsList);
						for (Vaccination vac : vacsList) {
							if (!vac.isValid() && vac.getVac_id() == null) {
								
								newSetValid = false;	
								
							}

						}
					}
					else{
						
						newSetValid = false;
					}
					
					
					if(newSetValid){
						attempt = false;
						valid = true;
						
					}
				}
				System.out.println("Attempt - check new set - 1" + attempt);
				
				

				// if there has been a new vaccination attempt increment
				// attempts
				if (attempt) {
					HunterCert cert = huntercertService.getHunterCert(Integer
							.parseInt(vacs.get(0).getVac_hcert_id()));
					cert.setHcert_vaccination_attempts(cert
							.getHcert_vaccination_attempts() + 1);
					if (cert.getHcert_vaccination_attempts() >= 3) {

						arg1.buildConstraintViolationWithTemplate(
								"Too many vaccination attempts!!")
								.addConstraintViolation();
					} else {
						System.out.println("You have "
								+ (3 - cert.getHcert_vaccination_attempts())
								+ " attempts before you will be locked out!");
						int noAttempts = (3 - cert
								.getHcert_vaccination_attempts());
						arg1.buildConstraintViolationWithTemplate(
								"You have "
										+ noAttempts
										+ " attempts before you will be locked out!")
								.addConstraintViolation();
					}

					System.out.println(cert.getHunt_id().getId());
					huntercertService.updateHunterCert(cert);
					return valid;
				} else {
					return valid;
				}
				// System.out.println("Valid " + valid);

			}

		}

	}

}
