package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.bindings.User;

@Controller
public class UserController {

	@GetMapping("/user")
	public ModelAndView loadform() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("userObj", new User());
		mav.setViewName("user");
		return mav;
	}
	
	@PostMapping("/users")
	public ModelAndView handleUserSubmission(User user) {
		System.out.println(user);
		
		//todo:save data in db
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "user deatails saved");
		mav.setViewName("success");
		return mav;
	}
}
