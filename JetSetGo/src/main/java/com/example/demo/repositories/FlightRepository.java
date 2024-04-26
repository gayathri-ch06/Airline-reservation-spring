package com.example.demo.repositories;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findByFlightNumber(String flight_number);
	
	List<Flight> findByFlightId(int flightId);

	void deleteByFlightId(int flightId);

	List<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, Date departureDate);
}