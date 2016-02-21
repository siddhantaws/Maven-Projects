package com.manh.spring.mvc.validators;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.manh.spring.mvc.domain.Account;

// The "Validator" interface is totally divorced from any infrastructure or 
// context; that is to say it is not coupled to validating only objects in 
// the web tier, the data-access tier, or the whatever-tier. As such it is 
// amenable to being used in any layer of an application, and supports the 
// encapsulation of validation logic as a first-class citizen in its own right. 
public class AccountValidator implements Validator{

	public boolean supports(Class clazz) {
		//just validate the Account instances
		return Account.class.isAssignableFrom(clazz);

	}

	// Override this method to provide your own validation logic.
	// 
	public void validate(Object target, Errors errors) {
		
		// We actually don't need this since we do perform non-empty
		// validation through the @NotNull annotation in the 
		// "Account" class itself.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.userName", "Field name is required.");
		
		// If the renewal data is before the current date,
		// it results in validation failure error.
		Account account = (Account)target;
		
		if(account.getRenewalDate().before(new Date())){
			errors.rejectValue("renewalDate", 			// field name
							   "value.renewalDate"); // error code
		}
		
	}
	
}