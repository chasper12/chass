package com.crud.javashastra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.javashastra.entity.Phone;
import com.crud.javashastra.service.PhoneService;

@Controller
public class PhoneControler {
	@Autowired
	PhoneService service;

	@GetMapping("/")
	public String findAll(Model model) {
		model.addAttribute("Phone", service.findallPhone());
		return "all-phone";
	}

	@GetMapping("/add")
	public String Phone (Model model) {
		model.addAttribute("Phone", new Phone());
		return "add-phone";
	}

	@PostMapping("/addphone")
	public String createPhone(Phone phone) {
		service.addPhone(phone);
		return "redirect:/";

	}

	@GetMapping("/edit/{id}")
	public String lunchEditPage(Model model, @PathVariable("id") int id) {
		model.addAttribute("phone", service.findPhoneById(id));
		return "edit-phone";

	}

	@PostMapping("/updatephone")
	public String upadtePhone(Phone phone) {
		service.updatePhone(phone);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deletePhone(@PathVariable("id") int id) {
		service.findPhoneById(id);
		return "redirect:/";
	}

	
	
	}

