package com.manh.spring.mvc.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manh.spring.mvc.domain.Account;
import com.manh.spring.mvc.validators.AccountValidator;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	private Map<Long, Account> accounts = new ConcurrentHashMap<Long, Account>();
	
	// Configure Custom "AccountValidator" to the "WebDataBinder".
	// In this example, we perform two different types of validations,
	// one through the annotations specified in the "Account" class,
	// the other through the validation logic specified in the 
	// "AccountValidator" class.
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new AccountValidator());
    }
    
	// Handle initial form request
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Account());
		return "account/createForm";
	}
	
	// Handle form submission
	@RequestMapping(method=RequestMethod.POST)
	// Now note that we have "@Valid" annotation.  It will validate the
	// values entered against the validation annotations specified in
	// Account class.
	public String create(@Valid Account account, BindingResult result) {
		
		if (result.hasErrors()) {
			return "account/createForm";
		}
		this.accounts.put(account.assignId(), account);
		return "redirect:/account/" + account.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Account account = this.accounts.get(id);
		if (account == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(account);
		//return "account/view";		 // Display account detail in form format
		return "account/view2";  // Display account detail in table format
	}

}
