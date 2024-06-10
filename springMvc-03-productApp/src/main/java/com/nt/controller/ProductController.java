package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.entity.ProductEntity;
import com.nt.service.ProductService;

@Controller
public class ProductController {
     
	@Autowired
	private ProductService	productService;
	
	//load form
	@GetMapping("/")
	public ModelAndView loadForm() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("pObj", new ProductEntity());//for form binding
		mav.setViewName("index");
		return mav;
	}
	
	//save product
	@PostMapping("/product")
	public ModelAndView saveProduct(ProductEntity pObj)
	{
		ModelAndView mav=new ModelAndView();
		
		boolean status=productService.saveProduct(pObj);
		if(status) {
			mav.addObject("smsg","product Saved");
		}
		else {
			mav.addObject("emsg", "failed to save");
		}
		
		mav.addObject("pObj", new ProductEntity());//for form binding
		mav.setViewName("index");
		return mav;
	}
	
	//get product
	@GetMapping("/products")
	public ModelAndView viewProducts() {
		 List<ProductEntity> productlist=productService.getAllProducts();
		 
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("plist", productlist);
		 mav.setViewName("data");
		 
		 return mav;
	}
}
