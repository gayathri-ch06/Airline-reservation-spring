package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Airport;



public interface AirportRepository extends JpaRepository<Airport, String> {

	List<Airport> findByAirportId(String airportId);

	void deleteByAirportId(String airportId);
}
