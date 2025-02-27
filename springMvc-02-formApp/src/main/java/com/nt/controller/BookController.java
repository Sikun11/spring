package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.bindings.Book;

@Controller
public class BookController {

	//method-1:to load form (get)
	@GetMapping("/book")
	public ModelAndView loadForm() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("bookObj", new Book());
		mav.setViewName("bookView");
		return mav;
	}
	
	//method-2:to handle form submission(post)
	@PostMapping("/books")
	public ModelAndView handleBookSubmit(Book book) {
		
		System.out.println(book);
		//Todo:save data into db
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "book saved successfully");
		mav.setViewName("success");
		return mav;
	}
}
