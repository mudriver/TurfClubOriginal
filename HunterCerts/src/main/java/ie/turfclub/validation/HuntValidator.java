package ie.turfclub.validation;

import ie.turfclub.model.Hunt;
import ie.turfclub.service.HuntService;






import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//@ComponentScan("ie.turfclub.service")
public class HuntValidator implements ConstraintValidator<HuntID, String> {

	@Autowired
	HuntService huntService;
	
	@Override
	public void initialize(HuntID arg0) {
		org.springframework.web.context.support.SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
	}

	@Override
	public boolean isValid(String id, ConstraintValidatorContext arg1) {
		
		System.out.println(id);
		System.out.println(huntService.toString());
		Hunt hunt = huntService.getHunt(id);
	
	        if( hunt == null){
	        	
	        	arg1.buildConstraintViolationWithTemplate( "{error.hunt.notvalid}" ).addConstraintViolation();
	        	return false;
	        }
	        else{

	        	return true;
	        }
			
		
		
	}
}