package com.nt.service;

import java.util.List;

import com.nt.entity.ProductEntity;

public interface ProductService {

	public boolean saveProduct(ProductEntity p);
    public List<ProductEntity>	getAllProducts();
}
