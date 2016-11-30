package ie.turfclub.validation;


import ie.turfclub.service.OwnerHandlerService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountNoValidator implements ConstraintValidator<AccountNo, String> {

	@Autowired
	OwnerHandlerService ownerService;
	
	@Override
	public void initialize(AccountNo arg0) {
		org.springframework.web.context.support.SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
		
	}

	@Override
	public boolean isValid(String accountNo, ConstraintValidatorContext arg1) {
		
		
		
	
	        if(ownerService.getOwner(accountNo) == null){
	        	
	        	arg1.buildConstraintViolationWithTemplate( "{error.accountNo.notvalid}" ).addConstraintViolation();
	        	return false;
	        }
	        else{
	        	System.out.println(ownerService.getOwner(accountNo).getOwner_handler_owner_colours());
	        	return true;
	        }
			
		
		
	}

	
}
