package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="flight_seats_occupancy")
@IdClass(FlightSeatsOccupancyID.class)
public class FlightSeatsOccupancy {
	
	@Id
	@Column(name="flight_id")
	private String flightId;
	@Id
	@Column(name="seat_number")
	private String seatNumber;
	private boolean occupancy;
	
	
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
	public boolean isOccupancy() {
		return occupancy;
	}
	public void setOccupancy(boolean occupancy) {
		this.occupancy = occupancy;
	}
	
	
	
}
