package com.example.realEstateWeb.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realEstateWeb.Repo.PropertyRepo;
import com.example.realEstateWeb.property.Property;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepo repo;

    public List<Property> getProperties() {
        return repo.findAll();
    }

    public Property getPropertyById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Property add(Property p) {
        return repo.save(p);
    }

    public Property update(int id, Property p) {
        if (repo.existsById(id)) {
            p.setId(id);
            return repo.save(p);
        }
        return null;
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
