package com.sda.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TagController {

//	@Autowired
//	TagService tagService;
		
	@Autowired
	MessageSource messageSource;

	
	/*
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/tagsList" }, method = RequestMethod.GET)
	public String showTags(ModelMap model) {
//		List<User> users = userService.findAllUsers();
//		model.addAttribute("users", users);
		return "tagsList";
	}

	/*
	 * This method will show user details.
	 */
//	@RequestMapping(value = { "/user-{userId}-info" }, method = RequestMethod.GET)
//	public String showOneUser(ModelMap model, @PathVariable int userId) {
//		User user = userService.findUserById(userId);
//		model.addAttribute("user", user);
//		return "userInfo";
//	}

	/*
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newTag" }, method = RequestMethod.GET)
	public String newTag(ModelMap model) {
//		User user = new User();
//		model.addAttribute("user", user);
//		model.addAttribute("edit", false);
		return "tagRegistration";
	}	
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
//	@RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
//	public String saveUser(@Valid User user, BindingResult result,
//			ModelMap model) {
//
//		if (result.hasErrors()) {
//			return "userRegistration";
//		}
//
//		
//		if(!userService.isUserIdUnique(user.getUserId())){
//			FieldError idError = new FieldError("user","userId",messageSource.getMessage("non.unique.id", new Integer[]{user.getUserId()}, Locale.getDefault()));
//		    result.addError(idError);
//			return "userRegistration";
//		}
//		
//		userService.saveUser(user);
//
//		model.addAttribute("success", "User " + user.getLogin() + " registered successfully DEBUG: jesteœmy ju¿ w POST");
//		return "main";
//	}


	
	/*
	 * This method will provide the medium to update an existing user.
	 */
//	@RequestMapping(value = { "/edit-{userId}-user" }, method = RequestMethod.GET)
//	public String editUser(@PathVariable int userId, ModelMap model) {
//		User user = userService.findUserById(userId);
//		model.addAttribute("user", user);
//		model.addAttribute("edit", true);
//		return "userRegistration";
//	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating user in database.
	 */
//	@RequestMapping(value = { "/edit-{userId}-user" }, method = RequestMethod.POST)
//	public String updateUser(@Valid User user, BindingResult result,
//			ModelMap model, @PathVariable String userId) {
//		
//		if (result.hasErrors()) {
//			return "userRegistration";
//		}
//
//		userService.updateUser(user);
//
//		model.addAttribute("success", "User " + user.getLogin()	+ " updated successfully");
//		return "usersList";
//	}
	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
//	@RequestMapping(value = { "/delete-{userId}-user" }, method = RequestMethod.GET)
//	public String deleteUser(@PathVariable int userId) {
//		userService.deleteUserById(userId);
//		return "redirect:/usersList";
//	}

}
