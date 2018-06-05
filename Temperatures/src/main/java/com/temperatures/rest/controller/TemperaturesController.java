package com.temperatures.rest.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temperatures.rest.exception.ResourceNotFoundException;
import com.temperatures.rest.model.TemperatureF;
import com.temperatures.rest.model.Temperatures;
import com.temperatures.rest.repository.TemperaturesRepository;





@RestController
@RequestMapping("/api")
public class TemperaturesController {
	
	@Autowired
	TemperaturesRepository temperatureRepository;
	
	//Get All Temperatures
	@GetMapping("/temperatures")
	public List<Temperatures> getAllTemperature() {
		
     List<Temperatures>	tlist =temperatureRepository.findAll();
     List list = new ArrayList();
     for(Iterator<Temperatures> itr = tlist.iterator(); itr.hasNext(); ) {
    	 
    	Temperatures t = (Temperatures) itr.next();
    	list.add(t);
    	TemperatureF tf = new TemperatureF();
    	double celsius = t.getTemperature();
    	double fahrenheit = (9.0/5.0)*celsius + 32;
        tf.setId(t.getId());
        tf.setCdate(t.getCreatedAt());
        tf.setUdate(t.getUpdatedAt());
        tf.setTempf(fahrenheit);
        list.add(tf);
    }
	    return list;
	}
	
	// Create a  new Temperature
	@PostMapping("/temperatures")
	public Temperatures createTemperatures(@Valid @RequestBody Temperatures t) {
	    return temperatureRepository.save(t);
	}
	
	
	// Get a single Temperature
	@GetMapping("/temperatures/{id}")
	public Temperatures getTemperatureById(@PathVariable(value = "id") Long tId) {
	    return temperatureRepository.findById(tId)
	            .orElseThrow(() -> new ResourceNotFoundException("Temperature", "id", tId));
	}
	
	
	// Update a Temperature
	@PutMapping("/temperatures/{id}")
	public Temperatures updateTemperature(@PathVariable(value = "id") Long tId,
	                                        @Valid @RequestBody Temperatures tDetails) {

		Temperatures tr = temperatureRepository.findById(tId)
	            .orElseThrow(() -> new ResourceNotFoundException("Temperature", "id", tId));
		
	    tr.setTemperature(tDetails.getTemperature());
	    Temperatures updatedTemperature = temperatureRepository.save(tr);
	    return updatedTemperature;
	}
	
	// Delete a Temperature
	@DeleteMapping("/temperatures/{id}")
	public ResponseEntity<?> deleteTemperature(@PathVariable(value = "id") Long tId) {
		Temperatures tr = temperatureRepository.findById(tId)
	            .orElseThrow(() -> new ResourceNotFoundException("Temperature", "id", tId));

		temperatureRepository.delete(tr);
	    return ResponseEntity.ok().build();
	}

}
