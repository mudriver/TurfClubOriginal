package ie.turfclub.validation;

import ie.turfclub.model.HunterCert;
import ie.turfclub.service.HunterCertService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class HorseValidator implements ConstraintValidator<HorseID, String> {

	
	@Autowired
	HunterCertService huntService;
	@Override
	public void initialize(HorseID arg0) {
		org.springframework.web.context.support.SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
		
	}

	@Override
	public boolean isValid(String horseID, ConstraintValidatorContext arg1) {
		//System.out.println(horseID);
		if(horseID == null){
			arg1.buildConstraintViolationWithTemplate( "{error.horse.notvalid}" ).addConstraintViolation();
			return false;
		}
		
	
		else{
			
			HunterCert cert = huntService.getHunterCert(Integer.parseInt(horseID));
			//System.out.println(cert.getStatus());
			if(cert == null){
				return false;
			}
			else if(cert.getHcert_vaccination_attempts() >= 3){
				arg1.buildConstraintViolationWithTemplate( "{error.horse.tooManyAttempts}" ).addConstraintViolation();
				return false;
			}
			else if(!cert.getStatus().equals("UPLOADED")){
				arg1.buildConstraintViolationWithTemplate( "{error.horse.alreadyPaid}" ).addConstraintViolation();
				return false;
			}
			
			else{
				return true;
			}
			
			
		}
		
	}

	
}
