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
public class ItemController {

	@Autowired
	ItemService itemService;
		
	@Autowired
	MessageSource messageSource;

	
	/*
	 * This method redirects to itemRegistration form.
	 */
	@RequestMapping(value = { "/newItem" }, method = RequestMethod.GET)
	public String newItem(ModelMap model) {
		Item item = new Item();
		
		model.addAttribute("item", item);
		model.addAttribute("edit", false);
		return "itemRegistration";
	}
	
	/*
	 * This method redirects to itemRegistration form, allows to set item properties and then reloads main page 
	 */
	@RequestMapping(value = { "/newItem" }, method = RequestMethod.POST)
	public String saveItem(Item item, ModelMap model) {

		item.setState("READY");
		itemService.saveItem(item);

		return "redirect:/main";
	}
	
	/*
	 * This method will show item details.
	 */
	@RequestMapping(value = { "/item-{itemId}-details" }, method = RequestMethod.GET)
	public String showItemDetails(ModelMap model, @PathVariable int itemId) {
		Item item = itemService.findItemById(itemId);
		model.addAttribute("item", item);
		return "itemDetails";
	}
	
	/*
	 * Next three methods are used to move items between columns 
	 */
	@RequestMapping(value = { "/set-{itemId}-AsReady" }, method = RequestMethod.GET)
	public String setItemToNew(ModelMap model, @PathVariable int itemId) {
		itemService.setEntityState(itemId, "READY");
		return "redirect:/main";
	}
	
	@RequestMapping(value = { "/set-{itemId}-AsAssigned" }, method = RequestMethod.GET)
	public String setItemToAssigned(ModelMap model, @PathVariable int itemId) {
		itemService.setEntityState(itemId, "ASSIGNED");
		return "redirect:/main";
	}
	
	@RequestMapping(value = { "/set-{itemId}-AsDone" }, method = RequestMethod.GET)
	public String setItemToDone(ModelMap model, @PathVariable int itemId) {
		itemService.setEntityState(itemId, "DONE");
		return "redirect:/main";
	}
	
	/*
	 * This method opens item registration form in order to edit item properties 
	 */
	@RequestMapping(value = { "/edit-{itemId}-item" }, method = RequestMethod.GET)
	public String editItem(@PathVariable int itemId, ModelMap model) {
		Item item = itemService.findItemById(itemId);
		model.addAttribute("item", item);
		model.addAttribute("edit", true);
		return "itemRegistration";
	}

	/*
	 * This method will be called after submitting the form. User will be saved and main page will be reloaded.  
	 */
	@RequestMapping(value = { "/edit-{itemId}-item" }, method = RequestMethod.POST)
	public String updateItem(@Valid Item item, BindingResult result,
			ModelMap model, @PathVariable String itemId) {
		
		if (result.hasErrors()) {
			return "itemRegistration";
		}

		itemService.updateItem(item);
		return "redirect:/main";
	}

	/*
	 * This method will delete item.
	 */
	@RequestMapping(value = { "/delete-{itemId}-item" }, method = RequestMethod.GET)
	public String deleteItem(@PathVariable int itemId) {
		itemService.deleteItemById(itemId);
		return "redirect:/main";
	}
}	
	