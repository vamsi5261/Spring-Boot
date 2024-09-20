package com.example.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
}
