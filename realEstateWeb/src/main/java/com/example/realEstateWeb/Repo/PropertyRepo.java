package com.example.realEstateWeb.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.realEstateWeb.property.Property;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer>{

}
