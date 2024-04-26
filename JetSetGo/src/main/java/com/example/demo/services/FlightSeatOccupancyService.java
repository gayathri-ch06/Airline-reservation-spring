package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.FlightSeatsOccupancy;
import com.example.demo.models.FlightSeatsOccupancyID;
import com.example.demo.repositories.FlightSeatscOccupancyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FlightSeatOccupancyService {

    @Autowired
    private FlightSeatscOccupancyRepository flightSeatOccupancyRepository;

    // Method to add or update a flight seat occupancy
    public void addOrUpdateFlightSeatOccupancy(FlightSeatsOccupancy flightSeatOccupancy) {
        flightSeatOccupancyRepository.save(flightSeatOccupancy);
    }

    // Method to retrieve all flight seat occupancies
    public List<FlightSeatsOccupancy> getAllFlightSeatOccupancies() {
        return flightSeatOccupancyRepository.findAll();
    }

    // Method to retrieve a flight seat occupancy by flightId and seatNumber
    public FlightSeatsOccupancy getFlightSeatOccupancyById(String flightId, String seatNumber) {
        return flightSeatOccupancyRepository.findByFlightIdAndSeatNumber(flightId, seatNumber);
    }

    // Method to delete a flight seat occupancy by flightId and seatNumber
    public void deleteFlightSeatOccupancyById(String flightId, String seatNumber) {
        flightSeatOccupancyRepository.deleteById(new FlightSeatsOccupancyID(flightId, seatNumber));
    }
}
