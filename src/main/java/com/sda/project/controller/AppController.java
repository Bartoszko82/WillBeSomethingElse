package com.sda.project.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sda.project.model.User;
//import com.sda.project.model.EmployeeService;
import com.sda.project.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	UserService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will show main page.
	 */
	@RequestMapping(value = { "/", "/main"}, method = RequestMethod.GET)
	public String showMain(ModelMap model) {
		List<User> users = service.findAllUsers();
		model.addAttribute("users", users);
		return "main";
	}

	/*
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/usersList" }, method = RequestMethod.GET)
	public String showUsers(ModelMap model) {
		List<User> users = service.findAllUsers();
		model.addAttribute("users", users);
		return "usersList";
	}

	/*
	 * This method will show user details.
	 */
	@RequestMapping(value = { "/user-{id}-info" }, method = RequestMethod.GET)
	public String showOneUser(ModelMap model, @PathVariable int id) {
		User user = service.findUserById(id);
		model.addAttribute("user", user);
		return "userInfo";
	}

	/*
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newUser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "userRegistration";
	}	
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "userRegistration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
		 * and applying it on field [ssn] of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!service.isUserIdUnique(user.getId())){
			FieldError idError = new FieldError("user","id",messageSource.getMessage("non.unique.id", new Integer[]{user.getId()}, Locale.getDefault()));
		    result.addError(idError);
			return "userRegistration";
		}
		
		service.saveUser(user);

		model.addAttribute("success", "User " + user.getLogin() + " registered successfully");
		return "success";
	}

	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.GET)
	public String editUser(@PathVariable int id, ModelMap model) {
		User user = service.findUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "userRegistration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String id) {
		
		if (result.hasErrors()) {
			return "userRegistration";
		}

		if(!service.isUserIdUnique(user.getId())){
			FieldError idError =new FieldError("user","id",messageSource.getMessage("non.unique.id", new Integer[]{user.getId()}, Locale.getDefault()));
		    result.addError(idError);
			return "userRegistration";
		}

		service.updateUser(user);

		model.addAttribute("success", "User " + user.getLogin()	+ " updated successfully");
		return "success";
	}
	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-user" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {
		service.deleteUserById(id);
		return "redirect:/usersList";
	}

}
