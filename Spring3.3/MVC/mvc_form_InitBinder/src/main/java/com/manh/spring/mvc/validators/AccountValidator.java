package com.manh.spring.mvc.validators;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.manh.spring.mvc.domain.Account;

public class AccountValidator implements Validator{

	public boolean supports(Class clazz) {
		//just validate the Account instances
		return Account.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.userName", "Field name is required.");
		
		Account account = (Account)target;
		
		if(account.getRenewalDate().before(new Date())){
			errors.rejectValue("renewalDate", 			// field name
							   "value.renewalDate"); // error code
		}
		
	}
	
}