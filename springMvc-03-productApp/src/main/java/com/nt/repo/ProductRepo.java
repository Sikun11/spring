package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity,Integer>{

}
