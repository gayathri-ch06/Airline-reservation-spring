package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Flight;
import com.example.demo.repositories.FlightRepository;

@Service
public class FlightService {

	@Autowired
    private FlightRepository flightRepository;

    public void addFlight(Flight flight) {
        // Map flightDto to flight entity
        flightRepository.save(flight);
    }
    
    
 // Method to retrieve all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Method to retrieve a flight by ID
    public List<Flight> getFlightByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }
    
    public List<Flight> getFlightByFlightId(int flightId) {
        return flightRepository.findByFlightId(flightId);
    }
    
    public List<Flight> searchFlight(Flight flight) {
        return flightRepository.findBySourceAndDestinationAndDepartureDate(flight.getSource(), flight.getDestination(), flight.getDepartureDate());
    }

    // Method to update an existing flight
    public void updateFlight(int flightId, Flight updatedFlight) {
        List<Flight> existingFlightOptional = flightRepository.findByFlightId(flightId);
        if (!existingFlightOptional.isEmpty()) {
            Flight existingFlight = existingFlightOptional.get(0);
            existingFlight.setSource(updatedFlight.getSource());
            existingFlight.setDestination(updatedFlight.getDestination());
            existingFlight.setDepartureDate(updatedFlight.getDepartureDate());
            existingFlight.setArrivalDate(updatedFlight.getArrivalDate());
            existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
            existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
            flightRepository.save(existingFlight);
        } else {
            // Handle flight not found
            // You can throw an exception or handle it in any other appropriate way
        }
    }

    // Method to delete a flight by ID
    public void deleteFlight(int flightId) {
        flightRepository.deleteByFlightId(flightId);
    }

    

	
}
