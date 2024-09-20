package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService service;
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		//@path variable allows us to access dynamic values from the URL like {id}.
		Product product=service.getProductById(id);
		if(product!=null) {
		return new ResponseEntity<>(product,HttpStatus.OK);}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/products")
	public Product add(@RequestBody Product p) {
		return service.add(p);
	}
	@PutMapping("/product/{id}")
	public Product update(@PathVariable int id,@RequestBody Product p) {
		//@RequestBody when dealing with complex data (e.g., JSON objects) sent in the request body.
		return service.update(id,p);
	}
	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
}
