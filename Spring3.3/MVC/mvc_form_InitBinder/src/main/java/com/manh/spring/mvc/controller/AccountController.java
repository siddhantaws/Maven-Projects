package com.manh.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manh.spring.mvc.binders.NameTypeEditor;
import com.manh.spring.mvc.domain.Account;
import com.manh.spring.mvc.validators.AccountValidator;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	private Map<Long, Account> accounts = new ConcurrentHashMap<Long, Account>();
	
	// "@InitBinder" annotation identifies methods which initialize the 
	// "org.springframework.web.bind.WebDataBinder" which will be used for 
	// populating command and form object arguments of annotated handler methods. 
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    	// Configure Custom "AccountValidator" to the "WebDataBinder"
        binder.setValidator(new AccountValidator());
        
        // Register custom editors. In this example, we register two 
        // custom editors, "CustomDateEditor" and "NameTypeEditor".
        // The "CustomDateEditor" is provided by Spring framework while
        // the "NameTypeEditor" is something we write.
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);	
		binder.registerCustomEditor(Date.class, 
									new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, new NameTypeEditor());

    }
    
	// Handle initial form request
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Account());
		return "account/createForm";
	}
	
	// Handle form submission
	@RequestMapping(method=RequestMethod.POST)
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
