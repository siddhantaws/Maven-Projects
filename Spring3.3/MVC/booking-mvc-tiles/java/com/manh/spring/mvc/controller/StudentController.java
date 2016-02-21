package com.manh.spring.mvc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.manh.spring.mvc.model.Student;
import com.manh.spring.mvc.validator.StudentValidator;



@Controller
@RequestMapping("/student")
public class StudentController {

	private StudentValidator studentValidator;

	@Autowired
	public StudentController(StudentValidator studentValidator) {
		this.studentValidator = studentValidator;
	}

//	Handle initial form display
	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(ModelMap model) {
		Student student = new Student();

//		Set Address field
		student.setAddress("1 Dream Land");

//		Set "Math" as default checked value
		student.setSubject(new String[] { "Math" });

//		Set "Male" as default radio button selected value
		student.setSex("M");

//		Set "Spring Core" as the default java skills selection
		student.setSpringExperiences("Spring Core");

//		Initilize a hidden value
		student.setSecretValue("I'm hidden value");

//		Save the command object as "student" so that the "StudentForm" view access it.
		model.addAttribute("student", student);

//		Return form view
		return "StudentForm";
	}

//	Handle form submission
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("student") Student student,
			BindingResult result, SessionStatus status) {
//		Perform validation
		studentValidator.validate(student, result);

		if (result.hasErrors()) {
//			If validation failed, display the form page again
			return "StudentForm";
		} else {
			status.setComplete();
//			If validation succeeded, return "StudentSuccess"
			return "StudentSuccess";
		}
	}

//	"@ModelAttribute" annotation binds a method parameter or method return value
//	to a named model attribute, exposed to a web view. Supported for
//	RequestMapping annotated handler classes. The "subjectList" model attribute is used in
//	the "StudentForm.jsp" page.
	@ModelAttribute("subjectList")
	public List<String> populateSubjectList() {
//		Data referencing for web framework checkboxes
		List<String> subjectList = new ArrayList<String>();
		subjectList.add("Math");
		subjectList.add("Science");
		subjectList.add("Art");
		subjectList.add("Music");
		subjectList.add("Sports");

		return subjectList;
	}
	
	@ModelAttribute("numberList")
	public List<String> populateNumberList() {
//		Data referencing for number radio buttons
		List<String> numberList = new ArrayList<String>();
		numberList.add("Number 1");
		numberList.add("Number 2");
		numberList.add("Number 3");
		numberList.add("Number 4");
		numberList.add("Number 5");

		return numberList;
	}

	@ModelAttribute("springExperiencesList")
	public Map<String, String> populateJavaSkillList() {
//		Data referencing for java skills list box
		Map<String, String> javaSkill = new LinkedHashMap<String, String>();
		javaSkill.put("Spring Core", "Spring Core");
		javaSkill.put("Spring MVC", "Spring MVC");
		javaSkill.put("Spring WebFlow", "Spring WebFlow");
		javaSkill.put("Spring Batch", "Spring Batch");

		return javaSkill;
	}

	@ModelAttribute("countryList")
	public Map<String, String> populateCountryList() {
//		Data referencing for java skills list box
		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("KR", "Korea");
		country.put("SG", "Singapore");
		country.put("FR", "France");

		return country;
	}

//	"@InitBinder" annotation identifies methods which initialize the
//	"org.springframework.web.bind.WebDataBinder" which will be used for
//	populating command and form object arguments of annotated handler methods.
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}