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
@RequestMapping("/")
public class MainController {

	@Autowired
	ItemService itemService;

	/*
	 * This method will display main page with items divided into columns 
	 */
	@RequestMapping(value = { "/", "/main"}, method = RequestMethod.GET)
	public String showMain(ModelMap model) {
		List<Item> readyItems = new ArrayList<Item>();
		List<Item> assignedItems = new ArrayList<Item>();
		List<Item> doneItems = new ArrayList<Item>();
		List<Item> items = itemService.findAllItems();
			
		for(Item i : items) {
			if("ASSIGNED".equals(i.getState())){
				assignedItems.add(i);
			} else if ("DONE".equals(i.getState())) {
				doneItems.add(i);
			} else {
				readyItems.add(i);
			}
		}
		
		model.addAttribute("assigned", assignedItems);
		model.addAttribute("done", doneItems);
		model.addAttribute("ready", readyItems);
		return "main";
	}
}	
	