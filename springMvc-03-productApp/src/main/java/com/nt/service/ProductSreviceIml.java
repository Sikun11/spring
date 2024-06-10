package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.ProductEntity;
import com.nt.repo.ProductRepo;

@Service
public class ProductSreviceIml implements ProductService{

	@Autowired
	private ProductRepo repo;
	
	@Override
	public boolean saveProduct(ProductEntity p) {
		ProductEntity savedProduct=repo.save(p);
		return savedProduct.getPid()!=null;
	}
	
	@Override
	public List<ProductEntity> getAllProducts(){
		return repo.findAll();
	}
}
