package com.manh.spring.mvc.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manh.spring.mvc.domain.Account;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	private Map<Long, Account> accounts = new ConcurrentHashMap<Long, Account>();
	
	// Handle initial form request
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		// "Account" object is created and saved as "account" in
		// the "model" Model object, which is accessible from
		// the view, "account/createForm.jsp", in this example.
		model.addAttribute("account", new Account());
		return "account/createForm";
	}
	
	// Handle form submission
	@RequestMapping(method=RequestMethod.POST)
	public String create(Account account, BindingResult result) {
		// If there is an error either in validation or data binding,
		// display the "account/createForm.jsp" page again.
		if (result.hasErrors()) {
			return "account/createForm";
		}
		
		// If there is no error, add the newly created account into
		// the "accounts" table and then redirect to the /account/{id},
		// which will be handled in the "getView(..) method below.
		this.accounts.put(account.assignId(), account);
		return "redirect:/account/" + account.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Account account = this.accounts.get(id);
		if (account == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute("account", account);
		//return "account/view";		 // Display account detail in form format
		return "account/view2";  // Display account detail in table format
	}

}
