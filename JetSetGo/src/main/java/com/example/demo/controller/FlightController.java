package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FlightSearchBody;
import com.example.demo.models.Flight;
import com.example.demo.services.FlightService;

@RestController
public class FlightController {

	@Autowired
    private FlightService flightService;

    @PostMapping("/addFlight")
    public void addFlight(@RequestBody Flight flightdto) {
    	
        flightService.addFlight(flightdto);
    }

    @PostMapping("/searchFlights")
    public List<Flight> searchFlights(@RequestBody FlightSearchBody request) {
        
    	Flight flight = new Flight();
    	flight.setSource(request.getFrom());
    	flight.setSource(flight.getSource().substring(flight.getSource().length() - 4, flight.getSource().length() - 1));
    	flight.setDestination(request.getTo());
    	flight.setDestination(flight.getDestination().substring(flight.getDestination().length() - 4, flight.getDestination().length() - 1));
    	flight.setDepartureDate(request.getDepartureDate());
    	List<Flight> result = flightService.searchFlight(flight);
    	return result;
    }
	
	
}
