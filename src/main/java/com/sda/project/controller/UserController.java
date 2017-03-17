package com.sda.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.omg.CORBA.DomainManagerOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sda.project.model.Item;
import com.sda.project.model.User;
import com.sda.project.service.ItemService;
//import com.sda.project.model.EmployeeService;
import com.sda.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
		
	@Autowired
	MessageSource messageSource;

	
	/*
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/usersList" }, method = RequestMethod.GET)
	public String showUsers(ModelMap model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "usersList";
	}

	/*
	 * This method will show user details.
	 */
	@RequestMapping(value = { "/user-{userId}-details" }, method = RequestMethod.GET)
	public String showUserDetails(ModelMap model, @PathVariable int userId) {
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		return "userDetails";
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
	 * saving user in database.
	 */
	@RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "userRegistration";
		}

		userService.saveUser(user);
		return "redirect:/usersList";
	}


	
	/*
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-{userId}-user" }, method = RequestMethod.GET)
	public String editUser(@PathVariable int userId, ModelMap model) {
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "userRegistration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating user in database.
	 */
	@RequestMapping(value = { "/edit-{userId}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String userId) {
		
		if (result.hasErrors()) {
			return "userRegistration";
		}

		userService.updateUser(user);

		return "redirect:/usersList";
	}
	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{userId}-user" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int userId) {
		userService.deleteUserById(userId);
		return "redirect:/usersList";
	}

}
