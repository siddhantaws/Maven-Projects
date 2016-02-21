package com.manh.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.manh.spring.mvc.domain.Account;



@Controller
@RequestMapping(value="/account")
@SessionAttributes("account1")
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
	public String create(Account account, 
			BindingResult result) {
		
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
	public String getView(@PathVariable Long id, 
			// Example of @ModelAttribute used as parameter annotation
			@ModelAttribute("subjectList") List<String> subjectList2, 
			Model model) {
		Account account = this.accounts.get(id);
		if (account == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute("account", account);
		model.addAttribute("subjectList2", subjectList2);

		//return "account/view";		 // Display account detail in form format
		return "account/view2";  // Display account detail in table format
	}
	
	// Create “subjectList” model attribute from the return value
	// of the “populateSubjectList()” method. The “subjectList” model
	// attribute is then used in the view as reference data.
	@ModelAttribute("subjectList")
	public List<String> populateSubjectList() {

	        //Data referencing for web framework checkboxes
	        List<String> subjectList = new ArrayList<String>();
	        subjectList.add("Math");
	        subjectList.add("Science");
	        subjectList.add("Art");
	        subjectList.add("Music");
	        subjectList.add("Sports");

	        return subjectList;
	}

}
