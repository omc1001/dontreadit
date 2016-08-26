package mc;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entitati.Centru;

public class BbValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		 return Centru.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		

		   ValidationUtils.rejectIfEmptyOrWhitespace(e, "centru", "Selectati un centru.");
	}
	
}
