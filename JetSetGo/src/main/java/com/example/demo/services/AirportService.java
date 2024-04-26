package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Airport;
import com.example.demo.repositories.AirportRepository;

@Service
public class AirportService {
	
	@Autowired
	private AirportRepository airportRepository;

    // Method to add a new airport
    public void addAirport(Airport airport) {
        airportRepository.save(airport);
    }

    // Method to retrieve all airports
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
    
    public List<String> getAllAirportCodes() {
    	List<String> codes = new ArrayList<String>();
    	List<Airport> result = airportRepository.findAll();
    	for (Airport airport: result) {
    		codes.add(airport.getCity() + " (" + airport.getAirportId() +")");
    	}
    	return codes;
    }
    

    // Method to retrieve an airport by ID
    public List<Airport> getAirportById(String airportId) {
        return airportRepository.findByAirportId(airportId);
    }

    // Method to update an existing airport
    public void updateAirport(String airportId, Airport updatedAirport) {
        List<Airport> existingAirportOptional = airportRepository.findByAirportId(airportId);
        if (!existingAirportOptional.isEmpty()) {
            Airport existingAirport = existingAirportOptional.get(0);
            existingAirport.setAirportName(updatedAirport.getAirportName());
            existingAirport.setCity(updatedAirport.getCity());
            existingAirport.setState(updatedAirport.getState());
            existingAirport.setCountry(updatedAirport.getCountry());
            existingAirport.setZipcode(updatedAirport.getZipcode());
            existingAirport.setTimezone(updatedAirport.getTimezone());
            airportRepository.save(existingAirport);
        } else {
            // Handle airport not found
            // You can throw an exception or handle it in any other appropriate way
        }
    }

    // Method to delete an airport by ID
    public void deleteAirport(String airportId) {
        airportRepository.deleteByAirportId(airportId);
    }


}
