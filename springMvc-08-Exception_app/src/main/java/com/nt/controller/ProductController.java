package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ProductController {

	@GetMapping("/product/{pid}")
	public String getProduct(@PathVariable("pid") Integer pid,Model model)throws Exception
	{
		if(pid>=100) {
			throw new ProductNotFoundException("invalid product id");
		}else {
			model.addAttribute("msg", "product name: Apple mobile");
		}
		return "index";
	}
}
