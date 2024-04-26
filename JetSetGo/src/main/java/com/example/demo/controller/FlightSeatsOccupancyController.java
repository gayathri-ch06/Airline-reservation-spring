package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Flight;
import com.example.demo.models.FlightSeatsOccupancy;
import com.example.demo.models.FlightSeatsOccupancyID;
import com.example.demo.services.FlightSeatOccupancyService;

@RestController
public class FlightSeatsOccupancyController {
	
	@Autowired
	private FlightSeatOccupancyService service;
	
	@PostMapping("/addFlightSeats")
    public void addFlightSeats(@RequestBody FlightSeatsOccupancy seats) {
    	
        service.addOrUpdateFlightSeatOccupancy(seats);
    }

}
