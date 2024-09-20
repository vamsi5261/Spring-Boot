package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repo.ProductRepo;

@Service
public class ProductService {

    

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }
    public Product getProductById(int id) {
    	return repo.findById(id).get();
    }
    public Product add(Product p) {
    	return repo.save(p);
    }
    public Product update(int id,Product p ) {
    	return repo.save(p);
    }
    public void delete(int id) {
    	repo.deleteById(id);
    }
}
