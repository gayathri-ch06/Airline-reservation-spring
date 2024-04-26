package com.example.demo.models;

import java.io.Serializable;


public class FlightSeatsOccupancyID implements Serializable{
	
	
	private String flightId;
	
	private String seatNumber;
	
	

	public FlightSeatsOccupancyID(String flightId, String seatNumber) {
		super();
		this.flightId = flightId;
		this.seatNumber = seatNumber;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	

}
