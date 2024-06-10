package com.nt.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookControler {

	
	// http://localhost:8080/msg?name=dev
	@GetMapping("/msg")
	public ModelAndView getMsg(@RequestParam String name) {
		
		String msgTxt=name+" Good evening";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msgTxt);
		
		mav.setViewName("index");
		
		return mav;
	}
	
	// http://localhost:8080/book?name=spring&author=johnson
	@GetMapping("/book")
	public ModelAndView getBookData(@RequestParam String name,String author) {
		System.out.println("name = "+name);
		System.out.println("author = "+author);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", name+ " by "+author+" book is out of stock");
		
		mav.setViewName("index");
		
		return mav;
		
	}
	
}
