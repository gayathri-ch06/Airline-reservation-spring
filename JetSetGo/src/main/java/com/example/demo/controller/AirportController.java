package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.AirportService;

@RestController
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	
	@GetMapping("/getAirportCodes") 
	public List<String> getAirportCodes() {
		return airportService.getAllAirportCodes();
	}

}
