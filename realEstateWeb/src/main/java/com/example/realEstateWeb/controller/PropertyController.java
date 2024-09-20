package com.example.realEstateWeb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.realEstateWeb.Service.PropertyService;
import com.example.realEstateWeb.property.Property;

@RestController
//@RequestMapping("/api")
public class PropertyController {
	@Autowired
	private PropertyService service;
//	@GetMapping("/properties")
//	public List<Property> getProperties(){
//		return service.getProperties();
//	}
//	@GetMapping("/properties/{id}")
//	public Property getPropertyById(@PathVariable int id) {
//		return service.getPropertyById(id);
//	}

	@PostMapping("/properties")
	public Property add(@RequestBody Property p) {
		return service.add(p);
	}
//	@PutMapping("/properties/{id}")
//	public Property update(@PathVariable int id,@RequestBody Property p) {
//		return service.update(id, p);
//	}
//	@DeleteMapping("/properties/{id}")
//	public void delete(@PathVariable int id) {
//		service.delete(id);
//	}
}
