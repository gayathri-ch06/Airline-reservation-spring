package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.FlightSeatsOccupancy;
import com.example.demo.models.FlightSeatsOccupancyID;



public interface FlightSeatscOccupancyRepository extends JpaRepository<FlightSeatsOccupancy, FlightSeatsOccupancyID> {
	
    FlightSeatsOccupancy findByFlightIdAndSeatNumber(String flightId, String seatNumber);

}