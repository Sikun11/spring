package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.User;
import com.nt.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//login page display
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}
	
	//login button handle
	@PostMapping("login")
	public String handleLogin(User user,Model model) {
		User userObj=userService.getUser(user.getEmail(),user.getPwd());
		
		if(userObj==null) {
			model.addAttribute("emsg", "invalid credentials");
			return "index";
		}
		else {
			model.addAttribute("msg", userObj.getName()+" , Welcome to My World");
			return "dashboard";
		}
	}
	
	//register page display
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "registerView";
	}
	
	//register button handle
	@PostMapping("/register")
	public String handleRegister(User user,Model model) {
		boolean status=userService.saveUser(user);
		if(status) {
			model.addAttribute("smsg", "user registered");
		}
		else {
			model.addAttribute("emsg", "registration failed");
		}
		return "registerView";
	}
	
	//logout method
	@GetMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("user",new User());
		return "index";
	}

}
