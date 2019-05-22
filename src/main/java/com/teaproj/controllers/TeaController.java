package com.teaproj.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teaproj.models.User;
import com.teaproj.services.UserManagerService;

@Controller
public class TeaController {
	
	@Autowired
	UserManagerService ums;
	
	@RequestMapping("/")
	public String returnIndex(Model model) {
		return "index";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String showRegistration(Model model) {
		User user = new User();
		model.addAttribute("userModel", user);
		
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registerAccount(@ModelAttribute("userModel") User user) {
		ums.save(user);
		return "index";
	}
}
